package com.example.appxperts.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appxperts.R
import com.example.appxperts.model.TitleModel

class TitleAdapter(

    private val courseList: ArrayList<TitleModel>,
    private val context: Context,
    private var selectedItemPosition: Int = 0

) : RecyclerView.Adapter<TitleAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TitleAdapter.CourseViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.title_adapter,
            parent, false
        )

        return CourseViewHolder(itemView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: TitleAdapter.CourseViewHolder, position: Int) {

        holder.courseNameTV.text = courseList.get(position).courseTitle

        holder.courseNameTV.setOnClickListener{
            selectedItemPosition = position
            notifyDataSetChanged()
        }
        if(selectedItemPosition == position)
            holder.courseNameTV.setBackgroundColor(Color.parseColor("#ADD8E6"))
        else
            holder.courseNameTV.setBackgroundColor(Color.parseColor("#FFFFFF"))
    }

    override fun getItemCount(): Int {

        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val courseNameTV: TextView = itemView.findViewById(R.id.ivTitle)

    }
}


