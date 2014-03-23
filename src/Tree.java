
public class Tree implements FieldItem{

    private char type;
    private HuntField field;
    private Position myPosition;

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
        return false;
    }

    @Override
    public char getType() {
        return this.type;
    }

    
}
