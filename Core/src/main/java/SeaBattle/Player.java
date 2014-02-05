package SeaBattle;

/**
 * Created by Igor on 04.02.14.
 */
public class Player {
    private Board boardWithMyShips = new Board();
    private EnemyBoard enemyShips = new EnemyBoard();

    public ShotResult myShot(Point cell){
        return boardWithMyShips.shot(cell);
    }

    public boolean addShip(Ship ship) {
        return boardWithMyShips.addShip(ship);
    }

    public boolean isDefeated(){
        return boardWithMyShips.isDefeated();
    }

    public ShotResult enemyShot(Point cell){
        return enemyShips.shot(cell);
    }
}
