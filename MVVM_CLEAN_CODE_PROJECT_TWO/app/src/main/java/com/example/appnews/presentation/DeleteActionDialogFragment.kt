package com.example.appnews.presentation

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DeleteActionDialogFragment : DialogFragment() {

    private var deleteAction: () -> Unit = {}
    private var snackBarAction: () -> Unit = {}

    companion object {
        fun newInstance(
            deleteAction: () -> Unit,
            snackBarAction: () -> Unit
        ): DeleteActionDialogFragment {
            DeleteActionDialogFragment().apply {
                this.deleteAction = deleteAction
                this.snackBarAction = snackBarAction
                return this
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Delete the article from list?")
                .setPositiveButton(
                    "yes"
                ) { dialog, id ->
                    deleteAction.invoke()
                    snackBarAction.invoke()
                }
                .setNegativeButton(
                    "cancel"
                ) { dialog, id -> }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
