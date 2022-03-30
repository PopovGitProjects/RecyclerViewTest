package dev.popov.recyclerviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.popov.recyclerviewtest.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("item") as Model
        binding.apply {
            imageMain.setImageResource(item.imageID)
            title.text = item.title
            description.text = item.discr
        }
    }
}