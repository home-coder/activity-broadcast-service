package adtv.joysee.com.threeparts;

import android.annotation.SuppressLint;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public Button button;
    Controller mController;
    MyListView myListView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt_change);
        mController = new Controller();
        myListView = (MyListView) findViewById(R.id.my_listview);
        registerView();

        onMonitorClick();
    }

    protected void registerView() {
        mController.registerView(myListView);
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
                mController.dispatchMessage(myListView, message);
            }
        });
    }
}
