package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val value: Any =
            setContentView(R.layout.activity_registration)
        btnSignUp.setOnClickListener {
            var firstname = etFirstName.text.toString()
            var lastname = etFirstName.text.toString()
            var email = etEmail.text.toString()
            var phoneNumber = etPhoneNumber.text.toString()
            var password = etPassword.text.toString()
            var confirm = etConfirmPassword.text.toString()
            Toast.makeText(baseContext, password, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, confirm, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, email, Toast.LENGTH_LONG).show()
        }


    }

    }
Any {
    if (response.isSuccessful) {
        makeText(baseContext, response.body()?.message, LENGTH_LONG).show()
        startActivity(Intent(baseContext, MainActivity::class.java))
    } else {
        val show: Any =
            makeText(baseContext, response.errorBody().toString(), LENGTH_LONG)
                .show()
        when {
            !!!status.equals("Success!") -> {
            }
            else -> {
                // ADD  to save  and  read next time
                String strUserName = mEditText1.getText().toString().trim();
                String strPassword = mEditText2.getText().toString().trim();
                if (null == strUserName || strUserName.length() == 0) {
                    // showToast("Enter Your Name");
                    mEditText1.setError( "username is required!" );
                    boolean isUserValidated = false;
                }
                if (null == strPassword || strPassword.length() == 0) {
                    // showToast("Enter Your Password");
                    //isPasswordValidated = false;
                    mEditText2.setError( "password is required!" );
                }
            }
        }

