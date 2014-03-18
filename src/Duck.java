
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Duck extends Thread implements FieldItem{

    char type;
    HuntField field;

    public Duck(HuntField field) {
        this.field = field;
        this.type = 'D';
        while(this.field.setItem(this, this.field.randomPositionGenerator()) != true){}
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
                Thread.currentThread().sleep(this.field.rnd.nextInt(300));
            } catch (InterruptedException ex) {}
            this.field.moveItem(this, null, null);
        }
    }
    
    

}
