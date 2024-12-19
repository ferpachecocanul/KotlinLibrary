package com.fpacheco.kotlin.library.common

import androidx.recyclerview.widget.RecyclerView

fun <T> List<T>.hasElements(): Boolean {
	return this.isNotEmpty()
}

fun RecyclerView.Adapter<*>.hasItems(): Boolean {
	return itemCount > 0
}

fun <T> List<T>.validateList(onEmpty: (() -> Unit)? = null): Boolean {
	return if (this.isEmpty()) {
		onEmpty?.invoke() // Ejecuta la acción si la lista está vacía
		false
	} else {
		true
	}
}

fun RecyclerView.setup(adapter: RecyclerView.Adapter<*>, layoutManager: RecyclerView.LayoutManager) {
	this.adapter = adapter
	this.layoutManager = layoutManager
}