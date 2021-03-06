package com.hxl.twoservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openButton = (Button) findViewById(R.id.open_service);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启服务
                Intent intent = new Intent(MainActivity.this,ServiceOne.class);
                startService(intent);

                Intent intent1 = new Intent(MainActivity.this,ServiceTwo.class);
                startService(intent1);

            }
        });
    }
}
