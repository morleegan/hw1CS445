import org.junit.Test;

public class TestCreature{
    private static int CREATURE_COUNT = 4;
    private static int THING_COUNT = 2;
    private static boolean flag = true;

    public TestCreature(){}

    public static void main(String[] args) {
       //initialize
        Fly fly = new Fly("Bob");
        Bat bat = new Bat("Jerry");
        Tiger tiger = new Tiger("Larry");
        Ant ant = new Ant("Tom");
        Creature[] creatureArray = {ant, fly, bat, tiger};

        Thing[] thingArray = new Thing[THING_COUNT + CREATURE_COUNT];
        for (int i=0; i<THING_COUNT; i++) {
            thingArray[i] = new Thing("Thing" + i);
        }
        System.arraycopy(creatureArray, 0, thingArray, 2, 4);

        //Test and printing
        printLoop(thingArray);
        printLoop(creatureArray);
    }

    private static void printLoop(Object[] objectArray) {
        String name = objectArray.getClass().getSimpleName(); //has [] because it's an array
        System.out.println( name.substring(0, name.length()-2)+ "s:\n");
        for(Object object: objectArray){
            System.out.println(object.toString());
            if (object instanceof Creature && flag){
                creatureActions((Creature) object);
            }
        }
        System.out.println('\n');
        flag = false;
    }

    private static void creatureActions(Creature creature){
        if(creature instanceof Flyer){
            ((Flyer) creature).fly();
        }
        else{
            creature.move();
        }
    }
}