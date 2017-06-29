package adtv.joysee.com.threeparts.common;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/**
 * Created by jiangxiujie on 17-6-29.
 */
public class GetObjectUtils {

    public static Activity getActivity(Context context) throws Exception {
        while (!(context instanceof Activity) && context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }

        if (context instanceof Activity) {
            return (Activity) context;
        }
        throw new Exception("Unable to get Activity.");
    }

    public static String getRunningActivityName(Context context) {
        String contextString = context.toString();
        return contextString.substring(contextString.lastIndexOf(".") + 1, contextString.indexOf("@"));
    }
}
