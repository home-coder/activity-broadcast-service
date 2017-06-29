package adtv.joysee.com.threeparts.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import adtv.joysee.com.threeparts.R;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = "VideoActivity";

    private Button button_play, button_pause, button_stop, button_replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        button_play = (Button) findViewById(R.id.button_play);
        button_pause = (Button) findViewById(R.id.button_pause);
        button_stop = (Button) findViewById(R.id.button_stop);
        button_replay = (Button) findViewById(R.id.button_replay);
    }
}
