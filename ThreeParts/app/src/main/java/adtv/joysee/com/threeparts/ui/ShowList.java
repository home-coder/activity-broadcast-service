package adtv.joysee.com.threeparts.ui;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import adtv.joysee.com.threeparts.R;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class ShowList extends FrameLayout{
    public ShowList(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.show_list, this);
    }

}
