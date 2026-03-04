package com.example.states

import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
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
    var backGroundColor by remember {
        mutableStateOf(Color(0,0,0))
    }
    Column(
        modifier = modifier
            .background(backGroundColor)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        var nome by remember {
            mutableStateOf(value = "")
        }
        var idade by remember {
            mutableStateOf(value = "")
        }
        var email by remember {
            mutableStateOf(value = "")
        }
        var jCompose by remember {
            mutableStateOf(value = false)
        }
        var xml by remember {
            mutableStateOf(value = false)
        }
        var sOperacional by remember {
            mutableStateOf(value = "")
        }

        TextField(value = nome, singleLine = true, onValueChange = { novoValor ->
            Log.i("Teste", novoValor)
            nome = novoValor
        }, keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words), placeholder = {
            Text(text = "Digite seu nome e Sobrenome")
        }, label = {
            Text(text = "Nome Completo")
        }, leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person icon",
                tint = Color(42, 78, 182, 255)
            )
        }, trailingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Lock",
                tint = Color(42, 78, 182)
            )
        })
        TextField(
            value = idade, singleLine = true, onValueChange = { novoValor ->
            Log.i("Teste", novoValor)
            idade = novoValor
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), label = {
            Text(text = "Idade")
        }, placeholder = {
            Text(text = "Digite sua Idade")
        }, colors = TextFieldDefaults.colors(
            focusedTextColor = Color(255, 0, 0),
            unfocusedTextColor = Color(230, 0, 255, 255),
            unfocusedPlaceholderColor = Color(0, 0, 0)
        )
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "batata@email")
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(255, 0, 0),
                unfocusedTextColor = Color(230, 0, 255, 255),
                unfocusedPlaceholderColor = Color(0, 0, 0)
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = jCompose,
                onCheckedChange = {jCompose = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor= Color.Red
                )
            )
            Text(text = "Jetpack Compose")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = xml,
                onCheckedChange = {xml = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor= Color.Red
                )
            )
            Text(text = "XML")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "android",
                onClick = {
                    sOperacional = "android"
                }
            )
            Text(text = "Android")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "ios",
                onClick = {
                    sOperacional = "ios"
                }
            )
            Text(text = "IoS")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "wPhone",
                onClick = {
                    sOperacional = "wPhone"
                }
            )
            Text(text = "wPhone")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    backGroundColor = Color.Black
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Black
                ),
                border = BorderStroke(2.dp, Color.Cyan),
                shape = RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp)

            ) {
                Icon(
                  imageVector = Icons.Default.Star,
                    contentDescription = "Star"
                )
                Text(text=" Tema Escuro")
            }
            OutlinedButton(
                onClick = {
                    backGroundColor = Color.White
                }
            ) {
                Text(text=" Tema Claro ")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            var favoritado by remember {
                mutableStateOf(value = true)
            }
            if (favoritado){
                Icon(
                    modifier = Modifier.clickable{
                      favoritado = false
                    }
                        .size(80.dp),
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon",
                    tint = Color.Red
                )
            } else {
                Icon(
                    modifier = Modifier.clickable{
                        favoritado = true
                    }
                        .size(40.dp),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite border icon"
                )
            }
        }
    }
}