package com.example.song.greathua.mytest.homework.rebound;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.song.greathua.R;
import com.example.song.greathua.base.CommonActivity;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by PVer on 2017/4/8.
 *
 */

public class ReboundActivity extends CommonActivity {
    @BindView(R.id.btn_rebound)
    Button mBtnRebound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebound);
    }

    @OnClick({R.id.btn_rebound})
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_rebound:
                SpringSystem springSystem = SpringSystem.create();
                // Add a spring to the system.
                Spring spring = springSystem.createSpring();
                spring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(100,1));
                // Add a listener to observe the motion of the spring.
                spring.addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        // You can observe the updates in the spring
                        // state by asking its current value in onSpringUpdate.
                        float value = (float) spring.getCurrentValue();
                        float scale = 1f - (value * 0.5f);
                        mBtnRebound.setScaleX(scale);
                        mBtnRebound.setScaleY(scale);
                    }
                });
                // Set the spring in motion; moving from 0 to 1
                spring.setEndValue(1);
                break;
        }
    }

}
