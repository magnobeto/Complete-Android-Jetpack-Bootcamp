package com.example.appnews.presentation

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DeleteActionDialogFragment : DialogFragment() {

    private var deleteAction: () -> Unit = {}
    private var cancelAction: () -> Unit = {}

    companion object {
        fun newInstance(
            deleteAction: () -> Unit,
            cancelAction: () -> Unit
        ): DeleteActionDialogFragment {
            DeleteActionDialogFragment().apply {
                this.deleteAction = deleteAction
                this.cancelAction = cancelAction
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
                }
                .setNegativeButton(
                    "cancel"
                ) { dialog, id ->
                    cancelAction.invoke()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
