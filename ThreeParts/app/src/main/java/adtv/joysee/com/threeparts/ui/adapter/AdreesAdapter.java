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

    /*
    * 如果是Activity，那么直接setContentView,然后就可以findViewById，因为Activity里面有findViewById方法
    * 另外一个有findViewById方法的地方时View，但是
    * 因为BaseAdapter并不继承任何findViewById方法，所以只能通过context构造出视图View，然后使用View中的findViewById方法
    * */
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

    /*把布局加载为视图，在视图中找控件
    *
    *一直给自己骗了，还误以为必须include，原来都是套路，但是要认真理解这个套路。 加载布局 ！
    * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View addrView = inflater.inflate(R.layout.listview_content, null);
        ChinaAddress addr = (ChinaAddress) getItem(position);

        TextView tv1 = (TextView) addrView.findViewById(R.id.textview1);
        TextView tv2 = (TextView) addrView.findViewById(R.id.textview2);
        TextView tv3 = (TextView) addrView.findViewById(R.id.textview3);

        tv1.setText(addr.getProvince());
        tv2.setText(addr.getCity());
        tv3.setText(addr.getStreet());

        return addrView;
    }
}
