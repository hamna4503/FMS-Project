import java.util.*;

public class SpeedControllerTestingClass {
    public static SpeedController newObj=new SpeedController();
    public static void promptEnter(){
        System.out.print("\nPress \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public static void main(String[] args){
        System.out.print("*****STARTING THE SYSTEM******\n\n");
        int sentinel=1;
        while(sentinel!=5){
            System.out.print("\nEnter the number of the option you want to select:\n1. Increment Speed." +
                    " \n2. Decrement Speed.\n3. Emergency Brake.\n4. Display Current Speed \n5. Exit System.\n");
            Scanner sc= new Scanner(System.in);
            sentinel= sc.nextInt();
            switch (sentinel){
                case 1: {
                    SpeedController.Signal checkIncrement=newObj.Increment();
                    if(checkIncrement== SpeedController.Signal.INCREASE){
                        System.out.print("Speed Incremented.\n");
                    }
                    else{
                        System.out.print("Maximum Speed Reached. Cannot Increment Further.\n");
                    }
                    break;
                }
                case 2:{
                    SpeedController.Signal checkDecrement=newObj.Decrement();
                    if(checkDecrement== SpeedController.Signal.DECREASE){
                        System.out.print("Speed Decremented.\n");
                    }
                    else{
                        System.out.print("Vehicle already at rest. Cannot decrement further.\n");


                    }
                    break;
                }
                case 3:{
                    SpeedController.Signal checkBrake=newObj.Brake();
                    if(checkBrake== SpeedController.Signal.BRAKE){
                        System.out.print("Brake was applied. Stopping the vehicle...\n");
                    }
                    else{
                        System.out.print("Vehicle already on rest. No application of brakes required.\n");
                    }

                    break;
                }
                case 4:{
                    System.out.print("The Current Speed is "+newObj.getCurrentSpeed()+" MPH.\n");
                    break;
                }
                case 5: {
                    sentinel=5;
                    break;
                }
                default:{
                    System.out.print("Invalid Choice.Select Valid Option\n");
                    promptEnter();
                }

            }

        }

        System.out.print("Exiting the system.");
    }
}
