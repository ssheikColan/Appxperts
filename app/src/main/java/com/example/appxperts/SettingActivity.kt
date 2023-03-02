package com.example.appxperts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appxperts.databinding.ActivityHomeBinding
import com.example.appxperts.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    var count =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvDefaultPrinterIcrement.text=(count.toString())

        binding.imgPlus.setOnClickListener{
            binding.tvDefaultPrinterIcrement.text=((++count).toString())
        }

        binding.imgMinus.setOnClickListener{
            binding.tvDefaultPrinterIcrement.text=((--count).toString())
        }

        binding.imgHambur.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }




    override fun onBackPressed() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}