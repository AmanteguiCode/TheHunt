
public class Hunter extends Thread implements FieldItem{

    char type;
    HuntField field;

    public Hunter(HuntField field) {
        this.field = field;
        this.type = 'H';
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
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }

}
