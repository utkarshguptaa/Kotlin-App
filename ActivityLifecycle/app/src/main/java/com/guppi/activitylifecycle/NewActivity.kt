package com.guppi.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class NewActivity() : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMoblieNumber = "0123456789"
    val validPassword = arrayOf("thanos","steve","tony","bruce")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {

            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            if ((mobileNumber == validMoblieNumber) && (validPassword.contains(password)))
            {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(
                    this@NewActivity, "Bsdk ke sahi id password dalo !", Toast.LENGTH_LONG).show()
            }


        }


    }
}
