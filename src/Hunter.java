
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hunter extends Thread implements FieldItem {

    private char type;
    private HuntField field;
    private Position myPosition;
    private char cardinals[];
    private int shot = 0;
    private boolean alive;

    public Hunter(HuntField field) {
        this.field = field;
        this.type = 'H';
        cardinals = new char[]{'N','W','S','E'};
        while (true) {
            myPosition = field.randomPositionGenerator();
            if (myPosition == null) {
                field.setItem(this, myPosition);
                break;
            }
        }
        alive = true;
    }

    @Override
    public boolean fired() {
        alive = false;
        return true;
    }

    @Override
    public char getType() {
        return this.type;
    }

    @Override
    public void run() {
        int count = 0;
        int cardinalCount = count%4;
        while(alive)
        try {
            Thread.sleep(field.rnd.nextInt(100));
            count++;
        } catch (InterruptedException ex) {}
            if(field.shot(getNextPosition(cardinalCount))){
                shot++;
                field.moveItem(this, myPosition, getNextPosition(cardinalCount));
            }
        }

    private Position getNextPosition(int cardinalCount) {
        switch (cardinalCount){
            case 'N':
                return new Position(myPosition.getX(), myPosition.getY()-1);
            case 'W':
                return new Position(myPosition.getX()-1, myPosition.getY());
            case 'S': 
                return new Position(myPosition.getX(), myPosition.getY()+1);
            default: 
                return new Position(myPosition.getX()+1, myPosition.getY());
        }
    }
}
