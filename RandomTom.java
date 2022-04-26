import java.util.Random;
class RandomTom {
    
    public static void main(String[] args){
        Random random = new Random();
        for (int i = 0; i < 100; i ++){
            int numberOfShapes = random.nextInt(5);
            System.out.println(numberOfShapes);
        }
    }
}
