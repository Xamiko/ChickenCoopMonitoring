package com.example.cura.compose.infoscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cura.compose.AbioticFactorsList
import com.example.cura.data.AbioticFactors
import com.example.cura.data.ChickenCoop
import com.example.cura.data.abioticData
import com.example.cura.data.primaryCoop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationScreen(
    navigationToMain: () -> Unit,
    index: Int?
) {
    var temperature by remember { mutableIntStateOf(25) }
    var humidity by remember { mutableIntStateOf(60) }
    var light by remember { mutableIntStateOf(60) }
    var additionalFactor by remember { mutableIntStateOf(60) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Environmental Parameters") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (index != null) {
                val chickenCoop = primaryCoop[index]
                val factors = abioticData[index]
                InfoHeader(chickenCoop)
                AbioticFactorsSection(factors)
                Spacer(modifier = Modifier.height(20.dp))
                Column (modifier = Modifier.verticalScroll(rememberScrollState())){
                    SliderSetting(
                        title = "Set Temperature:",
                        value = temperature,
                        onValueChange = { temperature = it },
                        valueRange = 0f..40f,
                        unit = "°C"
                    )
                    SliderSetting(
                        title = "Set Humidity:",
                        value = humidity,
                        onValueChange = { humidity = it },
                        valueRange = 0f..100f,
                        unit = "%"
                    )
                    SliderSetting(
                        title = "Set Lighting:",
                        value = light,
                        onValueChange = { light = it },
                        valueRange = 0f..100f,
                        unit = "lux"
                    )

                    SliderSetting(
                        title = "Set Additional Factor:",
                        value = additionalFactor,
                        onValueChange = { additionalFactor = it },
                        valueRange = 0f..100f,
                        unit = "units"
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    onClick = { navigationToMain() }
                ) {
                    Text("Save and Return")
                }
            } else {
                InvalidDataMessage()
            }
        }
    }
}

@Composable
fun InfoHeader(chickenCoop: ChickenCoop) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Chicken Coop: ${chickenCoop.nickname}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = chickenCoop.description,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun AbioticFactorsSection(factors: AbioticFactors) {
    Text(
        text = "Abiotic Factors",
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.DarkGray,
        modifier = Modifier.padding(vertical = 8.dp)
    )
    AbioticFactorsList(factor = listOf(factors))
}

@Composable
fun SliderSetting(
    title: String,
    value: Int,
    onValueChange: (Int) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    unit: String
) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(title, fontSize = 20.sp)
        Slider(
            value = value.toFloat(),
            onValueChange = { onValueChange(it.toInt()) },
            valueRange = valueRange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Text("$value $unit", fontSize = 18.sp)
    }
}


@Composable
fun InvalidDataMessage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Invalid data. Please try again.",
            fontSize = 18.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }
}
