package com.example.appxperts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appxperts.R
import com.example.appxperts.model.CourseRVModal

class CourseRVAdapter(
    // on below line we are passing variables
    // as course list and context
    private val courseList: ArrayList<CourseRVModal>,
    private val context: Context
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseRVAdapter.CourseViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.catalogue_adapter_new,
            parent, false
        )

        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseRVAdapter.CourseViewHolder, position: Int) {

        holder.courseNameTV.text = courseList.get(position).courseName
        holder.courseIV.setImageResource(courseList.get(position).courseImg)
    }

    override fun getItemCount(): Int {

        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val courseNameTV: TextView = itemView.findViewById(R.id.tvProductName)
        val courseIV: ImageView = itemView.findViewById(R.id.ivProductImage)
    }
}