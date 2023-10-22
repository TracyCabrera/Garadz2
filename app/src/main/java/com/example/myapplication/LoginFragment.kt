package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R.id.loginButton
import com.example.myapplication.R.id.textView2


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

        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.setOnClickListener {

            val intent1 = Intent(this, RegistrationFragment::class.java)
            startActivity(intent1)
        }

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
                    val intent3 = Intent(this, HomeFragment::class.java)
                    startActivity(intent3)
                }
                else{
                    Toast.makeText(this, "Wrong Username", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
