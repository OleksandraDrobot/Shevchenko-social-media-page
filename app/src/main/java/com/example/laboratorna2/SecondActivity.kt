package com.example.laboratorna2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.laboratorna2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToSave.setOnClickListener {
            var resultIntent = Intent(this, MainActivity::class.java)
            resultIntent.putExtra("username", binding.changeName.text.toString() + " " + binding.changeSurname.text.toString())
            setResult(1, resultIntent)
            finish()
        }
    }
}