package com.example.appxperts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appxperts.R
import com.example.appxperts.model.TitleModel

class ChildTitleAdapter(
    private val courseList: ArrayList<TitleModel>,
    private val context: Context
) : RecyclerView.Adapter<ChildTitleAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildTitleAdapter.CourseViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.title_adapter,
            parent, false
        )

        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChildTitleAdapter.CourseViewHolder, position: Int) {

        holder.courseNameTV.text = courseList.get(position).courseTitle
    }

    override fun getItemCount(): Int {

        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val courseNameTV: TextView = itemView.findViewById(R.id.ivTitle)

    }
}



