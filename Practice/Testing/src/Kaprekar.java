class Kaprekar{

    int[] int2array(int n){
        int[] array = new int[4];
        for (int i = 0; i < 4; i++){
            if (n >= 0){
                array[i] = n%10;
                n = n/10;
            }else{
                array[i] = 0;
            }
        }
        return array;
    }

    int array2int(int[] array){
        int number = 0;
        for (int x = 0; x < array.length; x++){
            number = number * 10;
            number = number + array[x];
        }
        return number;
    }

    int nextKaprekar(int n){
        int[] array = int2array(n);
        for (int i = 0; i < array.length; i++){
            int currentMinimum = array[i];
            int minLocation = i;
            for (int j = i; j < array.length; j++){
                if(array[j]<currentMinimum){
                    currentMinimum = array[j];
                    minLocation = j;
                }
            }
            array[minLocation] = array[i];
            array[i] = currentMinimum;
        }
        int kaprekarMin = array2int(array);


        for (int i = 0; i < array.length; i++){
            int currentMax = array[i];
            int maxLocation = i;
            for (int j = i; j < array.length; j++){
                if(array[j]>currentMax){
                    currentMax = array[j];
                    maxLocation = j;
                }
            }
            array[maxLocation] = array[i];
            array[i] = currentMax;
        }


        int kaprekarMax = array2int(array);
        int kaprekar = kaprekarMax - kaprekarMin;
        System.out.println(kaprekarMax + " - " + kaprekarMin + " = " + kaprekar);
        return kaprekar;
    }

    void run(){
        int number = 1211;
        while (number != 0 && number != 6174){
            number = nextKaprekar(number);
        }
    }


    public static void main(String[] a){
        (new Kaprekar()).run();
    }
}