package com.vrajaninfotech.vampy.contactsyncdemoexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mengzhao on 16/9/3.
 */
public class HandleActivity extends AppCompatActivity {

    private static final String TAG = "HandleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textData);
        textView.setTextColor(Color.RED);
        textView.setText("HandleActivity");
    }

}
