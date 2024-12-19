package com.fpacheco.kotlin.library.common

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

fun View.hide(){
	this.visibility = View.GONE
}

fun View.show(){
	this.visibility = View.VISIBLE
}

fun View.setVisibility(visible: Boolean){
    this.visibility = if(visible) View.VISIBLE else View.GONE
}

fun View.fadeInWithResize() {
	this.apply {
		scaleX = 0.5f
		scaleY = 0.5f
		alpha = 0f
		visibility = View.VISIBLE
		animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(200).setListener(null)
	}
}

fun View.fadeOutWithResize() {
	this.animate().scaleX(0.5f).scaleY(0.5f).alpha(0f).setDuration(200).setListener(object: AnimatorListenerAdapter() {
		override fun onAnimationEnd(animation: Animator) {
			this@fadeOutWithResize.visibility = View.GONE
		}
	})
}