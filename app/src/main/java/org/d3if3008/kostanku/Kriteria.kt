package org.d3if3008.kostanku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3if3008.kostanku.databinding.ActivityKriteriaBinding

class Kriteria : AppCompatActivity() {
    private lateinit var binding: ActivityKriteriaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKriteriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, Harga::class.java)
            startActivity(intent)
        }
    }
}