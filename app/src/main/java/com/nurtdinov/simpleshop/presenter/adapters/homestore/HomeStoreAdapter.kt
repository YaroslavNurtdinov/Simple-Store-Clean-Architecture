package com.nurtdinov.simpleshop.presenter.adapters.homestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nurtdinov.simpleshop.R
import com.nurtdinov.simpleshop.databinding.HomeStoreItemLayoutBinding
import com.nurtdinov.simpleshop.domain.model.HomeStore

class HomeStoreAdapter : RecyclerView.Adapter<HomeStoreAdapter.HomeStoreViewHolder>() {

        private var phonesList = emptyList<HomeStore>()


        fun setData(newData: List<HomeStore>) {
            phonesList = newData
            notifyDataSetChanged()
        }

        class HomeStoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val binding = HomeStoreItemLayoutBinding.bind(itemView)

            fun bind(homeStore: HomeStore) = with(binding) {
                homeStorePictureTextView.load(homeStore.picture) {
                    crossfade(300)
                }
                homeStoreTitleTextView.text = homeStore.title.toString()
                homeStoreSubtitleTextView.text = homeStore.subtitle.toString()

                homeStore.isNew.let {
                    if(it){
                        homeStoreNewTextView.visibility = View.VISIBLE
                    }
                    else{
                        homeStoreNewTextView.visibility = View.INVISIBLE
                    }
                }

                homeStoreBuyNowButton.setOnClickListener {
                    Toast.makeText(binding.root.context,"${homeStore.title.toString()} add to cart", Toast.LENGTH_SHORT).show()
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoreViewHolder {
            return HomeStoreViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_store_item_layout, parent, false)
            )
        }



    override fun getItemCount(): Int = phonesList.size

    override fun onBindViewHolder(holder: HomeStoreViewHolder, position: Int) {
        val currentPhone = phonesList[position]
        holder.bind(currentPhone)
    }


}