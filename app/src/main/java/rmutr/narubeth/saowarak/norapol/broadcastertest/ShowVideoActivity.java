package rmutr.narubeth.saowarak.norapol.broadcastertest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class ShowVideoActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private TextView titleTextView;
    private VideoView showVideoView;
    private String strTitle, detailString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        //Show Title
        showTitle();

        //Show Video
        showVideo();

    }   // Main Method

    private void showVideo() {

        showVideoView = (VideoView) findViewById(R.id.videoView);
        //String strSourceVideo = "android.resource://" + getPackageName() + "/" + R.raw.talkname1;

        int intSource = getIntent().getIntExtra("Video", 0);

        String strSourceVideo = "android.resource://" + getPackageName() + "/" + intSource;


        MediaController objMediaController = new MediaController(this);
        objMediaController.setAnchorView(showVideoView);
        Uri videoUri = Uri.parse(strSourceVideo);
        showVideoView.setMediaController(objMediaController);
        showVideoView.setVideoURI(videoUri);
        showVideoView.start();

    }   // showVideo

    private void showTitle() {

        strTitle = getIntent().getStringExtra("Title");
        titleTextView = (TextView) findViewById(R.id.txtShowTitleVideo);
        titleTextView.setText(strTitle);

    }

    public void clickBackShowVideo(View view) {
        finish();
    }

    public void clickTest(View view) {

        detailString = getIntent().getStringExtra("Detail");

        Intent intent = new Intent(ShowVideoActivity.this, NameActivity.class);
        intent.putExtra("Title", strTitle);
        intent.putExtra("Detail", detailString);
        startActivity(intent);

    }

}   // Main Class