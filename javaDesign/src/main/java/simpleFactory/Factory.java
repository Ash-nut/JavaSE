package simpleFactory;

public class Factory {
    private Factory() {
    }

    static public Animal getAnimal(String animalType) {
        switch (animalType) {
            case "D":
                return new D();
        }
        return null;
    }

    public static void main(String[] args) {
        Animal animal = getAnimal("D");
    }
}