package SeaBattle;

/**
 * Created by Igor on 05.02.14.
 */
public class EnemyBoard extends Board{
    public EnemyBoard() {}
    @Override
    public ShotResult shot(Point cell) {
        if(shots.contains(cell)) {
            return ShotResult.REPEAT;
        }
        ShotResult result = ships.shot(cell);
        shots.add(new Shot(cell, result));
        if(result == ShotResult.SINKED) {
            aliveShips--;
        }
        return result;
    }
}
