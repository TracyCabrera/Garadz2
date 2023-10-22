package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistrationFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_registration)

        val username = findViewById(R.id.usernametextview) as EditText
        val newPassword = findViewById(R.id.newPassword) as EditText
        val confirmPassword = findViewById(R.id.confirmPassword) as EditText
        val registerButton = findViewById(R.id.registerButton) as Button
        val dbHelper = DBHelper(this)

        registerButton.setOnClickListener {
            val username = username.text.toString()
            val newPassword = newPassword.text.toString()
            val confirmPassword = confirmPassword.text.toString()
            val savedata = dbHelper.insertdata(username, newPassword)

            val textView14 = findViewById<TextView>(R.id.textView14)
            textView14.setOnClickListener {

                val intent1 = Intent(this, RegistrationFragment::class.java)
                startActivity(intent1)

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(
                        confirmPassword
                    )
                ) {
                    Toast.makeText(
                        this,
                        "Add Username, Password & Confirm password",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (newPassword.equals(confirmPassword)) {
                        if (savedata == true) {
                            Toast.makeText(this, "SignUp Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, registerButton::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "User Exists", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Password Not Match", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}