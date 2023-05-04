package org.d3if3008.kostanku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3if3008.kostanku.databinding.ActivityCariKostBinding

class CariKost : AppCompatActivity() {
    private lateinit var binding: ActivityCariKostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCariKostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, Kriteria::class.java)
            startActivity(intent)
        }
    }
}