package org.d3if3008.kostanku.ui.kriteria

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3008.kostanku.R
import org.d3if3008.kostanku.databinding.FragmentKriteriaBinding

class KriteriaFragment : Fragment() {
    private lateinit var binding: FragmentKriteriaBinding

    private val viewModel: KriteriaViewModel by lazy {
        ViewModelProvider(requireActivity())[KriteriaViewModel::class.java]
    }

    private var questionMaxNumber: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKriteriaBinding.inflate(layoutInflater, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            if (binding.radioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(context, "Silahkan pilih terlebih dahulu", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            recordAnswer()
            nextQuestion()
        }

        viewModel.getIndex().observe(viewLifecycleOwner) {
            if (it == questionMaxNumber - 1) binding.button.text = "Lihat Harga"
            if (it == questionMaxNumber) showResult()
            if (it < questionMaxNumber) updateQuestion()
        }

        questionMaxNumber = viewModel.getLengthQuestion()
        updateQuestion()
    }

//    Menambahkan index
    fun nextQuestion() {
        viewModel.increaseIndex()
    }

//    Record Jawaban
    private fun recordAnswer() {
        when (binding.radioGroup.checkedRadioButtonId) {
            R.id.kecil -> {
                viewModel.increaseHargaKamar(binding.kecil.text.toString().toInt())
                Log.d("Kriteria", viewModel.getResult().toString())
            }
            R.id.sedang -> {
                viewModel.increaseHargaKamar(binding.sedang.text.toString().toInt())
                Log.d("Kriteria", viewModel.getResult().toString())
            }
            R.id.besar -> {
                viewModel.increaseHargaKamar(binding.besar.text.toString().toInt())
                Log.d("Kriteria", viewModel.getResult().toString())
            }
        }
    }

//    Update pertanyaan
    private fun updateQuestion() {
        binding.radioGroup.clearCheck()

        val options = viewModel.getOptions()
        binding.kecil.text = options.harga1.toString()
        binding.imageKecil.setImageResource(options.gambar1)
        binding.sedang.text = options.harga2.toString()
        binding.imageSedang.setImageResource(options.gambar2)
        binding.besar.text = options.harga3.toString()
        binding.imageBesar.setImageResource(options.gambar3)
    }

//    Menampilkan jawaban
    private fun showResult() {
        viewModel.getResult()
    }
}
