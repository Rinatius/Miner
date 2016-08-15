package kg.kloop.rinat.myapplication;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by admin on 15.08.2016.
 */
public class GameGrid {
    private int height;
    private int width;
    char[][] visibleArray;
    char[][] bombMapArray;

    public GameGrid(){
        visibleArray = new char [2] [3];
        for (int i = 0; i < visibleArray.length; i++){
            Arrays.fill(visibleArray[i], 'c');
        }
    }

    public int getHeight() {
        return visibleArray.length;
    }

    public int getWidth() {
        return visibleArray[0].length;
    }

    public char getCell(int x, int y) {
        return visibleArray[x][y];
    }

    public void setCell(int x, int y, char symbol){
        visibleArray[x][y] = symbol;
    }
}
