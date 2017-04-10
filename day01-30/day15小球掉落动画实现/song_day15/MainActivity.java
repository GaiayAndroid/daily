package com.example.pver.myapplication.tween;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.pver.myapplication.R;


public class MainActivity extends Activity implements View.OnClickListener {


    private TextView mTvBall;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
//        findViewById(R.id.showmain).setOnClickListener(this);
//        findViewById(R.id.showtween).setOnClickListener(this);
//        findViewById(R.id.alltween).setOnClickListener(this);
        setContentView(R.layout.main_ball);
        mTvBall = (TextView) findViewById(R.id.tv_ball);
      final  Animation animation = makeAnimationSet();
        mTvBall.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View view) {
                /**
                 * 补间动画XML 实现
                 */
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.ball_set);
//                mTvBall.setAnimation(animation);
//                mTvBall.startAnimation(animation);

                /**
                 *  补间动画code 实现
                 */
              //  mTvBall.startAnimation(animation);

                /**
                 * 属性动画实现
                 */
                startObjectAni();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showmain:
                //TODO implement
                startActivity(new Intent(MainActivity.this, ShowMain.class));
                break;
            case R.id.showtween:
                //TODO implement
                startActivity(new Intent(MainActivity.this, ShowTween.class));
                break;
            case R.id.alltween:
                //TODO implement
                startActivity(new Intent(MainActivity.this, AllTween.class));
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public AnimationSet makeAnimationSet() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();

        int percentY = 80;
        int count = 20;
        long curDuration = 800;
        long startOffset = 0;
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        for (int i = 0; i < 20; i++) {
            if((i &1 )== 1)percentY -= 8  ;
            TranslateAnimation ani = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                    Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, (i & 1) == 0 ? percentY/100f : -percentY/100f);
            ani.setInterpolator((i & 1) == 0 ? accelerateInterpolator : decelerateInterpolator);
            ani.setDuration(curDuration);
            ani.setStartOffset(startOffset);
            startOffset += curDuration;
            curDuration -= 40;
            animationSet.addAnimation(ani);
        }
        return animationSet;
    }

    public void startObjectAni(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvBall,"translationY",100,1500);
        objectAnimator.setDuration(1500);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }
}
