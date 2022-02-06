package com.nurtdinov.simpleshop.presenter.adapters.bestseller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nurtdinov.simpleshop.R
import com.nurtdinov.simpleshop.databinding.BestsellerItemLayoutBinding
import com.nurtdinov.simpleshop.domain.model.BestSeller

class BestSellerAdapter() : RecyclerView.Adapter<BestSellerAdapter.HomeViewHolder>() {

    private var phonesList = emptyList<BestSeller>()


    fun setData(newData: List<BestSeller>) {
        phonesList = newData
        notifyDataSetChanged()
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = BestsellerItemLayoutBinding.bind(itemView)

        fun bind(bestSeller: BestSeller) = with(binding) {
            pictureImageView.load(bestSeller.picture) {
                crossfade(300)
            }
            titleTextView.text = bestSeller.title.toString()
            priceWithoutDiscountTextView.text = "$${bestSeller.priceWithoutDiscount}"
            //discountPriceTextView.text = "$${result.discountPrice}"
            //discountPriceTextView.showStrikeThrough(show = true)

            val text = "<strike><font color=\'#757575\'>${bestSeller.discountPrice}</font></strike>"
            discountPriceTextView.text = HtmlCompat.fromHtml(text, FROM_HTML_MODE_COMPACT)

            bestSeller.isFavorites.let {
                if (it) {
                    favoriteImageButton.load(R.drawable.ic_best_seller_favorite_image_true)
                } else {
                    favoriteImageButton.load(R.drawable.ic_best_seller_favorite_image_false)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.bestseller_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentPhone = phonesList[position]
        holder.bind(currentPhone)
    }

    override fun getItemCount(): Int = phonesList.size


}