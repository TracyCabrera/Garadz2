package com.example.myapplication
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity





class NewFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_new)



        var firstnametext = findViewById(R.id.firstname) as EditText
        var lastnametext = findViewById(R.id.lastname) as EditText
        var emailtext = findViewById(R.id.email) as EditText
        var usernametext = findViewById(R.id.username) as EditText
        var passwordtext = findViewById(R.id.password) as EditText
        var registerbutton = findViewById(R.id.registerbutton) as Button




        registerbutton.setOnClickListener {
            var firstname = firstnametext.text.toString();
            var lastname = lastnametext.text.toString();
            var email = emailtext.text.toString();
            var username = usernametext.text.toString();
            var password = passwordtext.text.toString();

            if(isEmpty(firstname) ||isEmpty(lastname) ||isEmpty(email) || isEmpty(username) || isEmpty(password)){

                Toast.makeText(this@NewFragment, "Please fill all fields", Toast.LENGTH_LONG).show()

            }else{

            }

        }
    }
}