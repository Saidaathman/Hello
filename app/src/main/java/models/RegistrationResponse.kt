package models


import com.google.gson.annotations.SerializedName


class RegistrationResponse {
    @SerializedName("message") var message: String = ""
    @SerializedName("student") var student: String = ""

}