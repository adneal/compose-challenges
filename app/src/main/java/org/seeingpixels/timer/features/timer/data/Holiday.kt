package org.seeingpixels.timer.features.timer.data

import androidx.compose.ui.graphics.Color
import java.util.*

enum class Holiday(
    val gradientColors: List<Color>,
    val month: Int,
    val dayOfMonth: Int
) {
    Christmas(
        gradientColors = listOf(
            Color(0xffBB010B),
            Color(0xffCD1624),
            Color(0xff006F57),
            Color(0xff23856D)
        ),
        month = Calendar.DECEMBER,
        dayOfMonth = 25
    ),
    NewYears(
        listOf(
            Color(0xff413c69),
            Color(0xff4a47a3),
            Color(0xff709fb0),
            Color(0xffa7c5eb)
        ),
        month = Calendar.DECEMBER,
        dayOfMonth = 31
    ),
    Valentines(
        listOf(
            Color(0xff822659),
            Color(0xffb34180),
            Color(0xffe36bae),
            Color(0xfff8a1d1)
        ),
        month = Calendar.FEBRUARY,
        dayOfMonth = 14
    ),
    Halloween(
        listOf(
            Color(0xfff88f01),
            Color(0xffe27802),
            Color(0xff6a492b),
            Color(0xff58391c)
        ),
        month = Calendar.OCTOBER,
        dayOfMonth = 31
    ),
    StPattysDay(
        listOf(
            Color(0xff36622b),
            Color(0xff729d39),
            Color(0xffc6e377),
            Color(0xfffbfad3)
        ),
        month = Calendar.MARCH,
        dayOfMonth = 17
    ),
    ChineseNewYear(
        listOf(
            Color(0xff900c3f),
            Color(0xffc70039),
            Color(0xffc70039),
            Color(0xffffc300)
        ),
        month = Calendar.FEBRUARY,
        dayOfMonth = 1
    ),
    IndependenceDay(
        listOf(
            Color(0xfff05454),
            Color(0xffe8e8e8),
            Color(0xff30475e),
            Color(0xff222831)
        ),
        month = Calendar.JULY,
        dayOfMonth = 4
    )
}