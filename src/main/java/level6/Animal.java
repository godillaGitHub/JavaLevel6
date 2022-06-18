package level6;

public class Animal {

    private double animalDistanceRun, animalDistanceSwim;

    Animal(double animalDistanceRun, double animalDistanceSwim) {
        this.animalDistanceRun = animalDistanceRun;
        this.animalDistanceSwim = animalDistanceSwim;
    }

    public boolean run(double value) {
        return animalDistanceRun > value;
    }

    public boolean swim(double value) {
        return animalDistanceSwim > value;
    }

    double getAnimalDistanceRun() {
        return animalDistanceRun;
    }

    double getAnimalDistanceSwim() {
        return animalDistanceSwim;
    }
}
