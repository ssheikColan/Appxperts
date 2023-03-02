package com.example.appxperts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appxperts.databinding.ActivityLoginBinding
import com.example.appxperts.utils.isValidPassword

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityLoginBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)

        binding.login.setOnClickListener{
            var username = binding.username.text.toString()
            var password = binding.passwrd.text.toString()

            //remove
            username ="hi"
            password = "Sheik@123"

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (! password.isValidPassword()){
                    Toast.makeText(applicationContext,"Password must be minimum 6 character alphanumeric.", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }else{
                Toast.makeText(applicationContext,"please fill data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}