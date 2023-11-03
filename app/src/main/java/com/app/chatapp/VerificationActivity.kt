package com.app.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.chatapp.databinding.ActivityVerificationBinding
import com.google.firebase.auth.FirebaseAuth

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVerificationBinding
    var auth: FirebaseAuth?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityVerificationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        if(auth!!.currentUser!=null){
            startActivity(Intent(this@VerificationActivity, MainActivity::class.java))
            finish()
        }
        binding.phonenumber.requestFocus()
        binding.con.setOnClickListener {
            var intent = Intent(this@VerificationActivity, OTPActivity::class.java)
            intent.putExtra("phoneNumber", binding.phonenumber.text.toString())
            startActivity(intent)
        }
    }
}