abstract class Vehicle {
    private final String engineType;

    public String getEngineType() {
        return engineType;
    }

    public Vehicle(String engineType) {
        this.engineType = engineType;
    }

    abstract void describe();

    void start() {
        System.out.println("Vehicle is starting.");
    }

    void stop() {
        System.out.println("Vehicle is stopping.");
    }
}

class Car extends Vehicle {
    public Car(String engineType) {
        super(engineType);
    }


    @Override
    void describe() {
        System.out.println("This is a car with a " + getEngineType() + " engine.");
    }
}
