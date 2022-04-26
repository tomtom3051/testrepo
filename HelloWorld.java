/*
* @author Tom Sijbers
@ date 11/09/21
*
* example to demonstrate console output
*/

class HelloWorld{

    //Put message on console
    void show() {
        System.out.println("Hello world, this is a java program.");
        System.out.println("Good luck, programmer!");
        String test = "Hello World";
        String[] parts = test.split(" ");
        System.out.println(parts[0]);
        System.out.println(parts[1]);
    }

    //start-up code
    public static void main(String[]args){
        (new HelloWorld()).show();
    }
}