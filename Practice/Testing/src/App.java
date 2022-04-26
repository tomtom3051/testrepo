class Square{
    double size;
    void setSize(double s){
        size = s;
    }
    double getArea(){
        return size * size;
    }
    
}
class SquareDemo{
    void demo(){
        Square mySquare = new Square();
        mySquare.setSize(5);
        System.out.println(mySquare.getArea());
    }
}