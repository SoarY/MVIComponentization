package com.soar.delicacy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.soar.delicacy.databinding.ItemRecipeBinding
import com.soar.network.bean.response.RecipesItem

class RecipesAdapter(private val recipes: List<RecipesItem>) : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    private var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemBinding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipesItem = recipes[position]
        holder.itemBinding.tvCaption.text = recipesItem.description
        holder.itemBinding.tvName.text = recipesItem.name
        Glide.with(holder.itemBinding.root.context).load(recipesItem.thumb)
            .into(holder.itemBinding.ivRecipeItemImage)
        holder.itemBinding.rlRecipeItem.setOnClickListener { itemClickListener?.onItemClick(position) }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun getItem(position: Int): RecipesItem {
        return recipes[position]
    }

    fun interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener?) {
        this.itemClickListener = itemClickListener
    }

    class RecipeViewHolder(val itemBinding: ItemRecipeBinding) : RecyclerView.ViewHolder(itemBinding.root)
}

