package org.d3if3008.kostanku.ui.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel: ViewModel() {
    private var isAutoSave = MutableLiveData(true)
    private var harga = MutableLiveData<String>()
}