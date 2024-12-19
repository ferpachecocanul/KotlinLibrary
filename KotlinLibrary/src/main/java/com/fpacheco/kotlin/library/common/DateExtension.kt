package com.fpacheco.kotlin.library.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.formatTo(pattern: String): String {
	val formatter = SimpleDateFormat(pattern, Locale.getDefault())
	return formatter.format(this)
}

fun String.toDateOrNull(pattern: String): Date? {
	return try {
		val formatter = SimpleDateFormat(pattern, Locale.getDefault())
		formatter.parse(this)
	} catch(e: Exception) {
		null
	}
}