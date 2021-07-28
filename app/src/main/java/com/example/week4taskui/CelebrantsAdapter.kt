package com.example.week4taskui

import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.upcoming_birthdays.view.*

class CelebrantsAdapter(var celebrants: List<Celebrants>):RecyclerView.Adapter<CelebrantsAdapter.CelebrantsViewHolder>() {

    inner class CelebrantsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            val profileImage: CircleImageView = itemView.findViewById(R.id.profImage)
        val sideLine: ImageView = itemView.findViewById(R.id.view8)
//            val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)

    }

    //Inflate our view holder  layout to display in the recycler adapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebrantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_birthdays,parent, false)
        return CelebrantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CelebrantsViewHolder, position: Int) {
        holder.itemView.apply {
            val currentItem = celebrants[position]
            holder.profileImage.setImageResource(currentItem.profileImage)
            celebName.text = currentItem.name
            date.text = currentItem.date
            days.text = currentItem.days
            val color = currentItem.colorI
            val mode = PorterDuff.Mode.DST_OVER
            view8.setColorFilter(color, mode)
// Set PorterDuffColorFilter with color (mode defaults to SRC_ATOP)
            view8.setColorFilter(color)
        }
    }
//Get the the count of our celebrant objects.
    override fun getItemCount(): Int {
        return celebrants.size
    }


}