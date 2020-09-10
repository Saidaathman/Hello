package models
import activity.Courses
import com.google.gson.annotations.SerializedName


class CoursesResponse {
    data class CoursesResponse(
        @SerializedName("courses") var courses: List<Courses>
    )
}