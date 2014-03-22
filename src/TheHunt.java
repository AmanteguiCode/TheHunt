

public class TheHunt {

    public static void printField(HuntField field){
        System.out.println("Hunters "+field.getNumberOfItems('H')+ " Ducks "+field.getNumberOfItems('D') + "\n");
        System.out.println(field);
    }
    
    public static void main(String[] args) throws InterruptedException {
        final int numberOfTrees = 20;
        final int numberOfDucks = 20;
        final int numberOfHunters = 20;
        
        HuntField f = new HuntField(21, 70);
        for (int i = 0; i < numberOfTrees; i++) new Tree(f);
        for (int i = 0; i < numberOfDucks; i++) new Duck(f).start();
        for (int i = 0; i < numberOfHunters; i++) new Hunter(f).start();
        while(f.getNumberOfItems('D')>0){
            Thread.sleep(200);
            printField(f);
        }
        printField(f);
    }

}
