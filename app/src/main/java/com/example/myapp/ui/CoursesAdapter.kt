package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.ui.Courses

class CoursesAdapter(var courseList: List<Courses>):RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
      var itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_list_item,parent,false)
        //creates an instance of the view holder that will be displayed
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        //get the item in the current position  and displays it and sets the values from the list to the new created instance of viewholder
        var currentCourse=courseList.get(position)
        holder.courseName.text=currentCourse.courseName
        holder.describe.text=currentCourse.description
        holder.instructor.text=currentCourse.instructor
        holder.code.text=currentCourse.courseCode
    }

    override fun getItemCount(): Int {
        //number of items the recyclerView will hold or how big the list is
        return courseList.size
    }
}
class CoursesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var courseName=itemView.findViewById<TextView>(R.id.tvCourseName)
    var describe=itemView.findViewById<TextView>(R.id.tvDescription)
    var code=itemView.findViewById<TextView>(R.id.tvCode)
    var instructor=itemView.findViewById<TextView>(R.id.tvInstructorName)
}