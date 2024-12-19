package com.fpacheco.kotlin.library.utils

import android.app.Activity
import android.view.View
import android.view.WindowManager
import androidx.core.view.WindowCompat

object FullScreen {
	fun complete(activity: Activity) {
		activity.window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
		activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
	}

	fun withNotificationBar(activity: Activity) {
		activity.window.decorView.systemUiVisibility = (
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
						or View.SYSTEM_UI_FLAG_FULLSCREEN
						or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				)

		activity.window.setFlags(
			WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN
		)


		activity.window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

		WindowCompat.setDecorFitsSystemWindows(activity.window, false)
	}
}