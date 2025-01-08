package com.example.hyghealth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userPass: EditText = findViewById(R.id.user_pass)
        val userPassRep: EditText = findViewById(R.id.user_pass_rep)
        val button: Button = findViewById(R.id.button_reg)

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()
            val pass_rep = userPassRep.text.toString().trim()

            if (login == "" || pass == "" || pass_rep == "" || pass != pass_rep)
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userPass.text.clear()
                userPassRep.text.clear()
            }
        }
    }
}