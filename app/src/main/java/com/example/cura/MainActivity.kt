package com.example.cura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cura.compose.mainscreen.MonitorScreen
import com.example.cura.compose.infoscreen.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            PoultryApp()
        }



    }
}



@Composable
fun PoultryApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "monitor") {
        composable("monitor") { MonitorScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
    }
}





