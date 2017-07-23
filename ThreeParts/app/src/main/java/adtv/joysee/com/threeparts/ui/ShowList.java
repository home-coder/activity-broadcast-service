package adtv.joysee.com.threeparts.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.activity.VideoActivity;
import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.bean.ChinaAddress;
import adtv.joysee.com.threeparts.common.GetObjectUtils;
import adtv.joysee.com.threeparts.ui.adapter.AdreesAdapter;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class ShowList extends LinearLayout implements ViewInfa{
    private static final String TAG = "ShowList";
    ListView listView;
    List<ChinaAddress> mlist;
    AdreesAdapter adrAdapter;
    Context mContex;

    public ShowList(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.show_list, this);
        Log.e(TAG, "ShowList: ---1111--");
        Log.i(TAG, "child count is " + getChildCount());
        for(int i = 0; i < getChildCount(); i++)
            Log.i(TAG, "child is " + getChildAt(i));
        /*
        * LinearLayout继承了View，所以天生他就有findViewById方法
        * */
        listView = (ListView)findViewById(R.id.list_view);
        Log.i(TAG, "list view is " + listView);
        mlist = new ArrayList<ChinaAddress>();

        initListView();

        adrAdapter = new AdreesAdapter(mlist, context);
        Log.i(TAG, "set adapter ");
        listView.setAdapter(adrAdapter);
        mContex = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG, "onFinishInflate: ---");

    }

    public void initListView() {
        ChinaAddress hbAdrr = new ChinaAddress("湖北", "仙桃", "机场线");
        ChinaAddress gdAdrr = new ChinaAddress("广东", "广州", "黑人区");
        ChinaAddress twAdrr = new ChinaAddress("台湾", "台北", "阳明山");

        mlist.add(hbAdrr);
        mlist.add(gdAdrr);
        mlist.add(twAdrr);
    }

    /*
    * 数据操作使用list，adapter中操作使用getitem等
    *
    * */
    public void changeStreet() {
        mlist.get(0).setStreet("001");
        mlist.get(1).setStreet("222");
        mlist.get(2).setStreet("333");

        adrAdapter.notifyDataSetChanged();
    }

    public void jumpVideoActivity(Bundle bundle){
        Log.e(TAG, "jumpVideoActivity: --in");
        String activityName = GetObjectUtils.getRunningActivityName(mContex);
        Log.e(TAG, "jumpVideoActivity: " + activityName );

        Intent intent = new Intent(mContex, VideoActivity.class);
        int position = (int) bundle.get("item_position");
        ChinaAddress chinaAddr = (ChinaAddress) adrAdapter.getItem(position);
        String intentStr = chinaAddr.getProvince();
        Log.e(TAG, "jumpVideoActivity: " + intentStr);
        intent.putExtra("video_logo", intentStr);

        mContex.startActivity(intent);
    }

    public void processMessage(Object sender,Message msg) {
        String activityName = GetObjectUtils.getRunningActivityName(getContext());
        Log.e(TAG, "processMessage: " + activityName);

        switch (msg.what) {
            case Case.ShowListCase.CHANGE_STREET:
                Log.e(TAG, "dispatchMessage: -- street");
                changeStreet();
                break;
            case Case.VideoPlayCase.JUMP_VIDEOACTIVITY:
                Log.e(TAG, "dispatchMessage: -- jump activity");
                Log.e(TAG, "dispatchMessage: --getdata" + msg.getData().get("item_position"));
                jumpVideoActivity(msg.getData());
                break;
            default:
                break;
        }
    }
}
