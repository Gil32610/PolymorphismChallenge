import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Enter type of car or Q to quit:");
            String type = s.nextLine();
            if("Qq".contains(type))break;
            Car myCar = Car.getCar(type);
            operateVehicle(myCar);
        }

    }

    public static void operateVehicle(Car car){
        car.startEngine();
        car.drive();
    }
}
