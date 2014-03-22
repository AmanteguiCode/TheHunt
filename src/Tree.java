
public class Tree implements FieldItem{

    char type;
    HuntField field;
    Position myPosition;

    public Tree(HuntField field) {
        this.field = field;
        this.type = 'T';
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

    
}
