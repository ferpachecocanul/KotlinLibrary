package com.fpacheco.kotlin.library.manager

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface

class DialogManager (private val context: Context) {
	private var progressDialog: ProgressDialog? = null
	fun showAlertOneButton(
		title: String,
		message: String,
		positiveButtonClickListener: DialogInterface.OnClickListener? = null
	) {
		val builder = AlertDialog.Builder(context)
		builder.setTitle(title)
		builder.setMessage(message)
		builder.setPositiveButton("OK", positiveButtonClickListener ?: DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() })
		val alertDialog = builder.create()
		alertDialog.show()
	}

	fun showAlertOneButton(
		title: String,
		message: String,
		textButton: String,
		positiveButtonClickListener: DialogInterface.OnClickListener? = null
	) {
		val builder = AlertDialog.Builder(context)
		builder.setTitle(title)
		builder.setMessage(message)
		builder.setPositiveButton(textButton, positiveButtonClickListener ?: DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() })
		val alertDialog = builder.create()
		alertDialog.show()
	}

	fun showAlertTwoButton(
		title: String,
		message: String,
		positiveButtonClickListener: DialogInterface.OnClickListener? = null,
		negativeButtonClickListener: DialogInterface.OnClickListener? = null
	) {
		val builder = AlertDialog.Builder(context)
		builder.setTitle(title)
		builder.setMessage(message)
		builder.setPositiveButton("OK", positiveButtonClickListener ?: DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() })
		builder.setNegativeButton("Cancelar", negativeButtonClickListener ?: DialogInterface.OnClickListener{ dialog, _ ->  dialog.dismiss()})
		val alertDialog = builder.create()
		alertDialog.show()
	}

	fun showAlertTwoButton(
		title: String,
		message: String,
		positiveButton: String,
		positiveButtonClickListener: DialogInterface.OnClickListener? = null,
		negativeButton: String,
		negativeButtonClickListener: DialogInterface.OnClickListener? = null
	) {
		val builder = AlertDialog.Builder(context)
		builder.setTitle(title)
		builder.setMessage(message)
		builder.setPositiveButton(positiveButton, positiveButtonClickListener ?: DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() })
		builder.setNegativeButton(negativeButton, negativeButtonClickListener ?: DialogInterface.OnClickListener{ dialog, _ ->  dialog.dismiss()})
		val alertDialog = builder.create()
		alertDialog.show()
	}

	fun showProgressDialog(message: String) {
		progressDialog?.dismiss()
		progressDialog = ProgressDialog(context)
		progressDialog?.setMessage(message)
		progressDialog?.setCancelable(false)
		progressDialog?.show ()
	}

	fun hideProgressDialog() {
		progressDialog?.dismiss()
	}
}