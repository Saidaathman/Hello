package activity
import models.Course
import ke.co.hello.models.Course

interface CourseItemClickListener {
    fun onItemClick(course: Course)
}