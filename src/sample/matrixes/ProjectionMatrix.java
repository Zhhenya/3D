package sample.matrixes;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class ProjectionMatrix extends Transformation {


    public double[][] getXY(){
        transformationMatrix = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };
        return transformationMatrix;
    }


    public double[][] getXZ(){
        transformationMatrix = new double[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return transformationMatrix;
    }

    public double[][] getYZ(){
        transformationMatrix = new double[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        return transformationMatrix;
    }

    public double[][] getCabinet(){
        double a = 1D / 2 * cos(PI / 4);
        transformationMatrix = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {a, a, 0, 0},
                {0, 0, 0, 1}
        };
        return transformationMatrix;
    }


    public double[][] getQ(){
        double coefficient = 8;
        transformationMatrix = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, coefficient},
                {0, 0, 0, 1}
        };
        return transformationMatrix;
    }






}