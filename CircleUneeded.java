import java.util.Scanner;
/**
 * @author Tom Sijbers
 * @ID 1709208
 */

 class CircleUneeded{
    public void run() {
        //This part of the program receives the input variables
        //
        Scanner scanner = new Scanner(System.in);
        double xCoordinateCircle1 = scanner.nextDouble();
        double yCoordinateCircle1 = scanner.nextDouble();
        double radiusCircle1 = scanner.nextDouble();
        if (radiusCircle1 < 0){
            System.out.println("input error");
            System.exit(0);
        }

        double xCoordinateCircle2 = scanner.nextDouble();
        double yCoordinateCircle2 = scanner.nextDouble();
        double radiusCircle2 = scanner.nextDouble();
        if (radiusCircle2 < 0){
            System.out.println("input error");
            System.exit(0);
        }

        double pointX = scanner.nextDouble();
        double pointY = scanner.nextDouble();

        //Calculating whether point lies inside circles
        //Equation used: (x - center_x)^2 + (y - center_y)^2 < radius^2
        boolean insideCircle1 = false;
        double calculationOnePartOne = Math.pow((pointX-xCoordinateCircle1), 2) + Math.pow((pointY-yCoordinateCircle1), 2);
        double calculationOnePartTwo = Math.pow(radiusCircle1, 2);
        if(calculationOnePartOne < calculationOnePartTwo) {
            insideCircle1 = true;
        }
        
        boolean insideCircle2 = false;
        double calculationTwoPartOne = Math.pow((pointX-xCoordinateCircle2), 2) + Math.pow((pointY-yCoordinateCircle2), 2);
        double calculationTwoPartTwo = Math.pow(radiusCircle2, 2);
        if(calculationTwoPartOne < calculationTwoPartTwo) {
            insideCircle2 = true;
        }

        //Output if the values are inside the circle
        if (insideCircle1 && insideCircle2) {
            System.out.println("The point lies in both circles");
        }
        else if (insideCircle1) {
            System.out.println("The point lies in the first circle");
        }
        else if (insideCircle2){
            System.out.println("The point lies in the second circle");
        }
        else {
            System.out.println("The point does not lie in either circle");
        }
        scanner.close();
    }
    public static void main(String[]args){
        (new CircleUneeded()).run();
    }
}