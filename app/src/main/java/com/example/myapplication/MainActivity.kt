package com.example.videoplayer

import android.net.Uri
import android.net.Uri.parse
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.VideoView
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)
        //Creating MediaController
        val mediaController = android.widget.MediaController(this)
        mediaController.setAnchorView(videoView)
        //mediaController.show()
        //specify the location of media file
        val uri:Uri = parse("android.resource://" + packageName + "/" + R.raw.dhoni)//"https://media.istockphoto.com/videos/comic-pussycat-moves-in-blue-environment-in-stylish-rhythm-video-id1171483712")////
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()



        Timer().schedule(11000){
        //Log.d("Time = ", videoView.currentPosition.toString())
            var isPlay = videoView.isPlaying
            Log.d("isPlay1 = ", isPlay.toString())
            while(isPlay)
            {
                //videoView.start()
                if(videoView.currentPosition >= 28600)
                {
                    videoView.stopPlayback()
                    break
                }
                Log.d("While Time = ", videoView.currentPosition.toString())

                videoView.pause()
                Thread.sleep(5000)

                videoView.seekTo(videoView.currentPosition+10)
                videoView.start()
                Thread.sleep(10000)

            }

        }
        videoView.stopPlayback()
    }
}

