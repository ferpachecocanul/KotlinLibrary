package com.fpacheco.kotlin.library.common

fun String.removeHyphen(): String {
	return this.replace("-", "")
}

fun emptyText(): String = ""

fun String.isValidEmail(): Boolean {
	return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.capitalizeWords(): String {
	return split(" ").joinToString(" ") { it.lowercase().replaceFirstChar { char -> char.uppercase() } }
}

fun String.isOnlyDigits(): Boolean = this.all { it.isDigit() }

fun String.removeWhitespace(): String = replace("\\s".toRegex(), "")

fun String.limitLength(maxLength: Int): String = if (this.length > maxLength) this.take(maxLength) + "..." else this

fun String.toIntOrZero(): Int = this.toIntOrNull() ?: 0

fun String.removeAccents(): String {
	val accentsMap = mapOf(
		'á' to 'a', 'é' to 'e', 'í' to 'i', 'ó' to 'o', 'ú' to 'u',
		'Á' to 'A', 'É' to 'E', 'Í' to 'I', 'Ó' to 'O', 'Ú' to 'U'
	)
	return this.map { accentsMap[it] ?: it }.joinToString("")
}