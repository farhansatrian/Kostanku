package org.d3if3008.kostanku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.d3if3008.kostanku.databinding.ActivityHargaBinding

class Harga : AppCompatActivity() {
    private lateinit var binding: ActivityHargaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHargaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}