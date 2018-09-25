package sample.matrixes;

public class ScalingMatrix extends Transformation {
    public double[][] getScale(double coefficient, String axis){
        transformationMatrix = new double[][]{
            {axis == "OX" || axis == "*" ? coefficient: 1, 0, 0, 0},
            {0, axis == "OY" || axis == "*" ? coefficient : 1, 0, 0},
            {0, 0, axis == "OZ" || axis == "*" ? coefficient : 1, 0},
            {0, 0, 0, 1}
        };
        return transformationMatrix;
    }
}
