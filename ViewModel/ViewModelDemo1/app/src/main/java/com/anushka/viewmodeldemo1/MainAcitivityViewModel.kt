package com.anushka.viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainAcitivityViewModel : ViewModel() {
    private var count = 0

    fun getCurrentCount(): Int {
        return count
    }

    fun getUpdatedCount(): Int {
        return ++count
    }
}