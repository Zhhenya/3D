package sample;

import sample.matrixes.Transformation;

public class MoveSystemOfCoordinate extends Transformation {
    public double[][] getMoveMatrix(){
        return transformationMatrix;
    }
}