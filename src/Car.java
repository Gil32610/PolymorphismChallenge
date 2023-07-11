import java.util.Scanner;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Starting the " + this.getClass().getSimpleName());
    }

    public void drive() {
        runEngine();
        System.out.println("Accelerating!");
    }

    protected void runEngine() {
        System.out.println("Engine Working!");
    }

    //factory method
    public static Car getCar(String type) {
        Scanner s = new Scanner(System.in);
        return switch (type.toUpperCase().charAt(0)) {
            case 'H' -> {
                System.out.println("Enter car description:");
                String description = s.nextLine();
                System.out.println("Enter battery size:");
                int batterySize = Integer.parseInt(s.nextLine());
                System.out.println("Enter cylinder quantity:");
                int cylinders = Integer.parseInt(s.nextLine());
                System.out.println("Enter avg km per litre:");
                int avgKmPerLitre = Integer.parseInt(s.nextLine());
                yield new HybridCar(description, avgKmPerLitre, batterySize, cylinders);
            }
            case 'G' -> {
                System.out.println("Enter car description:");
                String description = s.nextLine();
                System.out.println("Enter cylinder quantity:");
                int cylinders = Integer.parseInt(s.nextLine());
                System.out.println("Enter avg km per litre:");
                int avgKmPerLitre = Integer.parseInt(s.nextLine());
                yield new GasPoweredCar(description, avgKmPerLitre, cylinders);
            }
            case 'E' -> {
                System.out.println("Enter car description:");
                String description = s.nextLine();
                System.out.println("Enter battery size:");
                int batterySize = Integer.parseInt(s.nextLine());
                System.out.println("Enter avg km per charge:");
                int avgKmPerLitre = Integer.parseInt(s.nextLine());
                yield new ElectricCar(description, avgKmPerLitre, batterySize);
            }
            default -> {
                System.out.println("Enter Car description:");
                String description = s.nextLine();
                yield new Car(description);
            }

        };
    }
}

class GasPoweredCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Pumping fuel!");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Km per liter expected: " + avgKmPerLitre + "km");
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("Car engine is combusting with its" + cylinders + " cylinders");
    }
}

class ElectricCar extends Car {
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Battery powering electric engine");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Km per charge expected: " + avgKmPerCharge + "km");
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("Powering the vehicle with its " + batterySize + "kWh Battery");
    }
}

class HybridCar extends Car {
    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("Combusting fuel with its" + cylinders + " cylinders to power ICE and charging the " + batterySize + " kWh batteries to power electric motors!");
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Pumping fuel and powering electric motors to the vehicle");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("km per litre expected: " + avgKmPerLitre + "km");

    }
}
