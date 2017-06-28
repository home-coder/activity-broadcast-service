package adtv.joysee.com.threeparts.controller;

import android.os.Message;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.ui.ButtonText;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class Controller {
    private static final String TAG = "Controller";
    public ArrayList<LinearLayout> mViewList = new ArrayList<>();

    public void registerView(LinearLayout lview) {
        if (mViewList == null || !mViewList.contains(lview)) {
            mViewList.add(lview);
        }
    }

    public void dispatchMessage(LinearLayout lview, Message msg) {
        switch (msg.what) {
            case Case.CHANGE_TXT:
                Log.e(TAG, "dispatchMessage: ---" );
                ButtonText mlview = (ButtonText) lview;
                if (mlview == null) {
                    Log.e(TAG, "dispatchMessage: null" );
                }
                mlview.setText("hello change");
                break;
            default:
                break;
        }
    }
}
