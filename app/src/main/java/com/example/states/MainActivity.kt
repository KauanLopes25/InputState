package com.example.states

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.example.states.ui.theme.StatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StatesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TesteEstadosScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TesteEstadosScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val nome = remember {
            mutableStateOf(value = "")
        }
        val idade = remember {
            mutableStateOf(value = "")
        }

        TextField(
            value = nome.value,
            onValueChange = { novoValor ->
                Log.i("Teste",novoValor)
                nome.value = novoValor
            }
        )
        TextField(
            value = idade.value,
            onValueChange = { novoValor ->
                Log.i("Teste",novoValor)
                idade.value = novoValor
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}