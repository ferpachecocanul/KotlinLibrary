package com.fpacheco.kotlin.library.common

fun Double.roundTo(decimals: Int): Double = "%.${decimals}f".format(this).toDouble()