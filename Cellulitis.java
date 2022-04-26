// Cellulitis TEMPLATE
// Homework Assignment 3 2ip90 
/** 
 * @name Tom Sijbers
 * @id 1709208
 * @name IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 26/09/21
 */
import java.util.Scanner;
class Cellulitis{
    //import scanner and define variables that need to be used in multiple methods
    Scanner scanner = new Scanner(System.in);
    String type = scanner.next();
    int length = scanner.nextInt();
    int generations = scanner.nextInt();
    boolean[] currentGeneration = new boolean[length];
    boolean[] nextGeneration = new boolean[length];
    boolean incorrectInput = true;
    boolean looping = false;
    //void draw is a method that takes an array turns it into a string, formats it and prints it
    void draw(){
        String output = java.util.Arrays.toString(currentGeneration).replaceAll("\\s+","");
        output = output.replaceAll("[\\[\\](){}]","").replace("false"," ").replace("true","*").replace(",","");
        System.out.println(output);
    }
    //this is the ruleset for type A it applies the rules for creating a new generation with type A
    void nextGenerationA(){
        draw();
        //loop ensures the rules are carried out for every generation specified
        for (int counter = 0; counter < generations-1; counter++){
            //loop ensures that the array can be changed for every value
            for(int i = 0; i < currentGeneration.length; i++) {
                //when i = 0 there is no neighbour so rules are specified separately
                if (i == 0){
                    if (currentGeneration[i+1] && currentGeneration[i]){
                        nextGeneration[i] = true;
                    }
                    else if (!currentGeneration[i] && currentGeneration[i+1]){
                        nextGeneration[i] = true;
                    }
                    else if (currentGeneration[i] && !currentGeneration[i+1]){
                        nextGeneration[i] = false;
                    }
                    else if (!currentGeneration[i] && !currentGeneration[i+1]){
                        nextGeneration[i] = false;
                    }
                }
                //when i = last value in array there is no neighbour so rules are specified separately
                else if (i == currentGeneration.length-1){
                    if (currentGeneration[i-1] && currentGeneration[i]){
                        nextGeneration[i] = true;
                    }
                    else if (!currentGeneration[i-1] && currentGeneration[i]){
                        nextGeneration[i] = false;
                    }
                    else if (currentGeneration[i-1]  && !currentGeneration[i]){
                        nextGeneration[i] = true;
                    }
                    else if (!currentGeneration[i-1]  && !currentGeneration[i]){
                        nextGeneration[i] = false;
                    }
                }
                //rules for when element in array is true
                else if (currentGeneration[i]){
                    if (currentGeneration[i-1] ^ currentGeneration[i+1]){
                        nextGeneration[i] = true;
                    }
                    else {
                        nextGeneration[i] = false;
                    }
                }
                //rules for when element in array is false
                else if (!currentGeneration[i]){
                    if (!currentGeneration[i+1] && !currentGeneration[i-1]){
                        nextGeneration[i] = false;
                    }
                    else{
                        nextGeneration[i] = true;
                    }
                }
            }
            //changes the currentGeneration into the newly created generation
            for (int x = 0; x<currentGeneration.length; x++){
                currentGeneration[x] = nextGeneration[x];
            }
            draw();
        } 
    }
    //this is the ruleset for type B it applies the rules for creating a new generation with type B
    void nextGenerationB(){
        draw();
        //loop ensures the rules are carried out for every generation specified
        for (int counter = 0; counter < generations-1; counter++){
            //loop ensures that the array can be changed for every value
            for(int i = 0; i < currentGeneration.length; i++) {
                //when i = 0 there is no neighbour so rules are specified separately
                if (i == 0){
                    if (currentGeneration[i] && currentGeneration[i+1]){
                        nextGeneration[i] = false;
                    }
                    else if (!currentGeneration[i] && currentGeneration[i+1]){
                        nextGeneration[i] = true;
                    }
                    else if (currentGeneration[i] && !currentGeneration[i+1]){
                        nextGeneration[i] = true;
                    }
                    else if (!currentGeneration[i] && !currentGeneration[i+1]){
                        nextGeneration[i] = false;
                    }   
                }
                //when i = last value in array there is no neighbour so rules are specified separately
                else if (i == currentGeneration.length-1){
                    if (currentGeneration[i-1] && currentGeneration[i]){
                        nextGeneration[i] = false;
                    }
                    else if (!currentGeneration[i-1] && currentGeneration[i]){
                        nextGeneration[i] = true;
                    }
                    else if (currentGeneration[i-1]  && !currentGeneration[i]){
                        nextGeneration[i] = false;
                    }
                    else if (!currentGeneration[i-1]  && !currentGeneration[i]){
                        nextGeneration[i] = false;
                    }
                }
                //rules for when element in array is true
                else if (currentGeneration[i]){
                    if (!currentGeneration[i+1]){
                        nextGeneration[i] = true;
                    }
                    else{
                        nextGeneration[i] = false;
                    }
                }
                //rules for when element in array is false
                else if (!currentGeneration[i]){
                    if (currentGeneration[i-1] ^ currentGeneration[i+1]){
                        nextGeneration[i]=true;
                    }
                }
            }
            //changes the currentGeneration into the newly created generation
            for (int x = 0; x<currentGeneration.length; x++){
                currentGeneration[x] = nextGeneration[x];
            }
            draw();
        }
        
    }
    //this is the ruleset for type U it applies the rules for creating a new generation with type U
    void nextGenerationU(){
        boolean[] ruleSequence = new boolean[8];
        //creates the ruleSequence array so we can access the necessary rule changes
        for (int f = 0; f<ruleSequence.length; f++){
            int input = scanner.nextInt();
            if (input == 1){
                ruleSequence[f] = true;
            }
            else if (input == 0){
                ruleSequence[f] = false;
            }
        }
        draw();
        //loop ensures the rules are carried out for every generation specified
        for (int counter = 0; counter < generations-1; counter++){
            //loop ensures that the array can be changed for every value
            for(int i = 0; i < currentGeneration.length; i++) {
                //when i = 0 there is no neighbour so rules are specified separately
                if (i == 0){
                    if (!currentGeneration[i] && !currentGeneration[i+1]){
                        nextGeneration[i] = ruleSequence[0];
                    }
                    else if (!currentGeneration[i] && currentGeneration[i+1]){
                        nextGeneration[i] = ruleSequence[1];
                    }
                    else if(currentGeneration[i] && !currentGeneration[i+1]){
                        nextGeneration[i] = ruleSequence[2];
                    }
                    else if(currentGeneration[i] && currentGeneration[i+1]){
                        nextGeneration[i] = ruleSequence[3];
                    }
                }
                //when i = last value in array there is no neighbour so rules are specified separately
                else if (i == currentGeneration.length-1){
                    if (!currentGeneration[i-1] && !currentGeneration[i]){
                        nextGeneration[i] = ruleSequence[0]; 
                    }
                    else if(currentGeneration[i-1] && !currentGeneration[i]){
                        nextGeneration[i] = ruleSequence[4];
                    }
                    else if(!currentGeneration[i-1] && currentGeneration[i]){
                        nextGeneration[i] = ruleSequence[2];
                    }
                    else if(currentGeneration[i-1] && currentGeneration[i]){
                        nextGeneration[i] = ruleSequence[6];
                    }
                }
                //rule for pattern 111
                else if (currentGeneration[i-1] && currentGeneration[i] && currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[7];
                }
                //rule for pattern 110
                else if (currentGeneration[i-1] && currentGeneration[i] && !currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[6];
                }
                //rule for pattern 101
                else if (currentGeneration[i-1] && !currentGeneration[i] && currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[5];
                }
                //rule for pattern 100
                else if (currentGeneration[i-1] && !currentGeneration[i] && !currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[4];
                }
                //rule for pattern 011
                else if(!currentGeneration[i-1] && currentGeneration[i] && currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[3];
                }
                //rule for pattern 010
                else if (!currentGeneration[i-1] && currentGeneration[i] && !currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[2];
                }
                //rule for pattern 001
                else if(!currentGeneration[i-1] && !currentGeneration[i] && currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[1];
                }
                //rule for pattern 000
                else if(!currentGeneration[i-1] && !currentGeneration[i] && !currentGeneration[i+1]){
                    nextGeneration[i] = ruleSequence[0];
                }
            }
            //changes the currentGeneration into the newly created generation
            for (int x = 0; x<currentGeneration.length; x++){
                currentGeneration[x] = nextGeneration[x];
            }
            draw();
        }

    }
    //this is the main method run which executes the full code
    void run(){
        //creates a loop that starts when init_start is typed, this loop ensures we can enter multiple intigers before init_end ends the loop
        while(incorrectInput) {
            String initStart = scanner.next();
            if (initStart.toLowerCase().equals("init_start")){
                incorrectInput = false;
                looping = true;
            }
        }
        while (looping){
            String input = scanner.next();
            if (input.matches("[0-9]+")){
                int number = Integer.parseInt(input);
                currentGeneration[number-1] = true;
            }
            else if (input.toLowerCase().equals("init_end")){
                looping = false;
            }
        }
        //if statements check for type a b or u and call upon the appropriate method
        if (type.toLowerCase().equals("a")){
            nextGenerationA();
        }
        else if (type.toLowerCase().equals("b")){
            nextGenerationB();
        }  
        else if (type.toLowerCase().equals("u")){
            nextGenerationU();
        }
    }        
    public static void main(String[] args){
        new Cellulitis().run();
    }
}