package adtv.joysee.com.threeparts.activity;

import android.annotation.SuppressLint;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import adtv.joysee.com.threeparts.ui.ButtonText;
import adtv.joysee.com.threeparts.bean.Case;
import adtv.joysee.com.threeparts.controller.Controller;
import adtv.joysee.com.threeparts.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public Button button;
    Controller mController;
    ButtonText buttonText;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt_change);
        mController = new Controller();
        buttonText = (ButtonText) findViewById(R.id.my_listview);
        registerView();

        onMonitorClick();
    }

    protected void registerView() {
        mController.registerView(buttonText);
    }

    protected void onMonitorClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                switch (v.getId()) {
                    case R.id.bt_change:
                        message.what = Case.CHANGE_TXT;
                        break;
                    default:
                        break;
                }
                mController.dispatchMessage(buttonText, message);
            }
        });
    }
}
