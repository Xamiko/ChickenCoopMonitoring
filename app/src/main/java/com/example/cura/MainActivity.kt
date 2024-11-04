package com.example.cura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cura.compose.infoscreen.InformationScreen
import com.example.cura.compose.mainscreen.MonitorScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            NavigationApp()
        }



    }
}



@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MonitorScreen(
                navigateToInfo = { index -> navController.navigate("info/$index") }
            )
        }

        composable("info/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toInt()
            InformationScreen(
                navigationToMain = { navController.popBackStack() },
                index = index
            )
        }
    }
}


