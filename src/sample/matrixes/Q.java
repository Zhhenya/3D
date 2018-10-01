package sample.matrixes;

public class Q extends Transformation {
    public double[][] getQ(){
        double coefficient = 500;
        transformationMatrix = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, -1/coefficient},
                {0, 0, 0, 1}
        };
        return transformationMatrix;
    }
}