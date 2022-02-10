package dev.popov.recyclerviewtest

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.popov.recyclerviewtest.databinding.RvItemBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder> {
    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = RvItemBinding.bind(item)
        fun bind(data: Model) = with(binding){
            imageGen.setImageResource(data.imageID)
            textTitle.text = data.title
        }
    }
}