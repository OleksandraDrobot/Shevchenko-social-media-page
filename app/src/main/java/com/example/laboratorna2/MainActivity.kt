package com.example.laboratorna2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.laboratorna2.databinding.ActivityMainBinding
import com.example.laboratorna2.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val SELECT_PICTURE = 111
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

        binding.mainPhoto.setOnClickListener {
            imageChooser();
        }
    }

    fun imageChooser() {
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 1) {
            binding.textName.text = data?.getStringExtra("username")

        }
        if (requestCode == SELECT_PICTURE) {
            val selectedImageUri: Uri? = data?.data
            if (null != selectedImageUri) {
                // update the preview image in the layout
                binding.mainPhoto.setImageURI(selectedImageUri)
            }
        }
    }

}