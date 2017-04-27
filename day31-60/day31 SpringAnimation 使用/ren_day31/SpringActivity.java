package com.rent.mytestapplication.anim;

import android.os.Bundle;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.rent.mytestapplication.R;

/**
 * TODO velocityTracker
 */
public class SpringActivity extends AppCompatActivity {
    ImageView img;

    float defaultX, defaultY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring);

        img = (ImageView) this.findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAnim(true).start();
                createAnim(false).start();
            }
        });

        img.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                defaultX = img.getScaleX();
                defaultY = img.getScaleY();

                img.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    private SpringAnimation createAnim(boolean x) {
        SpringAnimation springAnimation = new SpringAnimation(img, x ? SpringAnimation.SCALE_X : SpringAnimation.SCALE_Y);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        springForce.setStiffness(SpringForce.STIFFNESS_MEDIUM);
        springForce.setFinalPosition(x ? defaultX : defaultY);
        springAnimation.setStartValue(0.5f);
        springAnimation.setSpring(springForce);
        return springAnimation;
    }
}
