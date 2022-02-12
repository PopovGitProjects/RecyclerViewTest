package dev.popov.recyclerviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import dev.popov.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rcView.adapter = adapter
        adapter.addViewItem(item = DataForRV)
    }

}