
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Duck extends Thread implements FieldItem{

    char type;
    HuntField field;
    Position myPosition;

    public Duck(HuntField field) {
        this.field = field;
        this.type = 'D';
        while(true){
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
        while(true){
            try {
                Thread.sleep(field.rnd.nextInt(300));
                switch(field.rnd.nextInt(3)){
                    case 0:
                        field.moveItem(this, myPosition, new Position(myPosition.getX(), myPosition.getY()-1));
                        break;
                    case 1:
                        field.moveItem(this, myPosition, new Position(myPosition.getX()-1, myPosition.getY()));
                        break;
                    case 2:
                        field.moveItem(this, myPosition, new Position(myPosition.getX(), myPosition.getY()+1));
                        break;
                    case 3:
                        field.moveItem(this, myPosition, new Position(myPosition.getX()+1, myPosition.getY()));
                        break;
                }
            } catch (InterruptedException ex) {}
        }
    }
    
    

}
