package main.java.pack;

import main.java.util.Constant;

public class PackFactory {
    private static PackFactory packFactory = null;

    private PackFactory() {

    }

    public static PackFactory getPackFactoryInstance() {
        if (packFactory == null) {
            packFactory = new PackFactory();
        }
        return packFactory;
    }

    public Pack getPack(int type, float quantity) {
        Pack pack = null;
        switch (type) {
            case Constant.TWO:
                pack = new PackOfTwo(quantity);
                break;
            case Constant.Three:
                pack = new PackOfThree(quantity);
                break;
            case Constant.Five:
                pack = new PackOfFive(quantity);
                break;
            case Constant.EIGHT:
                pack = new PackOfEight(quantity);
                break;
            case Constant.NINE:
                pack = new PackOfNine(quantity);
            default:
                break;
        }
        return pack;
    }

}
