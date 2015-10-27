package com.lucaszeta.gameoflife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lucaszeta.gameoflife.model.GameModel;
import com.lucaszeta.gameoflife.view.GameView;

public class MainActivity extends Activity {

    GameModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int rows = 20;
        int columns = 15;
        int cellSize = 40;
        final int numCells = 30;

        GameView view = (GameView) findViewById(R.id.gameView);
        Button refreshButton = (Button) findViewById(R.id.btnRefresh);
        Button nextGenButton = (Button) findViewById(R.id.btnNextGeneration);
        model = new GameModel(rows, columns);
        model.seed(numCells);

        view.setUp(rows, columns, cellSize);
        view.setModel(model);

        nextGenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.tick();
                findViewById(R.id.gameView).invalidate();
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.seed(numCells);
                findViewById(R.id.gameView).invalidate();
            }
        });
    }
}
