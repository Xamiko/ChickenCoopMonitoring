package com.example.cura.compose.infoscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationScreen( navigationToMain: () -> Unit,
                       index: Int?) {
    var temperature by remember { mutableIntStateOf(25) }
    var humidity by remember { mutableIntStateOf(60) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Adjust Parameters") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            Text("Set Temperature:", fontSize = 20.sp)
            Slider(
                value = temperature.toFloat(),
                onValueChange = { temperature = it.toInt() },
                valueRange = 0f..40f,
                modifier = Modifier.padding(8.dp)
            )
            Text("Temperature: $temperature°C", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Set Humidity:", fontSize = 20.sp)
            Slider(
                value = humidity.toFloat(),
                onValueChange = { humidity = it.toInt() },
                valueRange = 0f..100f,
                modifier = Modifier.padding(8.dp)
            )
            Text("Humidity: $humidity%", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navigationToMain() },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Save and Return")
            }
        }
    }
}

