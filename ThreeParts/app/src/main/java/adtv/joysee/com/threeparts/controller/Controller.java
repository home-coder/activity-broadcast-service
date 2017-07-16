package adtv.joysee.com.threeparts.controller;

import android.os.Message;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.ui.ButtonText;
import adtv.joysee.com.threeparts.ui.ShowList;
import adtv.joysee.com.threeparts.ui.VideoPlay;
import adtv.joysee.com.threeparts.ui.ViewInfa;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class Controller {
    private static final String TAG = "Controller";
    public ArrayList<LinearLayout> mViewList = new ArrayList<>();

    private static Controller controller;
    private ShowList mshowList;
    private VideoPlay videoPlay;
    public static Controller getInstance() {
        if (controller == null) {
            controller =  new Controller();
        }
        return controller;
    }

    public void registerView(LinearLayout lview) {
        if (mViewList == null || !mViewList.contains(lview)) {
            mViewList.add(lview);
        }
    }

    public void dispatchMessage(ViewInfa lview, Message msg) {
        switch (msg.what) {
            case Case.ButtonTextCase.CHANGE_TXT:
                Log.e(TAG, "dispatchMessage: --- txt");
                ButtonText mlview = (ButtonText) lview;
                if (mlview == null) {
                    Log.e(TAG, "dispatchMessage: null");
                }
                mlview.setText("hello change");
                break;
            case Case.ShowListCase.CHANGE_STREET:
                Log.e(TAG, "dispatchMessage: -- street");
                mshowList = (ShowList) lview;
                mshowList.changeStreet();
                break;
            case Case.VideoPlayCase.SEEK_PROCESS:
                Log.e(TAG, "dispatchMessage: -- seekprocess");
                videoPlay = (VideoPlay) lview;
                videoPlay.setVideoInfo("快进或者快退");
                break;
            case Case.VideoPlayCase.JUMP_VIDEOACTIVITY:
                mshowList = (ShowList) lview;
                Log.e(TAG, "dispatchMessage: -- jump activity");
                Log.e(TAG, "dispatchMessage: --getdata" + msg.getData().get("item_position"));
                mshowList.jumpVideoActivity(msg.getData());
                break;
            case Case.VideoPlayCase.SET_VIDEOLOGO:
                videoPlay = (VideoPlay) lview;
                Log.e(TAG, "dispatchMessage: -- videologo" + msg.getData().get("setvidologo").toString());
                videoPlay.setVideoInfo(msg.getData().get("setvidologo").toString());
                break;
            default:
                break;
        }
    }
}
