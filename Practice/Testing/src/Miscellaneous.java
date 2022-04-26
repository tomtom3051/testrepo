class Miscellaneous {
    int possum(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] > 0){
                sum += numbers[i];
            }
        }
        return sum;
    }

    
    void test(){
        int[] array = {1, 2, 2, -3, 5};
        System.out.println(possum(array));
    }
    public static void main(String[]args){
        (new Miscellaneous()).test();
    }
}

/*
Q1.2
the method returns a boolean variable "result", the variable returns true if 0 is in the given array of integers

Q1.3
The new method would return true only if the last number in an array is 0, so it is checking whether the array ends in 0

*/