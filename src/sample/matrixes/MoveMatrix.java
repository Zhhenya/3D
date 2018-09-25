package sample.matrixes;

public class MoveMatrix extends Transformation {
    public double[][] getMove(double move, String axis){
        transformationMatrix = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {axis == "OX" ? move : 0, axis == "OY" ? move : 0, axis == "OZ" ? move : 0, 1}
        };
        return transformationMatrix;
    }
}