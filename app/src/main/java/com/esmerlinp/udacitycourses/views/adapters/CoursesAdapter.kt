package com.esmerlinp.udacitycourses.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.esmerlinp.udacitycourses.R
import com.esmerlinp.udacitycourses.interactors.Entities.CoursesEntity
import com.esmerlinp.udacitycourses.interactors.Entities.IntructorsEntity
import com.squareup.picasso.Picasso


class CoursesAdapter(private val courses:List<CoursesEntity>, private val context:Context):RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val courseName = itemView.findViewById<TextView>(R.id.tvCourseName)
        val instructor = itemView.findViewById<TextView>(R.id.tvInstructor)
        val imagen = itemView.findViewById<ImageView>(R.id.imagencurso)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_view, parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return courses.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val course:CoursesEntity = courses[position]
        holder?.courseName?.text = course.title


            if(!course.image.isEmpty()){
                Picasso.with(context).load(course.image).into(holder!!.imagen)
            }





        if(courses[position].instructors.isNotEmpty()){
            val intructor:IntructorsEntity = courses[position].instructors[0]
            holder?.instructor?.text = intructor.name
        }else{
            holder?.instructor?.text = "without instructor"
        }


    }
}