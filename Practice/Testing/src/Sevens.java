class Sevens {  
    int lastDigit(int n){
        int lastDigit = n%10;
        return lastDigit;
    }

    int sevenCount(int n){
        int sevens = 0;
        while (n >= 1){
            if (n%10 == 7){
                sevens++;
            }
            n = n/10;
        }
        return sevens;
    }
    int count = 0;
    int sevenCount2(int n){
        if (n >= 1){
            if (n%10 == 7){
                count ++;
            }
            n = n/10;
            sevenCount2(n);
        }
        
        return count;
    }

    
    int drop7(int n){
        while (n>=1){
            if (n%10 == 7){
                n-= 7;
            }
            n= n/10;
            drop7(n);
            n = n*10;
        }
        return n;
    }
    
    void run(){
        int number = 17;
        System.out.println(lastDigit(number));
        System.out.println(sevenCount(number));
        System.out.println(sevenCount2(number));
        System.out.println(drop7(number));
    }

    public static void main(String[]args){
        (new Sevens()).run();
    }
}
