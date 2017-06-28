package adtv.joysee.com.threeparts;

import android.os.Message;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class Controller {
    private static final String TAG = "Controller";
    public ArrayList<LinearLayout> mViewList = new ArrayList<>();
    protected void registerView(LinearLayout lview) {
        if (mViewList == null || !mViewList.contains(lview)) {
            mViewList.add(lview);
        }
    }

    protected void dispatchMessage(LinearLayout lview, Message msg) {
        switch (msg.what) {
            case Case.CHANGE_TXT:
                MyListView mlview = (MyListView) lview;
                mlview.setText("hello change");
                break;
            default:
                break;
        }
    }
}
