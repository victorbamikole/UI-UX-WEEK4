package com.example.week4taskui

import android.graphics.drawable.Drawable
import android.widget.ImageView


//Create the data class of celebrants
data class Celebrants(
    var profileImage: Int, val name: String,
    val date: String, val days: String, var colorI: Int
)
