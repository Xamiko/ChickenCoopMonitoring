package com.example.cura.compose.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cura.compose.AbioticFactorsList
import com.example.cura.compose.CardChickenCoopList
import com.example.cura.data.abioticData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonitorScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Мониторинг") })
        }
    ) {
            padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Temperature: 25°C", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Humidity: 60%", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(24.dp))


            Button(
                onClick = { navController.navigate("settings") },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Adjust Parameters")
            }
        }
    }
}
