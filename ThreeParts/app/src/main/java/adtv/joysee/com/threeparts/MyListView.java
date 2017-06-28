package adtv.joysee.com.threeparts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class MyListView extends LinearLayout {
    private static final String TAG = "MyListView";

    public TextView textView = (TextView)findViewById(R.id.text_view);

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mylinear_layout, this);
    }

    public void setText(String setString) {
        textView.setText(setString);
    }
}
