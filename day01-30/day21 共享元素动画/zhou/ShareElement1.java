package com.zc.shareelementactivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.SearchView;

public class ShareElement1 extends AppCompatActivity {
    SearchView searchView ;
    ImageView svg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element1);
        searchView = (SearchView) findViewById(R.id.search);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareElement1.this, ShareElement2.class),
                        ActivityOptions.makeSceneTransitionAnimation(ShareElement1.this,searchView,"sharename").toBundle());
            }
        });
        //svg 动画
        svg = (ImageView) findViewById(R.id.imageView);
        Drawable drawable = svg.getDrawable();
        if(drawable instanceof Animatable){
            ( (Animatable)drawable).start();
        }
    }
}
