package adtv.joysee.com.threeparts.activity;

import android.annotation.SuppressLint;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import adtv.joysee.com.threeparts.ui.ButtonText;
import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.controller.Controller;
import adtv.joysee.com.threeparts.R;
import adtv.joysee.com.threeparts.ui.ShowList;
import adtv.joysee.com.threeparts.ui.ViewInfa;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public Button buttonView, buttonStreet;
    Controller mController;
    ButtonText buttonText;
    ShowList showList;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonView = (Button) findViewById(R.id.bt_view);
        mController = new Controller();
        buttonText = (ButtonText) findViewById(R.id.my_buttontext);
        showList = (ShowList) findViewById(R.id.frame_listview);
        buttonStreet = (Button)findViewById(R.id.bt_chstreet);

        registerView();

        buttonView.setOnClickListener(new View.OnClickListener() {
            Message message = new Message();
            @Override
            public void onClick(View v) {
                message.what = Case.CHANGE_TXT;
                mController.dispatchMessage(buttonText, message);
            }
        });
        buttonStreet.setOnClickListener(new View.OnClickListener() {
            Message message = new Message();
            @Override
            public void onClick(View v) {
                message.what = Case.CHANGE_STREET;
                mController.dispatchMessage(showList, message);
            }
        });



    }

    protected void registerView() {
        mController.registerView(buttonText);
    }

}
