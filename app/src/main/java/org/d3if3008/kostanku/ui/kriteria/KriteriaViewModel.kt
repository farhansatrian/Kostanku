package org.d3if3008.kostanku.ui.kriteria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3008.kostanku.R
import org.d3if3008.kostanku.model.KamarOptions

class KriteriaViewModel : ViewModel() {
    private var typeCounterKamar = MutableLiveData(0)
    private var typeCounterFasilitas = MutableLiveData(0)
    private var indexAt = MutableLiveData(0)

    private val harga = listOf(
        KamarOptions(
            800000,
            1000000,
            1300000,
            R.drawable.kecil,
            R.drawable.sedang,
            R.drawable.besar
        ),
        KamarOptions(0, 50000, 200000, R.drawable.kosongan, R.drawable.kipas, R.drawable.ac)
    )

    //    Mengambil index
    fun getIndex(): MutableLiveData<Int> = indexAt

    //    Mengambil pilihan tiap options
    fun getOptions(): KamarOptions {
        if (harga.size == indexAt.value) {
            indexAt.value = 0
        }
        return harga[indexAt.value?.toInt()!!]
    }

    //    Nambah index
    fun increaseIndex() {
        indexAt.value = if (indexAt.value == harga.size) indexAt.value else indexAt.value?.plus(1)
    }

    //    Mencari panjang list
    fun getLengthQuestion(): Int = harga.size

    //    Nambah Harga
    fun increaseHargaKamar(point: Int) {
        typeCounterKamar.value = typeCounterKamar.value?.plus(point)
    }

    //    Menjumlahkan hasil
    fun getResult(): Int {
        val kamar = typeCounterKamar.value!!.toInt()
        val fasilitas = typeCounterFasilitas.value!!.toInt()
        val total = kamar + fasilitas
        return total
    }

}
