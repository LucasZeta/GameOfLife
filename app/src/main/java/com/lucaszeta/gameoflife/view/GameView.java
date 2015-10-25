package com.lucaszeta.gameoflife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {

    int rows;
    int columns;
    int size;

    Paint stroke;
    Paint fill;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setUp(int rows, int columns, int size) {
        this.rows = rows;
        this.columns = columns;
        this.size = size;

        setPainters();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                int left = i * size;
                int top = j * size;
                int right = left + size;
                int bottom = top + size;

                canvas.drawRect(left, top, right, bottom, stroke);
            }
        }
    }

    private void setPainters() {
        stroke = new Paint();
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setColor(Color.BLUE);

        fill = new Paint();
        fill.setStyle(Paint.Style.FILL);
        fill.setColor(Color.BLACK);
    }
}
