package com.example.appxperts.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

        //First
        holder.tvUnitAdd.setOnClickListener{
            var i: Int = courseList.get(position).count
            i += 1
            holder.tvUnitQty.text = i.toString()
            courseList.get(position).count = i
            Log.d("hussss",i.toString()+"  "+  holder.tvUnitQty.text)
        }

        holder.tvUnitMinus.setOnClickListener{
            var i: Int = courseList.get(position).count
            i-=1
            if (i>=0){
                holder.tvUnitQty.text=  i.toString()
                courseList.get(position).count = i;
            }
        }

        //second
        holder.tvBoxAdd.setOnClickListener{
            var i: Int = courseList.get(position).childCount
            i += 1
            holder.tvBoxQty.text = i.toString()
            courseList.get(position).childCount = i
            Log.d("hussss",i.toString()+"  "+  holder.tvBoxQty.text)
        }

        holder.tvBoxMinus.setOnClickListener{
            var i: Int = courseList.get(position).childCount
            i-=1
            if (i>=0){
                holder.tvBoxQty.text=  i.toString()
                courseList.get(position).childCount = i;
            }
        }
    }

    override fun getItemCount(): Int {

        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val courseNameTV: TextView = itemView.findViewById(R.id.tvProductName)
        val courseIV: ImageView = itemView.findViewById(R.id.ivProductImage)

        val tvUnitAdd: TextView = itemView.findViewById(R.id.tvUnitAdd)
        val tvUnitQty: TextView = itemView.findViewById(R.id.tvUnitQty)
        val tvUnitMinus: TextView = itemView.findViewById(R.id.tvUnitMinus)

        val tvBoxQty: TextView = itemView.findViewById(R.id.tvBoxQty)
        val tvBoxAdd: TextView = itemView.findViewById(R.id.tvBoxAdd)
        val tvBoxMinus: TextView = itemView.findViewById(R.id.tvBoxMinus)




    }
}