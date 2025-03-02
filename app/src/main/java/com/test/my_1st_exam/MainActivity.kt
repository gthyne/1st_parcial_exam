package com.test.my_1st_exam

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference UI elements
        val tieHours = findViewById<TextInputEditText>(R.id.tieHours)
        val tieRate = findViewById<TextInputEditText>(R.id.tieRate)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Button click event
        btnCalculate.setOnClickListener {
            val hoursWorked = tieHours.text?.toString()?.toDoubleOrNull() ?: 0.0
            val hourlyRate = tieRate.text?.toString()?.toDoubleOrNull() ?: 0.0

            if (hoursWorked > 0 && hourlyRate > 0) {
                val baseSalary = hoursWorked * hourlyRate
                val deduction = baseSalary * 0.07
                val finalSalary = baseSalary - deduction

                tvResult.text = "Salario después de deducciones: C$ %.2f".format(finalSalary)
            } else {
                tvResult.text = "Ingrese valores válidos para calcular."
            }
        }
    }
}
