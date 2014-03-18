
public class Tree implements FieldItem{

    char type;
    HuntField field;

    public Tree(HuntField field) {
        this.field = field;
        this.type = 'T';
        while(this.field.setItem(this, this.field.randomPositionGenerator()) != true);
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
