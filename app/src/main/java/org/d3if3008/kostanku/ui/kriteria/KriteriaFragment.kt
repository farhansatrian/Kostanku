package org.d3if3008.kostanku.ui.kriteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3008.kostanku.R
import org.d3if3008.kostanku.databinding.FragmentKriteriaBinding

class KriteriaFragment : Fragment() {
    private lateinit var binding: FragmentKriteriaBinding

    private val viewModel: KriteriaViewModel by lazy {
        ViewModelProvider(requireActivity())[KriteriaViewModel::class.java]
    }

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
                Toast.makeText(context, "Silah pilih terlebih dahulu", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            recordAnswer()
            updateQuestion()
            binding.button.text = "Lihat Harga"
            if (binding.button.text == "Lihat Harga") {
                recordAnswer()
                showResult()
                backQuestion()
            }
        }

    }

    private fun recordAnswer() {
        when (binding.radioGroup.checkedRadioButtonId) {
            R.id.kecil -> {
                viewModel.increasePoint(1)
                if (binding.button.text == "Lihat Harga"){
                    viewModel.increasePoint(10)
                }
            }

            R.id.sedang -> {
                viewModel.increasePoint(2)
                if (binding.button.text == "Lihat Harga"){
                    viewModel.increasePoint(100)
                }
            }

            R.id.besar -> {
                viewModel.increasePoint(3)
            }
        }
    }

    private fun updateQuestion() {
        binding.radioGroup.clearCheck()

        binding.imageKecil.setImageResource(R.drawable.ac)
        binding.imageSedang.setImageResource(R.drawable.kipas)
        binding.imageBesar.isInvisible
        binding.besar.isInvisible
    }

    private fun backQuestion(){
        binding.radioGroup.clearCheck()
        binding.imageKecil.setImageResource(R.drawable.kecil)
        binding.imageSedang.setImageResource(R.drawable.sedang)
        binding.imageBesar.isVisible
        binding.besar.isVisible
    }

    private fun showResult() {
        viewModel.getResult()
    }
}
