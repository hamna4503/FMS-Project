
import java.util.*;

public class SpeedControllerTestingClass {
    public static SpeedController newObj = new SpeedController();

    public static void promptEnter() {
        System.out.print("\nPress \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void main(String[] args) {
        try {
            System.out.print("*****STARTING THE SYSTEM******\n\n");
            int sentinel = 1;
            Scanner sc = new Scanner(System.in);

            while (sentinel != 5) {
                System.out.print("\nEnter the number of the option you want to select:\n1. Increment Speed."
                        + " \n2. Decrement Speed.\n3. Emergency Brake.\n4. Display Current Speed \n5. Exit System.\n");

                try {
                    sentinel = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    sc.nextLine(); // Consume the invalid input
                    continue;
                }

                switch (sentinel) {
                    case 1: {
                        try {
                            SpeedController.Signal checkIncrement = newObj.Increment();
                            if (checkIncrement == SpeedController.Signal.INCREASE) {
                                System.out.print("Speed Incremented.\n");
                            } else {
                                System.out.print("Maximum Speed Reached. Cannot Increment Further.\n");
                            }
                        } catch (Exception e) {
                            System.out.println("An error occurred during speed increment: " + e.getMessage());
                        }
                        break;
                    }
                    case 2: {
                        try {
                            SpeedController.Signal checkDecrement = newObj.Decrement();
                            if (checkDecrement == SpeedController.Signal.DECREASE) {
                                System.out.print("Speed Decremented.\n");
                            } else {
                                System.out.print("Vehicle already at rest. Cannot decrement further.\n");
                            }
                        } catch (Exception e) {
                            System.out.println("An error occurred during speed decrement: " + e.getMessage());
                        }
                        break;
                    }
                    case 3: {
                        try {
                            SpeedController.Signal checkBrake = newObj.Brake();
                            if (checkBrake == SpeedController.Signal.BRAKE) {
                                System.out.print("Brake was applied. Stopping the vehicle...\n");
                            } else {
                                System.out.print("Vehicle already on rest. No application of brakes required.\n");
                            }
                        } catch (Exception e) {
                            System.out.println("An error occurred during brake application: " + e.getMessage());
                        }
                        break;
                    }
                    case 4: {
                        try {
                            System.out.print("The Current Speed is " + newObj.getCurrentSpeed() + " MPH.\n");
                        } catch (Exception e) {
                            System.out.println("An error occurred while retrieving current speed: " + e.getMessage());
                        }
                        break;
                    }
                    case 5: {
                        sentinel = 5;
                        break;
                    }
                    default: {
                        System.out.print("Invalid Choice. Select a Valid Option\n");
                        promptEnter();
                    }
                }
            }

            System.out.print("Exiting the system.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
