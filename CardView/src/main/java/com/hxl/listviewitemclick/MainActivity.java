package com.hxl.listviewitemclick;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by hp_laptop on 2017/6/22.
 */

public class MainActivity extends AppCompatActivity {
    private CardView cardView;
    private float paddingBottom;
    private float paddingTop;
    private float paddingLeft;
    private float paddingRight;
    private RotateAnimation rotateAnimation;
    private Boolean isFirstMove = true;
    private Boolean isMovedRight = false;
    private float preCardX;
    private float preCardY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        handleAnimation(cardView);
        handleGesture(cardView);
    }

    private void initView(){
        cardView = (CardView) findViewById(R.id.card);

        rotateAnimation = new RotateAnimation(0,-35, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setDuration(2000);
        cardView.setAnimation(rotateAnimation);
        rotateAnimation.start();
    }

    private void handleGesture(final View view){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == event.ACTION_DOWN){

                }else if (event.getAction() == event.ACTION_UP){
//                    TranslateAnimation translateAnimation = new TranslateAnimation(cardView.getX(),preCardX,cardView.getY(),preCardY);
//                    translateAnimation.setDuration(1000);
//                    translateAnimation.setInterpolator(new AccelerateInterpolator(3f));
//                    cardView.setAnimation(translateAnimation);
//                    translateAnimation.start();
                }else if(event.getAction() == event.ACTION_MOVE) {
                    cardView.setX(event.getRawX() - (cardView.getWidth()/ 2));
//                    cardView.setY(event.getRawY() - (cardView.getHeight() / 2));

                    Log.e("hxl","X:"+(event.getRawX() - (cardView.getWidth()/ 2)));
                    Log.e("hxl","Y:"+(event.getRawY() - (cardView.getHeight()/ 2)));

                }
                isMovedRight = true;
                return true;
            }
        });
    }

    private void handleAnimation(View view){
        rotateAnimation = new RotateAnimation(0,45, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setFillAfter(false);

        view.setAnimation(rotateAnimation);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        preCardX = cardView.getX();
        preCardY = cardView.getY();
    }

}
