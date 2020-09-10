package models
import com.google.gson.annotations.SerializedName

data class loginResponse(
    @SerializedName("access_token") var accessToken: String,
    @SerializedName("message") var message: String

)