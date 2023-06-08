package org.d3if3008.kostanku.ui.kriteria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3008.kostanku.R
import org.d3if3008.kostanku.model.KamarOptions
import org.d3if3008.kostanku.model.KategoriKost
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class KriteriaViewModel : ViewModel() {
    private var typeCounterKamar = MutableLiveData(0)
    private var typeCounterFasilitas = MutableLiveData(0)
    private var indexAt = MutableLiveData(0)
    private val _kategoriKost = MutableLiveData<KategoriKost>()

    private lateinit var navController: NavController

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    private val harga = listOf(
        KamarOptions(
            800000,
            1050000,
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
        val kamar = typeCounterKamar.value?.toInt() ?: 0
        val fasilitas = typeCounterFasilitas.value?.toInt() ?: 0
        val total = kamar + fasilitas
        return total
    }

    fun resetData() {
        typeCounterKamar.value = 0
        typeCounterFasilitas.value = 0
        indexAt.value = 0
    }


    fun getKategori(): KategoriKost {
        val harga = getResult()

        return when (harga) {
            800000 -> KategoriKost.TYPE_A
            850000 -> KategoriKost.TYPE_B
            1000000 -> KategoriKost.TYPE_C
            1050000 -> KategoriKost.TYPE_D
            1100000 -> KategoriKost.TYPE_E
            1250000 -> KategoriKost.TYPE_F
            1300000 -> KategoriKost.TYPE_G
            1350000 -> KategoriKost.TYPE_H
            else -> KategoriKost.TYPE_I
        }
    }
}
