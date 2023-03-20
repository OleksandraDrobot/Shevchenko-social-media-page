package com.example.laboratorna2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.laboratorna2.databinding.ActivityMainBinding
import com.example.laboratorna2.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.settingsButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }
        binding.buttonToEnter.setOnClickListener {
            if (binding.enterLogin.text.toString() == "Shevchenko" && binding.enterPassword.text.toString() == "1814"){
                binding.LayoutToEnter.isVisible = false
            }

            else
                binding.textToError.text = "Wrong password!"
        }
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 1)
        binding.textName.text = data?.getStringExtra("username")
    }


}