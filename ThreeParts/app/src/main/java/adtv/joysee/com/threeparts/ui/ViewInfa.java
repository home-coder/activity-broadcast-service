package adtv.joysee.com.threeparts.ui;

import android.os.Message;

/**
 * Created by jiangxiujie on 17-6-29.
 */
public interface ViewInfa {
        /**
         * 根据msg类型执行不同的操作
         * @param msg
         */
        void processMessage(Object sender,Message msg);

}
