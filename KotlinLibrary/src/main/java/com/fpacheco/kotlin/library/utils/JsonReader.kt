package com.fpacheco.kotlin.library.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

object JsonReader {
	fun <T> readJsonFromResourceToList(context: Context, jsonFile: String): List<T> {
		val jsonString = InputStreamReader(context.assets.open(jsonFile)).use { it.readText() }
		val itemType = object: TypeToken<List<T>>() {}.type
		return Gson().fromJson(jsonString, itemType)
	}

	fun <T> readJsonFromResourceToObject(context: Context, jsonFile: String): T {
		val jsonString = InputStreamReader(context.assets.open(jsonFile)).use { it.readText() }
		val itemType = object: TypeToken<T>() {}.type
		return Gson().fromJson(jsonString, itemType)
	}
}