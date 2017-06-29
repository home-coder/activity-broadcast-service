package adtv.joysee.com.threeparts.activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.controller.Controller;
import adtv.joysee.com.threeparts.ui.VideoPlay;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = "VideoActivity";

    private Button button_play, button_pause, button_stop, button_replay;
    Controller mController;
    VideoPlay videoPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video);
        Log.e(TAG, "onCreate: ---VideoActivity");
        mController = Controller.getInstance();
        Log.e(TAG, "onCreate: --- getInstance ok");
        videoPlay = (VideoPlay) findViewById(R.id.my_videoview);
        Log.e(TAG, "onCreate: --- find view ok");
        initVideoPlay();

        button_play = (Button) findViewById(R.id.button_play);
        button_pause = (Button) findViewById(R.id.button_pause);
        button_stop = (Button) findViewById(R.id.button_stop);
        button_replay = (Button) findViewById(R.id.button_replay);
    }

    protected void initVideoPlay() {
        Intent intent = getIntent();
        String intentGet = intent.getStringExtra("video_logo");
        Log.e(TAG, "initVideoPlay: "  + intentGet);
        Message message = new Message();
        message.what = Case.SET_VIDEOLOGO;
        Bundle bundle = new Bundle();
        bundle.putString("setvidologo", intentGet);
        mController.dispatchMessage(videoPlay, message);
    }
}
