class Statistics {
    
    double sum(double[] a){
        double sum = 0;
        try{
            for(int x = 0; x < a.length; x++){
                sum = sum + a[x];
            }
        }catch(NullPointerException e){
            //sum remains the same
        }
        return sum;
    }

    double[] colSum(double[][] m){
        double[] collumnSum = new double[m.length];
        //row needs to be consistend while col is changing
        for (int col = 0; col < m[0].length; col ++){
            double sum = 0.0;
            for (int row = 0; row < m.length; row++){
                sum = sum + m[row][col];
            }
            collumnSum[col] = sum;
        }
        return collumnSum;
    }
    //int segSum(int[] a, int from, int upto){}

    void run(){
        //testing part 1
        double[] method = {1, 3, 4};
        System.out.println(sum(method));

        //testing part 2
        double[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {-1, -2, -3},
            {2, 4, 6}
        };
        double[] array = colSum(matrix);
        for (int x = 0; x < matrix[0].length; x++){
            System.out.print(array[x]);
            System.out.print(", ");
        }
    }

    public static void main(String[]args){
        (new Statistics()).run();
    }
}
