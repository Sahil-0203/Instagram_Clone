package com.example.instagram_clone

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.instagram_clone.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val signin_btn=findViewById<TextView>(R.id.signIn_link_btn)

        signin_btn.setOnClickListener {
        startActivity(Intent(applicationContext,SignInActivity::class.java))
        finish()

        }

        binding.signupBtn.setOnClickListener {

            val fname_data=binding.fullnameSignup.text.toString()
            val username_data=binding.usernameSignup.text.toString()
            val email_data=binding.emailSignup.text.toString()
            val password_data=binding.passwordSignup.text.toString()

            if (fname_data.isEmpty()) {
                binding.fullnameSignup.error = "Please Enter Your Name"
            }
            else if (username_data.isEmpty()){
                binding.usernameSignup.error="Please Enter UserName"
            }
            else if(email_data.isEmpty()){
                binding.emailSignup.error="Please Enter Email Address"
            }
            else if (!email_data.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()))
            {
                binding.emailSignup.error= "Enter valid Email ID*"
            }
            else if (email_data.length<7)
            {
                binding.emailSignup.error= "Enter Valid Email*"
            }
//            -----------------------------------
            else if (password_data.isEmpty()){
                binding.passwordSignup.error="Please Enter Password"
            }
            else if (password_data.length<8)
            {
                binding.passwordSignup.error= "Minimum 8 character required*"
            }
            else if (!password_data.matches(".*[A-Z].*".toRegex()))
            {
                binding.passwordSignup.error= "Must Contain 1 Upper-Case Character*"
            }
            else if (!password_data.matches(".*[a-z].*".toRegex()))
            {
                binding.passwordSignup.error= "Must Contain 1 Lower-Case Character*"
            }
            else if (!password_data.matches(".*[@#\$%^&+=].*".toRegex())) {
                binding.passwordSignup.error = "Must Contain 1 Special Character (@#\$%^&+=)"
            }
            else{
                createAccount()
            }

        }


    }

    private fun createAccount() {
        val progressDialog=ProgressDialog(this)
        progressDialog.setTitle("Sign UP")
        progressDialog.setMessage("Please Wait...")
        progressDialog.setCancelable(false)
        progressDialog.show()


        val fname_data=binding.fullnameSignup.text.toString()
        val username_data=binding.usernameSignup.text.toString()
        val email_data=binding.emailSignup.text.toString()
        val password_data=binding.passwordSignup.text.toString()
        val auth=FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(email_data,password_data).addOnCompleteListener { task ->
            if (task.isSuccessful){
                startActivity(Intent(applicationContext,MainActivity::class.java))
                finish()
                progressDialog.cancel()
            }
            else
            {
                progressDialog.cancel()
                Toast.makeText(applicationContext,"Failed to signup",Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(applicationContext,SignInActivity::class.java))
        finish()
    }
}