package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BMICalculator()
            }
        }
    }
}

@Composable
fun BMICalculator() {
    var weightInput by remember { mutableStateOf("") }
    var heightInput by remember { mutableStateOf("") }
    var bmi by remember { mutableStateOf<Double?>(null) }
    var category by remember { mutableStateOf("") }

    fun calculateBMI(weight: Double, heightCm: Double): Double {
        val heightM = heightCm / 100
        return weight / heightM.pow(2)
    }

    fun interpretBMI(bmi: Double): String = when {
        bmi < 18.5 -> "Underweight"
        bmi < 25 -> "Normal weight"
        bmi < 30 -> "Overweight"
        else -> "Obese"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xF3147380), Color(0xFF073179))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Calculator",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = weightInput,
                onValueChange = { weightInput = it },
                label = { Text("Weight (lbs)") },
                singleLine = true
            )

            OutlinedTextField(
                value = heightInput,
                onValueChange = { heightInput = it },
                label = { Text("Height (cm)") },
                singleLine = true

            )

            Button(
                onClick = {
                    val weightLb = weightInput.toDoubleOrNull()
                    val weight = weightLb?.times(0.453592)
                    val height = heightInput.toDoubleOrNull()
                    if (weight != null && height != null && weight > 0 && height > 0) {
                        bmi = calculateBMI(weight, height)
                        category = interpretBMI(bmi!!)
                    } else {
                        bmi = null
                        category = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xEE166C04),
                    contentColor = Color.White
                )
            ) {
                Text("Calculate BMI")
            }

            bmi?.let {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF4F4F4))
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.Green, shape = CircleShape)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text("Your BMI is:", fontSize = 16.sp)
                            Text(
                                text = String.format(Locale.US, "%.2f", bmi),
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = Color(0xFF6C4AB6)
                            )
                            Text(category)
                        }
                    }
                }
            }
        }
    }
}
