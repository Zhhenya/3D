package sample;

public class Vertex {
    public double x;
    public double y;
    public double z;
    public double fourCoordinate;

    private final int numberOfCoordinates = 4;

    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        fourCoordinate = 1;
    }
    public Vertex(double x, double y, double z, double fourCoordinate){
        this.x = x;
        this.y = y;
        this.z = z;
        this.fourCoordinate = fourCoordinate;
    }

    public int getNumberOfCoordinates(){
        return numberOfCoordinates;
    }



}
