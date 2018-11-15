package com.ab1209.polyview.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ab1209.polyview.R;
import com.ab1209.polyview.views.PolyView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private PolyView polyView;
    private Handler handler;
    private Random random;
    private int noOfSides = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        handler = new Handler();
        polyView = findViewById(R.id.activity_main_poly_view);
        handler.postDelayed(runnable, 500);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            noOfSides++;
            if (noOfSides >= 8)
                noOfSides = 3;
            polyView.changeShape(noOfSides, 100, getRandomColor());
            handler.postDelayed(this, 2000);
        }
    };

    private int getRandomColor() {
        int[] intColors = getResources().getIntArray(R.array.array_color);
        int noOfColors = intColors.length;

        Random random = new Random();
        int i = random.nextInt(noOfColors - 1);
        return intColors[i];
    }
}
