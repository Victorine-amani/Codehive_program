package com.example.myapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.CoursesAdapter
import com.example.myapp.R

class CoursesActivity : AppCompatActivity() {
    lateinit var courses:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        cast()
    }
    fun cast(){
        courses=findViewById(R.id.rvCourses)
        var course= listOf(
            Courses("MBD101","Mobile Development","Developing android applications","John Owuor"),
            Courses("FWD101","Front-end Web Development","Developing web apps","Purity Maina"),
            Courses("BD101","Back-end Development","Accessing and manipulating stored data","James Mwai"),
            Courses("UI/UX","UI/UX Research","Learning the user of your product and what are their needs","Joy Wambui"),
            Courses("UI/UX","UI/UX Research","Learning the user of your product and what are their needs","Joy Wambui"),
            Courses("UI/UX","UI/UX Research","Learning the user of your product and what are their needs","Joy Wambui"),
            Courses("UI/UX","UI/UX Research","Learning the user of your product and what are their needs","Joy Wambui"),
            Courses("UI/UX","UI/UX Research","Learning the user of your product and what are their needs","Joy Wambui"),
            Courses("UI/UX","UI/UX Research","Learning the user of your product and what are their needs","Joy Wambui"),
            Courses("UI/UX","UI/UX Research","Learning the user of your product and what are their needs","Joy Wambui")
        )
        var coursesAdapter= CoursesAdapter(course)
        courses.layoutManager=LinearLayoutManager(baseContext)
        courses.adapter=coursesAdapter
    }
    }
