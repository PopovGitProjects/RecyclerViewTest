package dev.popov.recyclerviewtest

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import dev.popov.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.Listener {

    private lateinit var binding: ActivityMainBinding
    private val adapter = Adapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editLauncher = registerForActivityResult(ActivityResultContracts
            .StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addViewItem(it.data?.getSerializableExtra("key") as Model)
            }
        }

        init()
    }
    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rcView.adapter = adapter
        btAdd.setOnClickListener {
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        }
    }

    override fun onClick(item: Model) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item", item)
        })
    }

}