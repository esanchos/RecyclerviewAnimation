package com.earaujo.recyclerviewanimation

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_rv.view.*

class RecyclerAdapter(
    private val activity: AppCompatActivity,
    private val model: MutableList<String>
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var itemSelected = false
    val fullModel = mutableListOf<String>()

    init {
        fullModel.addAll(model)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder: RecyclerView.ViewHolder
        val v1 = inflater.inflate(R.layout.item_rv, parent, false)
        viewHolder = ViewHolder(v1)
        return viewHolder
    }

    fun selectData(position: Int) {
        if (!itemSelected) {
            itemSelected = true
            var itemToRemove = 0
            val s = model.size - 1
            for (index in 0..s) {
                //remove todos os itens, menos o que eu selecionei
                if (index == position) {
                    itemToRemove = 1
                } else {
                    model.removeAt(itemToRemove)
                    notifyItemRemoved(itemToRemove)
                }
            }
        } else {
            itemSelected = false
            model.clear()
            model.addAll(fullModel)
            notifyDataSetChanged()
        }
    }

    fun selectData2(position: Int) {
        model.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(model[position])
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun setData(item: String) {
            itemView.setOnClickListener {
                selectData(layoutPosition)
            }
            itemView.tv_title.text = item
        }
    }
}