package org.d3if3008.kostanku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.d3if3008.kostanku.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Silahkan Input terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CariKost::class.java)
                startActivity(intent)
                binding.edtUsername.setText("")
                binding.edtPassword.setText("")
            }
        }

        binding.loginPage.setOnClickListener {
            Toast.makeText(this,"Silahkan Login Di Bawah!", Toast.LENGTH_SHORT).show()
        }

        binding.daftarPage.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }
}