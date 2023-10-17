package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer

class SplashMessageFragment : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash_message)


        // Initialize the VideoView from your layout XML file
        videoView = findViewById(R.id.videoview)
        val uri = Uri.parse("android.resource://${packageName}/${R.raw.smvideo}")
        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true // Set looping to true
        }
    }

    override fun onResume() {
        super.onResume()
        videoView.start() // Start the video when the activity resumes

    }

    override fun onPause() {
        super.onPause()
        videoView.pause() // Pause the video when the activity pauses
    }

    override fun onDestroy() {
        videoView.stopPlayback() // Stop the video playback when the activity is destroyed
        super.onDestroy()
    }
}