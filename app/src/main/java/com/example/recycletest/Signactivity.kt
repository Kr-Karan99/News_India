package com.example.recycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signactivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signactivity)

        firebaseAuth = FirebaseAuth.getInstance()

        val bt: Button = findViewById(R.id.buttonSign)
        bt.setOnClickListener {
            signUp()
        }

        val skip: TextView = findViewById(R.id.skipbtn)
        skip.setOnClickListener {

            val i = Intent(this@Signactivity, MainActivity::class.java)
            startActivity(i)
        }

        val toLogin: TextView =findViewById(R.id.toLogin)
        toLogin.setOnClickListener {
            val intent= Intent(this, Logactivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun signUp() {
        val em: EditText = findViewById(R.id.emailAddress)
        val ps: EditText = findViewById(R.id.password)
        val cp: EditText = findViewById(R.id.conformPassword)
        val email: String = em.text.toString()
        val passWord: String = ps.text.toString()
        val cpassword:String=cp.text.toString()

        if(passWord!=cpassword){
            Toast.makeText(this, "Password not matching", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, passWord)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                    val intent= Intent(this, Logactivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    Toast.makeText(this, "ReTry", Toast.LENGTH_SHORT).show()
                }
            }


    }
}