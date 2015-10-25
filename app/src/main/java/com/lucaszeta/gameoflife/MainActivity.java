package com.lucaszeta.gameoflife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lucaszeta.gameoflife.model.GameModel;
import com.lucaszeta.gameoflife.view.GameView;

public class MainActivity extends Activity implements View.OnClickListener {

    GameModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int rows = 20;
        int columns = 15;
        GameView view = (GameView) findViewById(R.id.gameView);
        Button refreshButton = (Button) findViewById(R.id.btnRefresh);

        model = new GameModel(rows, columns);

        view.setUp(rows, columns, 20);
        view.setModel(model);

        refreshButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        model.tick();

        findViewById(R.id.gameView).invalidate();
    }
}
