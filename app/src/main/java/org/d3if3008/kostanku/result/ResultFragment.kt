package org.d3if3008.kostanku.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if3008.kostanku.R
import org.d3if3008.kostanku.databinding.FragmentResultBinding
import org.d3if3008.kostanku.model.KategoriKost

class ResultFragment: Fragment() {
    private lateinit var binding : FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUI()
    }

    private fun updateUI() {
        var ukuranKamar = ""
        var fasilitas = ""
        var harga = 0

        binding.ukuranKamar.text = ukuran
        binding.fasilitas.text = personalityType
        binding.harga.text = personalityExpl

        viewModel.setPersonalityExpl(personalityExpl)
    }
}