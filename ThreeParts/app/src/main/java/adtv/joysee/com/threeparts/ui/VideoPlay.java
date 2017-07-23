package adtv.joysee.com.threeparts.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.common.GetObjectUtils;

/**
 * Created by jiangxiujie on 17-6-29.
 */
public class VideoPlay extends RelativeLayout implements ViewInfa{
    private static final String TAG = "VideoPlay";

    TextView tv1;
    private SeekBar seekBar;

    public VideoPlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.myvideo_layout, this);
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

    public void processMessage(Object sender,Message msg) {
        String activityName = GetObjectUtils.getRunningActivityName(getContext());
        Log.e(TAG, "processMessage: " + activityName);

        switch (msg.what) {
            case Case.VideoPlayCase.SEEK_PROCESS:
                Log.e(TAG, "dispatchMessage: -- seekprocess");
                setVideoInfo("快进或者快退");
                break;

            case Case.VideoPlayCase.SET_VIDEOLOGO:
                Log.e(TAG, "dispatchMessage: -- videologo" + msg.getData().get("setvidologo").toString());
                setVideoInfo(msg.getData().get("setvidologo").toString());
                break;
            default:
                break;
        }
    }
}
