import java.util.Scanner;
/**
 * @author Tom Sijbers
 * @ID 1709208
 */
class Circle {
    //A method to read from console and validate the input
    private double readFromConsole(Scanner scanner) {
        double retVal = 0;
        boolean invalidInput = true;

        while (invalidInput) { 
            String inputText = scanner.next();
            try {
                retVal = Double.valueOf(inputText);
                invalidInput = false;
            }
            catch(NumberFormatException e) {
                System.out.println("input error");
            }
        }

        return retVal;
    }

    public void run(){
        //getting the input values
        Scanner scanner = new Scanner(System.in);
        double xCoordinateCircle1 = readFromConsole(scanner);
        double yCoordinateCircle1 = readFromConsole(scanner);

        double radiusCircle1 = readFromConsole(scanner);
        //if statement ensures that the radius is not a negative number
        if (radiusCircle1 < 0){
            System.out.println("input error");
            System.exit(0);
        }

        double xCoordinateCircle2 = readFromConsole(scanner);
        double yCoordinateCircle2 = readFromConsole(scanner);

        double radiusCircle2 = readFromConsole(scanner);
        if (radiusCircle2 < 0){
            System.out.println("input error");
            System.exit(0);
        }

        double pointX = readFromConsole(scanner);
        double pointY = readFromConsole(scanner);

        //Calculating whether point lies inside circles
        //(x - center_x)^2 + (y - center_y)^2 < radius^2
        // Calculation is split into two parts (part 1:(x - center_x)^2 + (y - center_y)^2), and (Part 2: radius^2)
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
        (new Circle()).run();
    }
}