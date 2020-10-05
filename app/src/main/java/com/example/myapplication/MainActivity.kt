package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text6.visibility = View.INVISIBLE

        btn1.setOnClickListener {
            text6.visibility = View.VISIBLE
            val weight: Double = text2.text.toString().toDouble()
            val height: Double = text4.text.toString().toDouble()
            val bmi: Double = (weight * 703) / (height * weight)

            Log.i("msg", "+++weight is ${weight}, height is ${height}, BMI is ${bmi}")
            text6.text = "BMI is ${String.format("%.2f", bmi)}, you are ${bmiRes(bmi)}"
        }

    }

    fun bmiRes(bmi: Double): String {
        var answer = ""
        if (bmi < 18.5) {
            answer = "underweight"
        } else if (bmi > 18.5 && bmi < 24.9) {
            answer = "Normal"
        } else if (bmi > 25 && bmi < 29.9) {
            answer = "overWeight"
        } else
            answer = "Obese"
        return answer
    }
}