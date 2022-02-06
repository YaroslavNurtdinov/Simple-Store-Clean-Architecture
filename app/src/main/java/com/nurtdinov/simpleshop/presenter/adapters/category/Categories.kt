package com.nurtdinov.simpleshop.presenter.adapters.category

import android.graphics.drawable.Drawable

data class Categories(
    val icon: Drawable?,
    val category: String,
    var isChecked: Boolean = false
)