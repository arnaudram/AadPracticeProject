package com.example.aadproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aadproject.R
import com.example.aadproject.data.EntityGads
import com.example.aadproject.databinding.ItemLearningLeaderBinding

class ToplearnersAdapter(private val learners:List<EntityGads>):RecyclerView.Adapter<ToplearnersAdapter.ItemViewHolder>() {

    class ItemViewHolder(private var binding: ItemLearningLeaderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemEntityGads: EntityGads) {
            binding.entityGads=itemEntityGads
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding=DataBindingUtil.inflate<ItemLearningLeaderBinding>(LayoutInflater.from(parent.context),
            R.layout.item_learning_leader,parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
     return learners.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val itemEntityGads=learners[position]
        holder.bind(itemEntityGads)
    }

}