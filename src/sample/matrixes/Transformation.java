package sample.matrixes;

import sample.Vertex;

public abstract class Transformation {
    public double[][] transformationMatrix;
    protected double cosFi;
    protected double sinFi;
    public Vertex multiply(Vertex vertex){
        double[] newCoordinates = new double[vertex.getNumberOfCoordinates()];
        double[][] vector = asDouble(vertex);
        for(int i = 0; i < vector.length; i++)
            for(int j = 0; j < transformationMatrix[0].length; j++)
                for(int k = 0; k < transformationMatrix.length; k++)
                    newCoordinates[j] +=  vector[i][k] * transformationMatrix[k][j]  ;

        return vertex = asVertex(newCoordinates);
    }



    protected void getCosSin(double fi){
        cosFi = Math.cos(fi) ;
        sinFi = Math.sin(fi) ;
    }

    public Vertex asVertex(double[] vector){
        Vertex vertex = new Vertex(vector[0], vector[1], vector[2], vector[3]);
        return vertex;
    }

    public double[][] asDouble(Vertex vertex){
        double[][] vector = new double[1][vertex.getNumberOfCoordinates()];
        vector[0][0] = vertex.x;
        vector[0][1] = vertex.y;
        vector[0][2] = vertex.z;
        vector[0][3] = vertex.fourCoordinate;
        return vector;

    }

    public Vertex norm(Vertex vertex){
        vertex.x = vertex.x / vertex.fourCoordinate;
        vertex.y = vertex.y / vertex.fourCoordinate;
        vertex.z = vertex.z/ vertex .fourCoordinate;
        vertex.fourCoordinate = 1;
        return vertex;
    }



}