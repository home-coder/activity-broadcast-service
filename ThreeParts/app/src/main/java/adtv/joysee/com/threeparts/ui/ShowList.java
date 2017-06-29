package adtv.joysee.com.threeparts.ui;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.bean.ChinaAddress;
import adtv.joysee.com.threeparts.ui.adapter.AdreesAdapter;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class ShowList extends LinearLayout implements ViewInfa{
    private static final String TAG = "ShowList";
    ListView listView;
    List<ChinaAddress> mlist;
    AdreesAdapter adrAdapter;

    public ShowList(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.show_list, this);
        Log.e(TAG, "ShowList: ---1111--");
        Log.i(TAG, "child count is " + getChildCount());
        for(int i = 0; i < getChildCount(); i++)
            Log.i(TAG, "child is " + getChildAt(i));
        listView = (ListView)findViewById(R.id.list_view);
        Log.i(TAG, "list view is " + listView);
        mlist = new ArrayList<ChinaAddress>();

        initListView();

        adrAdapter = new AdreesAdapter(mlist, context);
        Log.i(TAG, "set adapter ");
        listView.setAdapter(adrAdapter);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG, "onFinishInflate: ---");

    }

    public void initListView() {
        ChinaAddress hbAdrr = new ChinaAddress();
        hbAdrr.setProvince("湖北");
        hbAdrr.setCity("仙桃");
        hbAdrr.setStreet("机场线");

        ChinaAddress gdAdrr = new ChinaAddress();
        gdAdrr.setProvince("广东");
        gdAdrr.setCity("广州");
        gdAdrr.setStreet("黑人区");

        ChinaAddress twAdrr = new ChinaAddress();
        twAdrr.setProvince("台湾");
        twAdrr.setCity("台北");
        twAdrr.setStreet("阳明山");

        mlist.add(hbAdrr);
        mlist.add(gdAdrr);
        mlist.add(twAdrr);
    }

    public void changeStreet() {
        mlist.get(0).setStreet("001");
        mlist.get(1).setStreet("222");
        mlist.get(2).setStreet("333");

        adrAdapter.notifyDataSetChanged();
    }
}
