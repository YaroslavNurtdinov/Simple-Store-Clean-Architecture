package com.nurtdinov.simpleshop.presenter.adapters.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nurtdinov.simpleshop.R
import com.nurtdinov.simpleshop.databinding.RowSelectCategoryItemBinding

class CategoryAdapter(private val categories: ArrayList<Categories>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var selectedItemPos = 0
    var lastItemSelectedPos = -1
    var initPosition = true

    inner class ViewHolder(private val binding: RowSelectCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        init {
            binding.selectCategory.setOnClickListener {
                selectedItemPos = adapterPosition

                lastItemSelectedPos = if (lastItemSelectedPos == -1)
                    selectedItemPos
                else {
                    notifyItemChanged(lastItemSelectedPos)
                    selectedItemPos
                }
                notifyItemChanged(selectedItemPos)

                if (initPosition) {
                    notifyItemRangeChanged(0, 1)
                    initPosition = false
                }
            }
        }

        fun bind(category: Categories) {

            binding.apply {
                selectCategory.load(category.icon)
                categoryTextView.text = category.category
            }
        }

        fun selectedItem() {
            binding.apply {
                selectCategory.background =AppCompatResources.getDrawable(context,R.drawable.circle_background_selected)
                selectCategory.setColorFilter(context.getColor(R.color.white))
                categoryTextView.setTextColor(context.getColor(R.color.orange))
            }
        }

        fun unselectedItem() {
            binding.apply {
                selectCategory.background = AppCompatResources.getDrawable(context,R.drawable.circle_background_unselected)
                selectCategory.setColorFilter(context.getColor(R.color.light_grey))
                categoryTextView.setTextColor(context.getColor(R.color.select_category_text_color))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) holder.selectedItem()
        if (position == selectedItemPos) holder.selectedItem()
        else holder.unselectedItem()

        holder.bind(categories[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowSelectCategoryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = categories.size
}