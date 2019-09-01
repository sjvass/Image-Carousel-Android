package com.example.sarav.imagecarousel2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<ImageView> imageList = new ArrayList<ImageView>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageList.add((ImageView) findViewById(R.id.imageView));
        imageList.add((ImageView) findViewById(R.id.imageView2));
        imageList.add((ImageView) findViewById(R.id.imageView3));
        imageList.add((ImageView) findViewById(R.id.imageView4));
        imageList.add((ImageView) findViewById(R.id.imageView5));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
    }

    public void rightClick(View view) {
        ImageView iv1 = imageList.get(0);
        ImageView iv3 = imageList.get(2);
        ImageView iv4 = imageList.get(3);
        ImageView iv5 = imageList.get(imageList.size() - 1);

        //fade out right image
        iv1.animate().alpha(0f).setDuration(3000).start();
        //iv1.setVisibility(View.INVISIBLE);
        iv1.animate().setStartDelay(3000).translationXBy(-600);

        //move center image to right
        iv5.animate().translationXBy(300f).setDuration(5000);
        iv5.animate().scaleXBy(-0.5f).scaleYBy(-0.5f).setDuration(5000);

        //move left image to center
        iv4.animate().scaleYBy(0.5f).scaleXBy(0.5f).setDuration(5000);
        iv4.animate().rotation(360f);
        iv4.animate().translationXBy(300f).setDuration(5000);
        iv4.bringToFront();

        //fade in new left image
        iv3.setVisibility(View.VISIBLE);
        iv3.animate().alpha(1f).setDuration(5000);

        //shift elements in list
        for(int i = imageList.size() - 1; i > 0; i--) {
            imageList.get(i).animate().setStartDelay(0);
            imageList.set(i, imageList.get(i - 1));
        }

        imageList.set(0, iv5);

    }

    public void leftClick(View view) {
        //right image
        ImageView iv1 = imageList.get(0);
        //invisible left image
        ImageView iv3 = imageList.get(1);
        //left image
        ImageView iv4 = imageList.get(3);
        //center image
        ImageView iv5 = imageList.get(imageList.size() - 1);

        //fade out left image
        iv4.animate().alpha(0f).setDuration(5000);

        //move center image to left
        iv5.animate().translationXBy(-300f).setDuration(5000);
        iv5.animate().scaleXBy(-0.5f).scaleYBy(-0.5f).setDuration(5000);

        //move right image to center
        iv1.animate().scaleYBy(0.5f).scaleXBy(0.5f).setDuration(5000);
        iv1.animate().rotation(-360f);
        iv1.animate().translationXBy(-300f).setDuration(5000);
        iv1.bringToFront();

        //fade in new right image
        iv3.animate().translationXBy(600f).setDuration(3000);
        iv3.setVisibility(View.VISIBLE);
        iv3.animate().setStartDelay(3000).alpha(1f);



        //shift elements in list
        for(int i = 0; i < imageList.size() - 1; i++) {
            imageList.get(i).animate().setStartDelay(0);
            imageList.set(i, imageList.get(i + 1));
        }

        imageList.set(imageList.size() - 1, iv1);

    }

}
