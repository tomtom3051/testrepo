import java.util.Scanner;
class AgeFinder1 {

    void show(){
        System.out.println("What year where you born?");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println("What month where you born?");
        int month = scanner.nextInt();
        System.out.println("What day of the month where you born?");
        int day = scanner.nextInt();
        System.out.println("What year is it now?");
        int currentYear = scanner.nextInt();
        System.out.println("What month is it now?");
        int currentMonth = scanner.nextInt();
        System.out.println("What day of the month is it now?");
        int currentDay = scanner.nextInt();
        int age = currentYear - year;
        if (month > currentMonth) {
            age = age - 1;
        }
        else if (month == currentMonth) {
            if (day > currentDay){
                age = age - 1;
            }
        }
        System.out.println("You are " + age + " years old!");

    }
    public static void main(String[]args){
        (new AgeFinder1()).show();
    }
} 