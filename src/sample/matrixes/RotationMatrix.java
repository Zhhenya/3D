package sample.matrixes;

public class RotationMatrix extends Transformation {

    //вращение вокруг оси OX

    public double[][] getRx(double fi){
        getCosSin(fi);
        transformationMatrix = new double[][]{{1, 0, 0, 0},
                            {0, cosFi, sinFi, 0},
                            {0, -sinFi, cosFi, 0},
                            {0, 0, 0, 1}};
        return transformationMatrix;
    }


    //вокруг оси Oy

    public double[][] getRy(double fi){
        getCosSin(fi);
        transformationMatrix = new double[][]{{cosFi, 0, -sinFi, 0},
                {0, 1, 0, 0},
                {sinFi, 0, cosFi, 0},
                {0, 0, 0, 1}};
        return transformationMatrix;
    }

    //вокруг оси Oz

    public double[][] getRz(double fi){
        getCosSin(fi);
        transformationMatrix = new double[][]{{cosFi, sinFi, 0, 0},
                {-sinFi, cosFi, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        return transformationMatrix;
    }
}