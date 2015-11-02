package com.lucaszeta.gameoflife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lucaszeta.gameoflife.model.GameModel;
import com.lucaszeta.gameoflife.view.GameView;

public class MainActivity extends Activity {

    int rows = 20;
    int columns = 15;
    int numCells = 30;
    static GameModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int cellSize = 40;

        GameView view = (GameView) findViewById(R.id.gameView);
        Button refreshButton = (Button) findViewById(R.id.btnRefresh);
        Button nextGenButton = (Button) findViewById(R.id.btnNextGeneration);

        view.setUp(rows, columns, cellSize);
        view.setModel(getGameModel());

        nextGenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGameModel().tick();
                findViewById(R.id.gameView).invalidate();
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGameModel().seed(numCells);
                findViewById(R.id.gameView).invalidate();
            }
        });
    }

    private GameModel getGameModel() {
        if (MainActivity.model == null) {
            MainActivity.model = new GameModel(rows, columns);
            MainActivity.model.seed(numCells);
        }

        return MainActivity.model;
    }
}
