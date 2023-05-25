package org.d3if3008.kostanku.ui.kriteria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import org.d3if3008.kostanku.model.KategoriKost

class KriteriaViewModel: ViewModel() {

    private var typeCounter = MutableLiveData(0)


    fun increasePoint(point: Int) {
        typeCounter.value = typeCounter.value?.plus(point)
    }

    fun getResult(): KategoriKost {
        val type = typeCounter.value!!.toInt()

        return if (type == 11 ) {
            KategoriKost.TYPE_A
        } else if (type == 12) {
            KategoriKost.TYPE_B
        } else if (type == 13) {
            KategoriKost.TYPE_C
        } else if (type == 101) {
            KategoriKost.TYPE_D
        } else if (type == 102) {
            KategoriKost.TYPE_E
        } else {
            KategoriKost.TYPE_F
        }
    }

}