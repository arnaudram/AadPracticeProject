package com.example.aadproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aadproject.R
import com.example.aadproject.data.EntityGads
import com.example.aadproject.data.EntityGadsSkill
import com.example.aadproject.databinding.ItemSkillIqLeaderBinding

class TopSkillIqAdapter:ListAdapter<EntityGadsSkill,TopSkillIqAdapter.ItemViewHolder>(DiffutillCallback) {

    class ItemViewHolder(var binding: ItemSkillIqLeaderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EntityGadsSkill?) {
            item?.let {
                binding.entityGadsSkill=item
                binding.executePendingBindings()
            }

        }

    }

    companion object DiffutillCallback:DiffUtil.ItemCallback<EntityGadsSkill>() {
       override fun areItemsTheSame(oldItem: EntityGadsSkill, newItem: EntityGadsSkill): Boolean {
           return oldItem===newItem
       }

       override fun areContentsTheSame(oldItem: EntityGadsSkill, newItem: EntityGadsSkill): Boolean {
          return oldItem.name==newItem.name
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding=DataBindingUtil.inflate<ItemSkillIqLeaderBinding>(LayoutInflater.from(parent.context),
            R.layout.item_skill_iq_leader,parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }
}