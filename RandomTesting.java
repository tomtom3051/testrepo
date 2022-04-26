import java.util.Random;
class RandomTesting {
    private long SEED = 37;
    Random random = new Random(SEED);
    void run(){
        int numberOne = random.nextInt(10);
        System.out.println("Number 1: " + numberOne);
        int numberTwo = random.nextInt(10);
        System.out.println("Number 2: " + numberTwo);
    }
    public static void main(String[]args){
        (new RandomTesting()).run();
    }
}