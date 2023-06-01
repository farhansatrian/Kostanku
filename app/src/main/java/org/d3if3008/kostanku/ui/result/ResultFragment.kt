package org.d3if3008.kostanku.result

import android.content.Intent
import android.net.Uri
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
            super.onViewCreated(view, savedInstanceState)
            binding.whatsappIcon.setOnClickListener {
                val phoneNumber = "6285374111711"
                val uri = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }


    private fun updateUI() {
        var ukuranKamar = ""
        var fasilitas = ""
        var harga = 0
//
//        binding.ukuranKamar.text = ukuran
//        binding.fasilitas.text = personalityType
//        binding.harga.text = personalityExpl
//
//        viewModel.setPersonalityExpl(personalityExpl)
    }
}