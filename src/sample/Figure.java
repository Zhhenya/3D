package sample;

public class Figure {
   /* Vertex A = new Vertex(4, 2, 2);
    Vertex M = new Vertex(5, 4, 0);

    Vertex B = new Vertex(4, 6, 2);
    Vertex N = new Vertex(5, 8, 0);

    Vertex C = new Vertex(2, 6, 2);
    Vertex O = new Vertex(3, 8, 0);

    Vertex D = new Vertex(2, 10, 2);
    Vertex P = new Vertex(3, 12, 0);

    Vertex E = new Vertex(4, 10, 2);
    Vertex Q = new Vertex(5, 12, 0);

    Vertex F = new Vertex(4, 14, 2);
    Vertex R = new Vertex(5, 16, 0);

    Vertex G = new Vertex(6, 14, 2);
    Vertex S = new Vertex(7, 16, 0);

    Vertex H = new Vertex(6, 10, 2);
    Vertex T = new Vertex(7, 12, 0);

    Vertex I = new Vertex(8, 10, 2);
    Vertex U = new Vertex(9, 12, 0);

    Vertex J = new Vertex(8, 6, 2);
    Vertex V = new Vertex(9, 8, 0);

    Vertex K = new Vertex(6, 6, 2);
    Vertex W = new Vertex(7, 8, 0);

    Vertex L = new Vertex(6, 2, 2);
    Vertex X = new Vertex(7, 4, 0);*/

    /*Vertex A = new Vertex(150, 100, 100);
    Vertex M = new Vertex(200, 150, 0);

    Vertex B = new Vertex(150, 200, 100);
    Vertex N = new Vertex(200, 250, 0);

    Vertex C = new Vertex(50, 200, 100);
    Vertex O = new Vertex(100, 250, 0);

    Vertex D = new Vertex(50, 300, 100);
    Vertex P = new Vertex(100, 350, 0);

    Vertex E = new Vertex(150, 300, 100);
    Vertex Q = new Vertex(200, 350, 0);

    Vertex F = new Vertex(150, 400, 100);
    Vertex R = new Vertex(200, 450, 0);

    Vertex G = new Vertex(250, 400, 100);
    Vertex S = new Vertex(300, 450, 0);

    Vertex H = new Vertex(250, 300, 100);
    Vertex T = new Vertex(300, 350, 0);

    Vertex I = new Vertex(350, 300, 100);
    Vertex U = new Vertex(400, 350, 0);

    Vertex J = new Vertex(350, 200, 100);
    Vertex V = new Vertex(400, 250, 0);

    Vertex K = new Vertex(250, 200, 100);
    Vertex W = new Vertex(300, 250, 0);

    Vertex L = new Vertex(250, 100, 100);
    Vertex X = new Vertex(300, 150, 0);//*/


   /* Vertex A = new Vertex(150, 100, 100);
    Vertex M = new Vertex(200, 150, 0);

    Vertex B = new Vertex(150, 200, 100);
    Vertex N = new Vertex(200, 250, 0);

    Vertex C = new Vertex(50, 200, 100);
    Vertex O = new Vertex(100, 250, 0);

    Vertex D = new Vertex(50, 300, 100);
    Vertex P = new Vertex(100, 350, 0);

    Vertex E = new Vertex(150, 300, 100);
    Vertex Q = new Vertex(200, 350, 0);

    Vertex F = new Vertex(150, 400, 100);
    Vertex R = new Vertex(200, 450, 0);

    Vertex G = new Vertex(250, 400, 100);
    Vertex S = new Vertex(300, 450, 0);

    Vertex H = new Vertex(250, 300, 100);
    Vertex T = new Vertex(300, 350, 0);

    Vertex I = new Vertex(350, 300, 100);
    Vertex U = new Vertex(400, 350, 0);

    Vertex J = new Vertex(350, 200, 100);
    Vertex V = new Vertex(400, 250, 0);

    Vertex K = new Vertex(250, 200, 100);
    Vertex W = new Vertex(300, 250, 0);

    Vertex L = new Vertex(250, 100, 100);
    Vertex X = new Vertex(300, 150, 0);*/

   /*Vertex[] matrix = new Vertex[]{
           new Vertex(150, 100, 100),
           new Vertex(200, 150, 50),

           new Vertex(150, 200, 100),
           new Vertex(200, 250, 50),

           new Vertex(50, 200, 100),
           new Vertex(100, 250, 50),

           new Vertex(50, 300, 100),
           new Vertex(100, 350, 50),

           new Vertex(150, 300, 100),
           new Vertex(200, 350, 50),

           new Vertex(150, 400, 100),
           new Vertex(200, 450, 50),

           new Vertex(250, 400, 100),
           new Vertex(300, 450, 50),

           new Vertex(250, 300, 100),
           new Vertex(300, 350, 50),

           new Vertex(350, 300, 100),
           new Vertex(400, 350, 50),

           new Vertex(350, 200, 100),
           new Vertex(400, 250, 50),

           new Vertex(250, 200, 100),
           new Vertex(300, 250, 50),

           new Vertex(250, 100, 100),
           new Vertex(300, 150, 50)

   };*/

    Vertex[] matrix;

    public void setFigureCoordinate(){
        matrix = new Vertex[]{
                new Vertex(-100, -300, 100), //A
                new Vertex(-100, -300, -100),

                new Vertex(-100, -100, 100), //B
                new Vertex(-100, -100, -100),

                new Vertex(-300, -100, 100), //C
                new Vertex(-300, -100, -100),

                new Vertex(-300, 100, 100), //D
                new Vertex(-300, 100, -100),

                new Vertex(-100, 100, 100), //E
                new Vertex(-100, 100, -100),

                new Vertex(-100, 300, 100), //F
                new Vertex(-100, 300, -100),

                new Vertex(100, 300, 100), //G
                new Vertex(100, 300, -100),

                new Vertex(100, 100, 100), //H
                new Vertex(100, 100, -100),

                new Vertex(300, 100, 100), //I
                new Vertex(300, 100, -100),

                new Vertex(300, -100, 100), //J
                new Vertex(300, -100, -100),

                new Vertex(100, -100, 100), //K
                new Vertex(100, -100, -100),

                new Vertex(100, -300, 100),  //L
                new Vertex(100, -300, -100)
        };
    }


  /*  Vertex[] matrix = new Vertex[]{
            new Vertex(150, 100, 100),
            new Vertex(150, 100, 50),

            new Vertex(150, 200, 100),
            new Vertex(150, 200, 50),

            new Vertex(50, 200, 100),
            new Vertex(50, 200, 50),

            new Vertex(50, 300, 100),
            new Vertex(50, 300, 50),

            new Vertex(150, 300, 100),
            new Vertex(150, 300, 50),

            new Vertex(150, 400, 100),
            new Vertex(150, 400, 50),

            new Vertex(250, 400, 100),
            new Vertex(250, 400, 50),

            new Vertex(250, 300, 100),
            new Vertex(250, 300, 50),

            new Vertex(350, 300, 100),
            new Vertex(350, 300, 50),

            new Vertex(350, 200, 100),
            new Vertex(350, 200, 50),

            new Vertex(250, 200, 100),
            new Vertex(250, 200, 50),

            new Vertex(250, 100, 100),
            new Vertex(250, 100, 50)

    };*/


    public void changeMatrixX(){
       for(int i = 0; i < 24; i++) {
           matrix[i].x += 400;
       }
   }

    public void divCoordinate(){
        for(int i = 0; i < 24; i++) {
            matrix[i].x /= 2;
            matrix[i].y /= 2;
            matrix[i].z /= 2;
        }
    }

    public void changeMatrixY(){
        for(int i = 0; i < 24; i++) {
            matrix[i].y += 600;
        }
    }

    public void changeMatrixZ(){
        for(int i = 0; i < 24; i++) {
            matrix[i].z += 600;
        }
    }

    public void initFigureMatrix(){
        matrix = new Vertex[24];
    }
}