package org.d3if3008.kostanku.result

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import org.d3if3008.kostanku.R
import org.d3if3008.kostanku.databinding.FragmentResultBinding
import org.d3if3008.kostanku.model.KategoriKost
import org.d3if3008.kostanku.ui.kriteria.KriteriaViewModel

class ResultFragment : Fragment() {
    private val viewModel: KriteriaViewModel by activityViewModels()
    private lateinit var binding: FragmentResultBinding
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kategoriKost = args.kategoriKost
        updateUI(kategoriKost)

        binding.whatsappIcon.setOnClickListener {
            val phoneNumber = "6285374111711"
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        // Navigasi ke KriteriaFragment saat tombol kembali ditekan
    }
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.resetData()
    }
    private fun updateUI(kategori: KategoriKost) {
        when (kategori) {
            KategoriKost.TYPE_A -> {
                binding.totalResult.text = "2x3"
                binding.textView7.text = "Tidak Ada"
                binding.textView5.text = "Rp. 800000"
                binding.gambarResult.setImageResource(R.drawable.kecil)
            }
            KategoriKost.TYPE_B -> {
                binding.totalResult.text = "2x3"
                binding.textView7.text = "Kipas"
                binding.textView5.text = "Rp. 850000"
                binding.gambarResult.setImageResource(R.drawable.kecil)
            }
            KategoriKost.TYPE_C -> {
                binding.totalResult.text = "2x3"
                binding.textView7.text = "AC"
                binding.textView5.text = "1000000"
                binding.gambarResult.setImageResource(R.drawable.kecil)
            }
            KategoriKost.TYPE_D -> {
                binding.totalResult.text = "4x5"
                binding.textView7.text = "Tidak Ada"
                binding.textView5.text = "1050000"
                binding.gambarResult.setImageResource(R.drawable.sedang)
            }
            KategoriKost.TYPE_E -> {
                binding.totalResult.text = "4x5"
                binding.textView7.text = "Kipas"
                binding.textView5.text = "1100000"
                binding.gambarResult.setImageResource(R.drawable.sedang)
            }
            KategoriKost.TYPE_F -> {
                binding.totalResult.text = "4x5"
                binding.textView7.text = "AC"
                binding.textView5.text = "1250000"
                binding.gambarResult.setImageResource(R.drawable.sedang)
            }
            KategoriKost.TYPE_G -> {
                binding.totalResult.text = "8x9"
                binding.textView7.text = "Tidak Ada"
                binding.textView5.text = "1300000"
                binding.gambarResult.setImageResource(R.drawable.besar)
            }
            KategoriKost.TYPE_H -> {
                binding.totalResult.text = "8x9"
                binding.textView7.text = "Kipas"
                binding.textView5.text = "1350000"
                binding.gambarResult.setImageResource(R.drawable.besar)
            }
            else -> {
                binding.totalResult.text = "8x9"
                binding.textView7.text = "AC"
                binding.textView5.text = "1500000"
                binding.gambarResult.setImageResource(R.drawable.besar)
            }
        }
    }
}