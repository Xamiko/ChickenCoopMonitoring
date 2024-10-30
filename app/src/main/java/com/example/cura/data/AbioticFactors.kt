package com.example.cura.data

data class AbioticFactors(
    val temperature: Float,
    val carbonDioxide: Float,
    val humidity: Float,
    val light: Float
)
val abioticData  = listOf(
    AbioticFactors(temperature = 22.5f, carbonDioxide = 400.0f, humidity = 60.0f, light = 200.0f),
    AbioticFactors(temperature = 23.0f, carbonDioxide = 420.0f, humidity = 55.0f, light = 210.0f),
    AbioticFactors(temperature = 21.5f, carbonDioxide = 390.0f, humidity = 62.0f, light = 205.0f)
)
