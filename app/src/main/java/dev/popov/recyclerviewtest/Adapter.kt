package dev.popov.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.popov.recyclerviewtest.databinding.RvItemBinding

class Adapter(private val listener: Listener): RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var data = ArrayList<Model>()
    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = RvItemBinding.bind(item)
        fun bind(data: Model, listener: Listener) = with(binding){
            imageGen.setImageResource(data.imageID)
            textTitle.text = data.title
            itemView.setOnClickListener {
                listener.onClick(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    fun addViewItem(item: Model){
        data.add(item)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(item: Model)
    }

}
