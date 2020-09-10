package com.example.hello.Database
import androidx.room.Database
import androidx.room.RoomDatabase
import models.Course
import ke.co.hello.models.Course

@Database(entities = arrayOf(Course::class), version = 1)
abstract class HelloDatabase:RoomDatabase() {
    abstract fun courseDao(): CourseDao
}