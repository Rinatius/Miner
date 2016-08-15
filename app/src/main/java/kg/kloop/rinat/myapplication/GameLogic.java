package kg.kloop.rinat.myapplication;

/**
 * Created by admin on 15.08.2016.
 */
public class GameLogic {
    GameGrid gameGrid;

    public GameLogic(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public void mark(int x, int y) {
        gameGrid.setCell(x, y, 'm');
    }

    public void press(int x, int y) {

    }
}
