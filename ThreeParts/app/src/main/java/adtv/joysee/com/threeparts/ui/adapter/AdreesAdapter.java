package adtv.joysee.com.threeparts.ui.adapter;

import android.content.Context;
import android.location.Address;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.bean.ChinaAddress;

/**
 * Created by jiangxiujie on 17-6-28.
 */
public class AdreesAdapter extends BaseAdapter {
    private static final String TAG = "AdreesAdapter";

    List<ChinaAddress>addrList = new ArrayList<>();
    private LayoutInflater inflater;

    public AdreesAdapter(List<ChinaAddress>addresses, Context context) {
        this.addrList = addresses;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return addrList == null ? 0 : addrList.size();
    }

    @Override
    public Object getItem(int position) {
        return addrList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*把布局加载为视图，在视图中找控件*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View addrView = inflater.inflate(R.layout.show_list, null);
        ChinaAddress addr = (ChinaAddress) getItem(position);
/*        Log.i(TAG, "child count is " + parent.getChildCount());
        for(int i = 0; i < parent.getChildCount(); i++)
            Log.i(TAG, "child is " + parent.getChildAt(i));*/
        TextView tv1 = (TextView) addrView.findViewById(R.id.textview1);
        TextView tv2 = (TextView) addrView.findViewById(R.id.textview2);
        TextView tv3 = (TextView) addrView.findViewById(R.id.textview3);
        Log.e(TAG, "getView: ---");
        Log.e(TAG, "getView: ============" + addr.getProvince() );
        tv1.setText(addr.getProvince());
        tv2.setText(addr.getCity());
        tv3.setText(addr.getStreet());

        return addrView;
    }
}
