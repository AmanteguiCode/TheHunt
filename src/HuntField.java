
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HuntField {
    
    public Random rnd = new Random(System.currentTimeMillis());
    private FieldItem[][] field;
    private int x;
    private int y;

    public HuntField(int X,int  Y) {
        this.field = new FieldItem[X][Y];
        this.x = X;
        this.y = Y;
    }

    public int getXLength() {
        return x;
    }

    public int getYLength() {
        return y;
    }
    
    public synchronized boolean setItem(FieldItem item, Position position){
        if ((position.getX() <= this.getXLength()) || (position.getY() <= this.getYLength())) return false;
        if (field[position.getX()][position.getY()] == null) {
            field[position.getX()][position.getY()] = item;
            return true;
        }
        return false;
    }
    
    public synchronized boolean shot(Position position){
        if ((position.getX() <= this.getXLength()) || (position.getY() <= this.getYLength())) return false;
        if (field[position.getX()][position.getY()] != null) {
            return field[position.getX()][position.getY()].fired();
        }
        return false;
    } 
    
    public synchronized boolean removeItem(FieldItem item, Position position){
        if ((position.getX() <= this.getXLength()) || (position.getY() <= this.getYLength())) return false;
        if (field[position.getX()][position.getY()] == item) {
            field[position.getX()][position.getY()] = null;
            return true;
        }
        return false;
    }
    
    public synchronized char getItemType(Position position){
        if (field[position.getX()][position.getY()] != null) return field[position.getX()][position.getY()].getType();
        return 0;
    }
    
    public synchronized boolean moveItem(FieldItem item, Position initial, Position finalPosition){
        if ((finalPosition.getX() <= this.getXLength()) || (finalPosition.getY() <= this.getYLength())) return false;
        if ((initial.getX() <= this.getXLength()) || (initial.getY() <= this.getYLength())) return false;
        for (int i = 0; i < 10; i++) {
            if ((field[initial.getX()][initial.getY()] == item) && (field[finalPosition.getX()][finalPosition.getY()] == null)) {
                field[initial.getX()][initial.getY()] = null;
                field[finalPosition.getX()][finalPosition.getY()] = item;
            }
            try {Thread.currentThread().sleep(100);
            } catch (InterruptedException ex) {}
        }
        return false;
    }
    
    public synchronized int getNumberOfItems(char type){
        int num = 0;
        for (int x = 0; x < this.getXLength(); x++) {
            for (int y = 0; y < this.getYLength(); y++) {
                if (field[x][y] != null) {
                    if (field[x][y].getType() == type) num++;
                }
            }
        }
        return num;
    }
    
    public synchronized Position getPosition(FieldItem item){
        for (int i = 0; i < this.getXLength(); i++) {
            for (int j = 0; j < this.getYLength(); j++) {
                if (item == field[i][j]) return new Position(i, j);
            }
        }
        return new Position(0,0);
    }
    
    public synchronized String toString(){
        String stringgedField = "";
        for (int i = 0; i < this.getYLength(); i++) {
            stringgedField = stringgedField + '\n';
            for (int j = 0; j < this.getXLength(); j++) {
                if (field[j][i] == null) {
                    stringgedField = stringgedField + " ";
                }else{
                    stringgedField = stringgedField + field[j][i].getType();
                }
            }
        }
        return stringgedField;
    }
    
    public Position randomPositionGenerator(){
        return new Position(rnd.nextInt(this.getXLength()), rnd.nextInt(this.getYLength()));
    }
    
    
}
