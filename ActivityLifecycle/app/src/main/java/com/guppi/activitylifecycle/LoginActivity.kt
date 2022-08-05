package com.guppi.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity() : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMoblieNumber = "0123456789"
    val validPassword = arrayOf( "tony","steve","bruce","thanos")

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val isLoggedIn =sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn)
        {
            val intent = Intent(applicationContext, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_login)
        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {

            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger ="Avenger"

            val intent = Intent(applicationContext, AvengersActivity::class.java)

            if ((mobileNumber == validMoblieNumber) )
            {

                if (password ==validPassword[0]) {
                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                }
                else if (password==validPassword[1]) {
                    savePreferences(nameOfAvenger)
                    nameOfAvenger = "Captian America"
                    startActivity(intent)
                }
                else if (password==validPassword[2]) {
                    savePreferences(nameOfAvenger)
                    nameOfAvenger = "The Hulk"
                    startActivity(intent)
                }
                else if (password==validPassword[3]) {
                    savePreferences(nameOfAvenger)
                    nameOfAvenger = "The Avengers"
                    startActivity(intent)
                }



            }
            else
            {
                Toast.makeText(
                    this@LoginActivity, "Bsdk ke sahi id password dalo !", Toast.LENGTH_LONG).show()
            }


        }



    }
    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String)
    {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
