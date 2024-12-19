package com.fpacheco.kotlin.library.common

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

fun EditText.onTextChange(listener: (String) -> Unit) {
	this.addTextChangedListener(object: TextWatcher {
		override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

		override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

		override fun afterTextChanged(s: Editable?) {
			listener(s.toString().trim())
		}
	})
}

fun EditText.empty() {
	this.setText(emptyText())
}

fun EditText.textString(): String {
	return this.text.toString().trim()
}

fun EditText.nonError() {
	this.error = null
}

fun EditText.isEmpty(): Boolean = this.text.toString().isEmpty()

fun EditText.disable() {
	this.isEnabled = false
	this.alpha = 0.5f
}

fun EditText.enable() {
	this.isEnabled = true
	this.alpha = 1.0f
}

fun EditText.cursorToEnd() {
	this.setSelection(this.text.length)
}

fun EditText.validate(regex: String, errorMessage: String) {
	if (!Regex(regex).matches(this.text.toString())) this.error = errorMessage
}

fun EditText.setTextAndCursor(text: String) {
	this.setText(text)
	this.setSelection(text.length)
}