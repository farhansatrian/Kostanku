package org.d3if3008.kostanku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.d3if3008.kostanku.databinding.ActivityLoginBinding
import org.d3if3008.kostanku.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegist.setOnClickListener{
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            val email = binding.edtEmail.text.toString()

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()){
                Toast.makeText(this,"Silahkan Input terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Daftar Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CariKost::class.java)
                startActivity(intent)
                binding.edtUsername.setText("")
                binding.edtPassword.setText("")
            }
        }

        binding.daftarPage.setOnClickListener {
            Toast.makeText(this,"Silahkan Register Di Bawah!", Toast.LENGTH_SHORT).show()
        }

        binding.loginPage.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}