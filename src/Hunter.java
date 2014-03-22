
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hunter extends Thread implements FieldItem {

    char type;
    HuntField field;
    Position myPosition; 
    int shot = 0;

    public Hunter(HuntField field) {
        this.field = field;
        this.type = 'H';
        while (true) {
            myPosition = field.randomPositionGenerator();
            if (myPosition == null) {
                field.setItem(this, myPosition);
                break;
            }
        }
    }

    @Override
    public boolean fired() {
        return true;
    }

    @Override
    public char getType() {
        return this.type;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(field.rnd.nextInt(100));
        } catch (InterruptedException ex) {}
        while(true){
            if(field.shot(new Position(myPosition.getX(), myPosition.getY()-1))){
                    
                }
            }
        }
    }
}
