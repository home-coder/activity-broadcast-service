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
    public static Controller getInstance() {
        if (controller == null) {
            return new Controller();
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
            case Case.CHANGE_TXT:
                Log.e(TAG, "dispatchMessage: --- txt");
                ButtonText mlview = (ButtonText) lview;
                if (mlview == null) {
                    Log.e(TAG, "dispatchMessage: null");
                }
                mlview.setText("hello change");
                break;
            case Case.CHANGE_STREET:
                Log.e(TAG, "dispatchMessage: -- street");
                ShowList mshowList = (ShowList) lview;
                mshowList.changeStreet();
                break;
            case Case.SEEK_PROCESS:
                Log.e(TAG, "dispatchMessage: -- seekprocess");
                VideoPlay videoPlay = (VideoPlay) lview;
                videoPlay.setVideoInfo("快进或者快退");
                break;
            case Case.JUMP_VIDEOACTIVITY:
                Log.e(TAG, "dispatchMessage: -- jump activity");
                ShowList mshowList2 = (ShowList) lview;
                Log.e(TAG, "dispatchMessage: --getdata" + msg.getData());
                mshowList2.jumpVideoActivity(msg.getData());
                case Case.SET_VIDEOLOGO:
                    Log.e(TAG, "dispatchMessage: -- videologo");
                    VideoPlay videoPlay2 = (VideoPlay) lview;
                    videoPlay2.setVideoInfo(msg.getData().toString());
            default:
                break;
        }
    }
}
