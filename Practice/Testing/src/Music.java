import java.util.ArrayList;

class Music {
    ArrayList<Piece> pieces= new ArrayList<Piece>();
    void demo(){
        demo1();
        System.out.println("-------------------");
        demo2();
    }
    
    void demo1(){
        Piece piece = new Piece();
        System.out.println(piece.toString());
    }

    void demo2(){
        pieces.add(new Piece("The Fifth", "London Symphony Orchestra"));
        pieces.add(new Song("One More Cup Ff Java", "Bob Dylan", 227));
        pieces.add(new Piece("Title", "artist"));
        printAll();
    }
    void printAll(){
        for (Piece piece : pieces){
            System.out.println(piece.toString());
        }
    }

    public static void main(String[] a){
        (new Music()).demo();
    }
}

class Piece{
    String title;
    String artist;

    Piece(){
        title = "Zonder titel";
        artist = "NN";
    }

    Piece(String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    public String toString(){
        String string = title + " -- " + artist;
        return string;
    }
}

class Song extends Piece{
    int duration;

    Song(String title, String artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    String secondsToMinutes(int d){
        int minutes = 0;
        int seconds = 0;
        //in case of hours do same but divide by 3600
        if((d/60) != 0){
            minutes = d/60;
            d = d%60;
        }
        if ((d) != 0){
            seconds = d;
        }
        String durationString = minutes + ":" + seconds;
        return durationString;
    }

    @Override
    public String toString(){
        
        String string = title + " -- " + artist + "\n" + "Duration " + secondsToMinutes(duration);
        return string;
    }
}
