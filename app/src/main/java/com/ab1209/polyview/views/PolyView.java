package com.ab1209.polyview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.ab1209.polyview.R;


/**
 * Copyright (C) 2018 Arun Badole.
 *
 * Custom view that can be created in many polygon shapes.
 *
 * @author arunbadole
 */
public class PolyView extends View {
    private final static String TAG = "PolyView";
    private static final int MIN_SIDES = 3;
    private int noOfSides = MIN_SIDES;
    private float radius;
    private int color;

    private Paint paint;
    private Path path;

    public PolyView(Context context) {
        super(context);
    }

    public PolyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PolyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public PolyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PolyView);
        noOfSides = a.getInt(R.styleable.PolyView_noOfSides, MIN_SIDES);
        radius = a.getDimensionPixelSize(R.styleable.PolyView_radius, 0);
        color = a.getColor(R.styleable.PolyView_color, getResources().getColor(R.color.colorPrimary));
        a.recycle();
        paint = new Paint();
        paint.setColor(color);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path = createPath(noOfSides, radius);
        canvas.drawPath(path, paint);
    }

    public void changeShape(int noOfSides, float radius, int color) {
        if (noOfSides < MIN_SIDES)
            noOfSides = MIN_SIDES;
        this.noOfSides = noOfSides;
        this.radius = radius;
        this.color = color;
        paint.setColor(color);
        invalidate();
    }

    private Path createPath(int noOfSides, float radius) {
        int cX = getWidth() / 2;
        int cY = getHeight() / 2;
        path.reset();
        Log.i(TAG, "createPath cX: " + cX + ", cY: " + cY);
        double angle = 2.0 * Math.PI / noOfSides;
        path.moveTo(
                cX + (float) (radius * Math.cos(0.0)),
                cY + (float) (radius * Math.sin(0.0)));
        for (int i = 0; i < noOfSides; i++) {
            path.lineTo(
                    cX + (float) (radius * Math.cos(angle * i)),
                    cY + (float) (radius * Math.sin(angle * i)));
        }
        path.close();
        return path;
    }

    public int getNoOfSides() {
        return noOfSides;
    }

    public void setNoOfSides(int noOfSides) {
        this.noOfSides = noOfSides;
        invalidate();
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }
}
