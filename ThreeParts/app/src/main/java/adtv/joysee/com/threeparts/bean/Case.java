package adtv.joysee.com.threeparts.bean;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class Case {
    public static class ButtonTextCase {
        public static final int CHANGE_TXT = 1;
    }

    public static class ShowListCase {
        public static final int CHANGE_STREET = 2;
    }

    public static class VideoPlayCase {
        public static final int SEEK_PROCESS = 4;
        public static final int JUMP_VIDEOACTIVITY = 8;
        public static final int SET_VIDEOLOGO = 16;
    }
}
