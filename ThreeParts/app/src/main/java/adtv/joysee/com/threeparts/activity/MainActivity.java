package adtv.joysee.com.threeparts.activity;

import android.annotation.SuppressLint;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import adtv.joysee.com.threeparts.ui.ButtonText;
import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.controller.Controller;
import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.ui.ShowList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public Button buttonView, buttonStreet;
    Controller mController;
    ButtonText buttonText;
    ShowList showList;
    ListView listView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonView = (Button) findViewById(R.id.bt_view);
        mController = Controller.getInstance();
        buttonText = (ButtonText) findViewById(R.id.my_buttontext);
        showList = (ShowList) findViewById(R.id.frame_listview);
        buttonStreet = (Button)findViewById(R.id.bt_chstreet);
        listView = (ListView) findViewById(R.id.list_view);

        registerView();

        buttonView.setOnClickListener(new View.OnClickListener() {
            Message message = new Message();
            @Override
            public void onClick(View v) {
                message.what = Case.ButtonTextCase.CHANGE_TXT;
                mController.dispatchMessage(buttonText, message);
            }
        });
        buttonStreet.setOnClickListener(new View.OnClickListener() {
            Message message = new Message();
            @Override
            public void onClick(View v) {
                message.what = Case.ShowListCase.CHANGE_STREET;
                mController.dispatchMessage(showList, message);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Message message = new Message();
                message.what = Case.VideoPlayCase.JUMP_VIDEOACTIVITY;
                Bundle bundle = new Bundle();
                bundle.putInt("item_position", position);
                message.setData(bundle);
                mController.dispatchMessage(showList, message);
            }
        });
    }

    protected void registerView() {
        mController.registerView(buttonText);
    }
}
