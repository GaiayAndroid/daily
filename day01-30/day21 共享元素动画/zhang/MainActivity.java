package com.example.lenovo.xianicaitest;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;

public class MainActivity extends AppCompatActivity {

    private Person mP;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this, PreLollipopActivity.class);
                ActivityOptions activityOptions = makeSceneTransitionAnimation(MainActivity.this, new Pair<View, String>(mTextView, mTextView.getTransitionName()));
                startActivity(intent, activityOptions.toBundle());

            }
        });
    }
}
