package com.example.alcoolVsGasolina

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alcoolVsGasolina.ui.theme.AlcoolVsGasolinaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlcoolVsGasolinaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AlcoolVsGasolina()
                }
            }
        }
    }
}

@Composable
fun AlcoolVsGasolina(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Álcool ou Gasolina ?",
            style = TextStyle(
                color = Color.LightGray,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )

        val valorGasolina = remember { mutableStateOf("") }
        val valorAlcool = remember { mutableStateOf("") }
        val resultado = remember { mutableStateOf("") }

        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = valorGasolina.value,
            onValueChange = { newValue ->
                valorGasolina.value = newValue.replace(",", ".")
            },
            label = {
                Text(text = "Digite o valor da gasolina" )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = valorAlcool.value,
            onValueChange = { newValue ->
                valorAlcool.value = newValue.replace(",", ".")
            },
            label = {
                Text(text = "Digite o valor do álcool" )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            if (valorGasolina.value.isNotEmpty() && valorAlcool.value.isNotEmpty()) {
                val result = valorAlcool.value.toDouble() / valorGasolina.value.toDouble() > 0.7
                resultado.value = if (result) {
                    "Melhor abastecer com gasolina"
                } else {
                    "Melhor abastecer com alcool"
                }
            }
        }) {
            Text("Calcular", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.size(16.dp))
        Text(text = resultado.value)
    }
}

@Preview(showBackground = true)
@Composable
fun AlcoolVsGasolinaPreview() {
    AlcoolVsGasolinaTheme {
        AlcoolVsGasolina()
    }
}