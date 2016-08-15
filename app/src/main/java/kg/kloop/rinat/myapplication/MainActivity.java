package kg.kloop.rinat.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private TextView textView;
    private View.OnClickListener onButtonClickListener;
    private EditText editText;
    private EditText editText2;
    private GameLogic gameLogic;
    private GameGrid gameGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();
        setListeners();
        connectListeners();
        //draw(gameGrid);

    }

    private void initVars(){

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        gameGrid = new GameGrid();
        gameLogic = new GameLogic(gameGrid);
    }

    private void setListeners(){
        onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(editText.getText().toString());
                int y = Integer.parseInt(editText2.getText().toString());
                if (view.getId() == R.id.button){
                    updatePress(x, y);
                } else {
                    updateMark(x, y);
                }
            }
        };
    }

    private void updateMark(int x, int y) {
        gameLogic.mark(x, y);
        draw(gameGrid);
    }

    private void updatePress(int x, int y) {
        gameLogic.press(x, y);
        draw(gameGrid);
    }

    private void draw(GameGrid grid){
        textView.setText("");
        for (int i = 0; i < grid.getWidth(); i++){
            for (int j = 0; j < grid.getHeight(); j++){
                char cellText = grid.getCell(i, j);
                textView.append(Character.toString(cellText) + "   ");
            }
            textView.append("\n");
        }
    }



    private void connectListeners(){
        button.setOnClickListener(onButtonClickListener);
        button2.setOnClickListener(onButtonClickListener);
    }
}
