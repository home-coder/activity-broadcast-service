package adtv.joysee.com.threeparts.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import adtv.joysee.com.threeparts.R;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class ButtonText extends LinearLayout {
    private static final String TAG = "MyListView";

    public TextView textView;

    public ButtonText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mylinear_layout, this);
        textView = (TextView)findViewById(R.id.text_view);
    }

    public void setText(String setString) {
        if (textView == null) {
            Log.e(TAG, "setText: ---" );
        }
        textView.setText(setString);
    }
}
