package com.example.appdevelopment
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.appdevelopment.R

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Find views by their IDs
        usernameEditText = findViewById(R.id.username_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        // Add a text change listener to the username and password EditTexts
        usernameEditText.doOnTextChanged { _, _, _, _ ->
            enableLoginButtonIfFieldsAreFilled()
        }

        passwordEditText.doOnTextChanged { _, _, _, _ ->
            enableLoginButtonIfFieldsAreFilled()
        }

        // Add a click listener to the login button
        loginButton.setOnClickListener {
            login()
        }
    }

    private fun enableLoginButtonIfFieldsAreFilled() {
        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        loginButton.isEnabled = username.isNotEmpty() && password.isNotEmpty()
    }

    private fun login() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val intent = Intent(this, mypage_main::class.java).apply {
            putExtra(EXTRA_MESSAGE, username)}
        startActivity(intent)
    }
}