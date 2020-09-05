 package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hello.Database.HelloDatabase
import kotlinx.android.synthetic.main.row_courses_item.*
 data class Courses(val course_id: Int, val course_name: String, val course_code: Int, val instructor:String, val description:String)


 class CoursesActivity : AppCompatActivity() {
     lateinit var database: HelloDatabase
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_courses)
         database = Room.databaseBuilder(baseContext, HelloDatabase::class.java, "hello-db").build()
         fetchCourses()
         override fun onResponse(call: Call<CoursesResponse>, response: Response<CoursesResponse>) {
             if (response.isSuccessful) {
                 var courseList = response.body()?.courses as List<Course>
                 Thread {
                     courseList.forEach { course ->
                         database.courseDao().insertCourse(course)
                     }
                 }.start()

                 displayCourses(courseList)
             } else {
                 Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                     .show()
             }
         }
     }
 }
         fun fetchCoursesFromDatabase(){
             Thread{
                 val courses = database.courseDao().getAllCourses()

                 runOnUiThread {
                     displayCourses(courses)
                 }
             }.start()
         }


         rvCourses.layoutManager = LinearLayoutManager(baseContext)
         val coursesRecyclerViewAdapter = CoursesRecyclerViewAdapter(coursesList = listOf(

                    Courses(34,"Hardware Electronics",113,"Yasin Barre","Excellent"),
                    Courses(35,"Hardware Design",112,"Yasin Barre","Excellent"),
                    Courses(36,"Entreprenuership",111,"Kelly Murungi","Excellent"),
                    Courses(37,"UI/UX Design",110,"Nyandia Kamawe","Excellent"),
                    Courses(38,"professional development",109,"Rodgers Owoko","Excellent"),
                    Courses(39,"python",108,"James Mwai","Excellent"),
                    Courses(40,"kotlin",107,"John Awour","Excellent"),
                    Courses(41,"UI/UX Development",106,"Jeff Muthondu","Excellent"),
                    Courses(42,"Javasript",105,"Purity Maina","Excellent"),
                    Courses(43,"navigating your journey",104,"Veronica Thamaini","Excellent"),
                    Courses(44,"node js",103,"Purity Maina","Excellent")


                ))
                rvCourses.adapter=coursesRecyclerViewAdapter
            }
        }

