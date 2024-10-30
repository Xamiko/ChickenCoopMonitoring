package com.example.cura.data

import androidx.annotation.DrawableRes
import com.example.cura.R


data class ChickenCoop(
    val nickname: String,
    val description: String,
    @DrawableRes val image: Int
)

val primaryCoop = listOf(

    ChickenCoop(
        "Курятник 1",
        "Описание курятника",
        image = R.drawable.kuryatnik_iz_brusa_foto),
    ChickenCoop(
        "Курятник 2",
        "Описание курятника",
        image = R.drawable.kuryatnik_iz_brusa_foto),
    ChickenCoop(
        "Курятник 3",
        "Описание курятника",
        image = R.drawable.kuryatnik_iz_brusa_foto),
    )

