package com.hackingbuzz.youtubeandroidplayerapinyoutubeplayerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    public static final String API_KEY = " AIzaSyAwk8M2f7BuYgNwzgI_Ejkanh0_g3nrGIU";
    public static final String VIDEO_ID ="MHdsrhdHz-o";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1st Run..u see black screen as android player view.
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view); //initilize youtube player view

    // to Initilize the youtube object we required listener with it for status..failed or success (this) represents
    //2nd run...i have given the video url..so it will show you..loading sign on black screen..
      youTubePlayerView.initialize(API_KEY,  this); // (this)  this represent the OnInitilized Listener..// if we dont write implements line above we have to write like this.. youTubePlayerView.initialize(API_KEY, (YouTubePlayer.OnInitializedListener) this); and also initilize all its methods manully
        // .initilize(Api,this) --> this method is initilizing the object(instance)  of Youtube Player..
        //once it is initialised it can be use to load videos in Youtube Player to see...them.
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) { //youtube player is youtube object coming after initilization.
        // for showing video on youtube screen we need to provide video url here..otherwise it will show loading sign
        if(null == youTubePlayer)  return;

        if(!b) { //if above condition is false...
            youTubePlayer.cueVideo(VIDEO_ID); //play video...

        }







            // other lister you can use for advance configuration.. and for error handling...
        // just telling you not using it....

            youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                @Override
                public void onLoading() {

                }

                @Override
                public void onLoaded(String s) {

                }

                @Override
                public void onAdStarted() {

                }

                @Override
                public void onVideoStarted() {

                }

                @Override
                public void onVideoEnded() {

                }

                @Override
                public void onError(YouTubePlayer.ErrorReason errorReason) {

                }
            });


        youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {

            }

            @Override
            public void onPaused() {

            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        });






    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to Initilize" ,Toast.LENGTH_LONG).show();  // (this) representing OnItemListener..so we using (this) instead of Context ( coz its representing the MainActivity)
    }



}
// after adding Youtube Android Player Api...gradle file will not show the sync option..we need to sync coz you can see
// include *.jar file in gradle dependency...so after include (pasting) jar file in lib folder we need to sync it
//you can sync it using Tools -> Android - > Sync Project with Gradle Files...

// now register in google development console and get API key...for your project to work..
//Youtube API credentials of my Project  AIzaSyAwk8M2f7BuYgNwzgI_Ejkanh0_g3nrGIU

// need internet permission... go to Manifest

// height is wrap content so that we can add other stuff below it...in xml
