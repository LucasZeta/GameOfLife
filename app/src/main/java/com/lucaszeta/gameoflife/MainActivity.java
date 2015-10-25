package com.lucaszeta.gameoflife;

import android.app.Activity;
import android.os.Bundle;

import com.lucaszeta.gameoflife.view.GameView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameView view = (GameView) findViewById(R.id.gameView);
        view.setUp(20, 15, 20);
    }
}
