package com.ldileh.sampleandroidhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.ldileh.androidhelper.ActivityUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "please wait", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            Toast.makeText(this, "move page", Toast.LENGTH_SHORT).show()

            //ActivityUtil.
            ActivityUtil(this@MainActivity).showPage(AActivity::class.java)
        }, 1500)
    }
}
