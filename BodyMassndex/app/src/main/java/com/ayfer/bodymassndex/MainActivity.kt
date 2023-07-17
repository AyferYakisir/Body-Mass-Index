package com.ayfer.bodymassndex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var height=findViewById<EditText>(R.id.height)
        var weight=findViewById<EditText>(R.id.weight)
        var calculate=findViewById<Button>(R.id.calculate)
        var conclusion=findViewById<TextView>(R.id.conclusion)

        calculate.setOnClickListener{
            var heightİnformation = height.text.toString().toFloat()/100
            var weightİnformation = weight.text.toString().toFloat()
            var bmi = weightİnformation/(heightİnformation*heightİnformation)
            conclusion.text= bmi.toString()
            if (bmi <= 19) {
                Toast.makeText(applicationContext, "Too Weak", Toast.LENGTH_LONG).show()
            } else if (bmi > 19 && bmi <= 25) {
                Toast.makeText(applicationContext, "Normal Weight", Toast.LENGTH_LONG).show()
            } else if (bmi > 30 && bmi <= 40) {
                Toast.makeText(applicationContext, "Obesity", Toast.LENGTH_LONG).show()
            }
        }
        calculate.setOnLongClickListener{
            height.setText("")
            weight.setText("")
            Toast.makeText(applicationContext,"Memory Cleared",Toast.LENGTH_LONG).show()
            conclusion.text=""
            true
        }
    }
}