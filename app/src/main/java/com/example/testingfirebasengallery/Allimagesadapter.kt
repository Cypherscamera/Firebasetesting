package com.example.testingfirebasengallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.items.view.*

class Allimagesadapter(val imagedata: List<Imagesdata>, private val context: FragmentActivity) : RecyclerView.Adapter<Allimagesadapter.viewholder>() {

    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder( LayoutInflater.from(context).inflate(R.layout.items, parent, false))

    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = imagedata[position]
        Glide.with(context).load(item.imageuri).into(holder.itemView.imageView)
        holder.itemView
    }

    override fun getItemCount(): Int {
        return imagedata.size
    }
}