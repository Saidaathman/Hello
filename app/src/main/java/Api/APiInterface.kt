package Api
import models.CoursesResponse
import models.loginResponse
import ke.co.hello.RegistrationResponse

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import models.RegistrationResponse as RegistrationResponse


interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): android.telecom.Call<RegistrationResponse>

    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<loginResponse>

    @GET("courses")
    fun getCourses(@Header("Authorization") accessToken: String): Call<CoursesResponse>


}