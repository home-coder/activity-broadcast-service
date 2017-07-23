package adtv.joysee.com.threeparts.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.common.GetObjectUtils;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class ButtonText extends LinearLayout implements ViewInfa{
    private static final String TAG = "ButtonText";

    public TextView textView;

    public ButtonText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mylinear_layout, this);
        Log.i(TAG, "child count is1 " + getChildCount());
        for(int i = 0; i < getChildCount(); i++)
            Log.i(TAG, "child is1 " + getChildAt(i));
        textView = (TextView)findViewById(R.id.text_view);
    }

    public void setText(String setString) {
        if (textView == null) {
            Log.e(TAG, "setText: ---" );
        }
        textView.setText(setString);
    }

    public void processMessage(Object sender,Message msg) {
        String activityName = GetObjectUtils.getRunningActivityName(getContext());
        Log.e(TAG, "processMessage: " + activityName);

        switch (msg.what) {
            case Case.ButtonTextCase.CHANGE_TXT:
                Log.e(TAG, "dispatchMessage: --- txt");
                ButtonText mlview = (ButtonText) sender;
                if (mlview == null) {
                    Log.e(TAG, "dispatchMessage: null");
                }
                mlview.setText("hello change");
                break;
            default:
                break;
        }
    }
}
