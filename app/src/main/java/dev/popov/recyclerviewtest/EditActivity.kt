package dev.popov.recyclerviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.popov.recyclerviewtest.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    private var imageIndex = 0
    private val imageData = DataForRV
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }
    private fun initButtons() = with(binding){
        btNextImg.setOnClickListener {
            imageIndex++
            if (imageIndex > imageData.imageID.size - 1){
                imageIndex = 0
            }
            imageView.setImageResource(imageData.imageID[imageIndex])
        }
        btDone.setOnClickListener {
            val item = Model(imageData.imageID[imageIndex],
                edTitle.text.toString(),
                edDescription.text.toString()
            )
            val editIntent = Intent().apply {
                putExtra("key", item)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}