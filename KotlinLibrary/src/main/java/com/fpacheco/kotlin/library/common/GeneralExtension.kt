package com.fpacheco.kotlin.library.common

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson

fun Any?.isNotNull() = this != null

fun Any?.isNull() = this == null

fun Context.infoRequiredError(text: String): String? {
	return if (text.isEmpty()) "Información requerida" else null
}

fun Context.showToast(message: String){
	Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
	Toast.makeText(this.context, message, duration).show()
}

fun Fragment.showToast(message: String) {
	Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Context.hideKeyboard(view: View) {
	val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
	inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun <T> T.toJson(): String{
	return Gson().toJson(this)
}

fun <T> String.fromJson(objClass: T): T{
	return Gson().fromJson(this, objClass!!::class.java)
}