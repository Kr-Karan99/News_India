package com.example.recycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Logactivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logactivity)
        firebaseAuth = FirebaseAuth.getInstance()

        val bt: Button = findViewById(R.id.btLogin)
        bt.setOnClickListener {
            login()
        }

        val toSignup: TextView =findViewById(R.id.toSignup)
        toSignup.setOnClickListener {
            val intent= Intent(this, Signactivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun login() {
        val em: EditText = findViewById(R.id.emailAddress)
        val ps: EditText = findViewById(R.id.password)
        val email: String = em.text.toString()
        val passWord: String = ps.text.toString()

        firebaseAuth.signInWithEmailAndPassword(email, passWord)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                    val intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }
                else {
                    Toast.makeText(this, "ReTry", Toast.LENGTH_SHORT).show()
                }
            }
    }
}