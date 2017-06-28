package adtv.joysee.com.threeparts.ui;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.bean.ChinaAddress;
import adtv.joysee.com.threeparts.ui.adapter.AdreesAdapter;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class ShowList extends FrameLayout{
    private static final String TAG = "ShowList";
    ListView listView;
    List<ChinaAddress> mlist;

    public ShowList(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.show_list, this);
        Log.e(TAG, "ShowList: ---1111--");

        listView = (ListView)findViewById(R.id.list_view);
        mlist = new ArrayList<ChinaAddress>();

        initListView();
        AdreesAdapter adrAdapter = new AdreesAdapter(mlist, context);
        listView.setAdapter(adrAdapter);
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

        mlist.add(gdAdrr);
        mlist.add(gdAdrr);
        mlist.add(twAdrr);
    }
}
