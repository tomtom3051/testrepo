import java.util.Scanner;
class LeapYear {
    
    void show(){
        System.out.println("Please write a year.");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        boolean leapYear = false;
        if (year%100 == 0) {
            leapYear = false; 
        }
        else if (year%4 == 0){
            leapYear = true;
        }
        else {
            leapYear = false; 
        }
        if (leapYear == true){
            System.out.println("The statement year " + year + " is a leap year is true");
        }
        else if (leapYear == false) {
            System.out.println("The statement year " + year + " is a leap year is false");
        }

    }
    public static void main(String[]args){
        (new LeapYear()).show();
    }
}
