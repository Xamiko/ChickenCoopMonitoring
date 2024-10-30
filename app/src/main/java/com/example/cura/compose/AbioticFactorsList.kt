package com.example.cura.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cura.data.AbioticFactors


@Composable
fun AbioticFactorsList(modifier: Modifier = Modifier, factor: List<AbioticFactors>) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(factor) { _, abioticFactor ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Temperature: ${abioticFactor.temperature}°C")
                Text(text = "Carbon Dioxide: ${abioticFactor.carbonDioxide} ppm")
                Text(text = "Humidity: ${abioticFactor.humidity}%")
                Text(text = "Light: ${abioticFactor.light} lux")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
