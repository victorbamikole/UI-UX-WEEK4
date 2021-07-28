package com.example.week4taskui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Create array list of viewpager adapter
        val images = listOf(
            Details(R.drawable.use1, "It's Victor's Birthday"),
            Details(R.drawable.img7, "It's Ayo's Birthday"),
            Details(R.drawable.img52, "It's Abass's Birthday"),
            Details(R.drawable.img9, "It's Anthony's Birthday"))

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 1

// Add a PageTransformer that translates the next and previous items horizontally
// towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        }
        viewPager.setPageTransformer(pageTransformer)

// The ItemDecoration gives the current (centered) item horizontal margin so that
// it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPager.addItemDecoration(itemDecoration)

        val imageId: Array<Int> = arrayOf(
            R.drawable.img7, R.drawable.new4, R.drawable.img4, R.drawable.img5, R.drawable.new1,R.drawable.new2,
            R.drawable.new3
        )
// Create array list of celebrants
        var celebs = mutableListOf(
            Celebrants(imageId[1],"Ola Machiavelli", "20-10-2020", "30 Days Left", Color.parseColor("#560BAD")),
            Celebrants(imageId[2],"Samuel Garfield", "20-10-2020", "30 Days Left", Color.parseColor("#F72585")),
            Celebrants(imageId[3],"Kome Holmes", "20-10-2020", "30 Days Left", Color.parseColor("#B5179E")),
            Celebrants(imageId[4],"Omolade Rogers", "20-10-2020", "30 Days Left", Color.parseColor("#4CC9F0")),
            Celebrants(imageId[5],"Jadon Sancho", "20-10-2020", "30 Days Left", Color.parseColor("#76ff03")),
            Celebrants(imageId[6],"Marcos Rashford", "20-10-2020", "30 Days Left", Color.parseColor("#ff4081")),
            Celebrants(imageId[0],"David De Gea", "20-10-2020", "30 Days Left", Color.parseColor("#2196f3")))

        val adapter2 =  CelebrantsAdapter(celebs)
        recycleView.adapter =  adapter2
        recycleView.layoutManager = LinearLayoutManager(this)
    }
}