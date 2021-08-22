package edu.stepik;

public class FruitCount {
    public static void main(String[] args) {
        Object[] objects = new Object[4];
        objects[0] = 3;
    }

    static void checkFruitCount(Object[] objects) {
        int countBanana = 0;
        int countApple = 0;

        for (Object item: objects) {
            if (item instanceof Apple) {
                countApple++;
            }
            if (item instanceof Banana) {
                countBanana++;
            }
        }

        System.out.println("banana="+countBanana+", apple="+countApple);
    }
}


interface Apple {

}

interface Banana {

}

