package com.example.week4taskui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.birthday_view_pager.view.*

class ViewPagerAdapter(var listOfCelebrants: List<Details>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageUse: View = itemView.findViewById(R.id.birthdayImage)
    }
    //Inflate our view holder  layout to display in the viewpager adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        //inflate our layout item_view_pager.xml to show in our view pager adapter
        val view = LayoutInflater.from(parent.context).inflate(R.layout.birthday_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int){
        holder.itemView.apply{
            val currImage = listOfCelebrants[position]
            holder.imageUse.setBackgroundResource(currImage.images)
            imageView3.text = listOfCelebrants[position].name
        }

    }
    //Get the the count of our celebrant objects.
    override fun getItemCount(): Int {
        //return the amount of item in our viewpager
        return listOfCelebrants.size
    }
}