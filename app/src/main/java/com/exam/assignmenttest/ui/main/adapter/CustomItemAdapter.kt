package com.exam.assignmenttest.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exam.assignmenttest.data.model.ItemList
import com.exam.assignmenttest.databinding.AdapterCustomItemsBinding

class CustomItemAdapter(val mList: ArrayList<ItemList>) : RecyclerView.Adapter<CustomItemAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterCustomItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterCustomItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    fun notifyAll(list: ArrayList<ItemList>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(mList[position]){
                binding.tvName.text = this._title
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}