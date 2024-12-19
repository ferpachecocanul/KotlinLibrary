package com.fpacheco.kotlin.library.common

fun Int.isEven(): Boolean {
	return this % 2 == 0
}

fun Int.isOdd(): Boolean {
	return !this.isEven()
}

fun Int.daysToMillis(): Long = this * 24 * 60 * 60 * 1000L