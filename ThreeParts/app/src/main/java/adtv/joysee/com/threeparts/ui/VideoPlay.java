package adtv.joysee.com.threeparts.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import adtv.joysee.com.threeparts.R;

/**
 * Created by jiangxiujie on 17-6-29.
 */
public class VideoPlay extends RelativeLayout implements ViewInfa{
    private static final String TAG = "VideoPlay";

    TextView tv1;
    private SeekBar seekBar;

    public VideoPlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_video, this);
        tv1 = (TextView) findViewById(R.id.textView);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

/*                int process = seekBar.getProgress();
                if (mediaPlayer!=null && mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(process);
                }*/
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

            }
        });
    }

    public void setVideoInfo(String setString) {
        tv1.setText(setString);
    }
}
