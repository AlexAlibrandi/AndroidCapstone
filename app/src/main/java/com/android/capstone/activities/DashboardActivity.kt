package com.android.capstone.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.capstone.databinding.DashboardBinding
import com.android.capstone.imageclassification.ImageClassificationActivity
import com.android.capstone.imageclassification.LiveFeedClassificationActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


private lateinit var dashboardBinding: DashboardBinding

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardBinding = DashboardBinding.inflate(layoutInflater)
        setContentView(dashboardBinding.root)

        dashboardBinding.imageRec.setOnClickListener {
            val intent = Intent(this@DashboardActivity, ImageClassificationActivity::class.java)
            startActivity(intent)
        }
        dashboardBinding.liveFeed.setOnClickListener {
            val intent = Intent(this@DashboardActivity, LiveFeedClassificationActivity::class.java)
            startActivity(intent)
        }
        dashboardBinding.logout.setOnClickListener{
            Firebase.auth.signOut()
            val intent = Intent(this@DashboardActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}