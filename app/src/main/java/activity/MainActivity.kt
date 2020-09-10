package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import Api.ApiClient
import Api.ApiInterface
import android.preference.PreferenceManager
import android.view.View
import com.example.hello.R
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MultipartBody
import okhttp3.RequestBody

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegister.setOnClickListener {
            val intent = Intent(baseContext, RegistrationActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            var email = etUserName.text.toString()
            var password = etPassword.text.toString()

            var error = false

            if (email.isBlank() || email.isEmpty()) {
                error = true
                etUserName.error = "Email is required"
            }

            if (password.isBlank() || password.isEmpty()) {
                error = true
                etPassword.error = "Password is required"
            }

            val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .build()

            if (!error) {
                pbLogin.visibility = View.VISIBLE
                loginUser(requestBody)
            }
        }
    }

    fun loginUser(requestBody: RequestBody) {
        val apiClient =
            ApiClient.buildService(ApiInterface::class.java)
        val loginCall = apiClient.loginStudent(requestBody)

        loginCall.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                pbLogin.visibility = View.GONE
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    pbLogin.visibility = View.GONE
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()

                    var accessToken = response.body()?.accessToken
                    val studentId = response.body()?.studentId
                    var sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.putString("STUDENT_ID_KEY", studentId)
                    editor.apply()
                    val intent = Intent(baseContext, CoursesActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}