package adtv.joysee.com.threeparts.controller;

import android.os.Message;
import java.util.ArrayList;
import adtv.joysee.com.threeparts.ui.ShowList;
import adtv.joysee.com.threeparts.ui.VideoPlay;
import adtv.joysee.com.threeparts.ui.ViewInfa;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class Controller {
    private static final String TAG = "Controller";
    public ArrayList<ViewInfa> mViewList = new ArrayList<>();

    private static Controller controller;
    private ShowList mshowList;
    private VideoPlay videoPlay;
    public static Controller getInstance() {
        if (controller == null) {
            controller =  new Controller();
        }
        return controller;
    }

/*
* 将来作为统一给各个控件发送广播用，当然是模拟出来的广播，就是遍历发送信息的意思
* */
    public void registerView(ViewInfa lview) {
        if (mViewList == null || !mViewList.contains(lview)) {
            mViewList.add(lview);
        }
    }
/*
* 通过各个自定义的空间来实现ViewInfo接口的process方法，
* 然后此处交给不同的控件并调用他们的processmessage方法就好了，封装性
*
* 向上转型的好处 向上转型的好处 向上转型的好处 向上转型的好处 向上转型的好处
* */
    public void dispatchMessage(ViewInfa lview, Message msg) {
            lview.processMessage(lview, msg);
    }
}
