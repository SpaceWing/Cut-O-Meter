package com.example.myfirstapp

import android.animation.ValueAnimator
import android.content.pm.ActivityInfo
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_main.*
import android.os.CountDownTimer
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T






class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        val measureButton: Button = findViewById(R.id.measure_button)
        val welcomeText: TextView = findViewById(R.id.welcome_text)
        val welcomeBunny: ImageView = findViewById(R.id.bunny_image_view)

        val welcomeTextOpenAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_open)
        val welcomeBunnyOpenAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_open)
        val measureButtonOpenAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_open)

        welcomeTextOpenAnimation.duration = 800
        welcomeBunnyOpenAnimation.duration = 800
        measureButtonOpenAnimation.duration = 800

        welcomeBunnyOpenAnimation.startOffset = 100;
        measureButtonOpenAnimation.startOffset = 200;

        welcomeText.startAnimation(welcomeTextOpenAnimation)
        welcomeBunny.startAnimation(welcomeBunnyOpenAnimation)
        measureButton.startAnimation(measureButtonOpenAnimation)
    }


    fun get_measure(view: View){
        val measureButton: Button = findViewById(R.id.measure_button)

        val layoutMain: RelativeLayout = findViewById(R.id.layoutMain)
        val animFadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val secondScreenLayout: RelativeLayout = findViewById(R.id.second_screen)

        val resultLayout: RelativeLayout = findViewById(R.id.one_hundred_percent_layout)
        val resultBunny: ImageView = findViewById(R.id.large_bunny_image_view)
        val circleImageView: ImageView = findViewById(R.id.circle_image_view)

        val resultLayoutAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        val resultBunnyAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_to_left)
        val resultCircleAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate_circle)

        animFadeIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                layoutMain.alpha = 0F


                resultLayoutAnimation.duration = 300
                resultBunnyAnimation.duration = 500
                resultCircleAnimation.duration = 800

                resultLayoutAnimation.startOffset = 100
                resultBunnyAnimation.startOffset = 400
                resultCircleAnimation.startOffset= 100

                secondScreenLayout.alpha = 1F
                resultLayout.startAnimation(resultLayoutAnimation)
                resultBunny.startAnimation(resultBunnyAnimation)
                circleImageView.startAnimation(resultCircleAnimation)
                measureButton.isEnabled = false

            }
            override fun onAnimationRepeat(animation: Animation) {
            }
        })
        animFadeIn.duration = 500
        layoutMain.startAnimation(animFadeIn)
    }

}
