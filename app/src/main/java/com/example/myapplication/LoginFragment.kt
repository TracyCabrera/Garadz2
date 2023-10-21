package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R.id.loginButton

class LoginFragment : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        loginButton = findViewById(R.id.loginButton)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        dbHelper = DBHelper(this)

        loginButton.setOnClickListener{

            val usernamedtx = username.text.toString()
            val passdtx = password.text.toString()

            if (TextUtils.isEmpty(usernamedtx) || TextUtils.isEmpty(passdtx)){
                Toast.makeText(this, "Add Username & Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbHelper.checkuserpass(usernamedtx, passdtx)
                if (checkuser==true){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, success::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Wrong Username", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}