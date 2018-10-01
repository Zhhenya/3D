package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import sample.matrixes.*;

import java.util.Random;



public class DrawFigure{
    private final int countOfVertex = 12;
    private final int numberOfVertex = 24;
    private final int numberOfButtons = 3;
    private RadioButton[] planeButtons = new RadioButton[numberOfButtons + 2];
    private RadioButton[] rotationButtons = new RadioButton[numberOfButtons];
    private RadioButton[] scaleButtons = new RadioButton[numberOfButtons + 1];
    private RadioButton[] moveButtons = new RadioButton[numberOfButtons];
    private ToggleGroup groupPlaneButtons = new ToggleGroup();
    private ToggleGroup groupRotationButtons = new ToggleGroup();
    private ToggleGroup groupScaleButtons = new ToggleGroup();
    private ToggleGroup groupMoveButtons = new ToggleGroup();
    private RotationMatrix rotationMatrix = new RotationMatrix();
    private ProjectionMatrix projectionMatrix = new ProjectionMatrix();
    private ScalingMatrix scalingMatrix = new ScalingMatrix();
    private Pane pane = new Pane();
    private Figure figure = new Figure();
    private final int HEIGHT = 700;
    private final int WIDTH = 1000;
    private RadioButton selectButtonPlane;
    private MoveMatrix moveMatrix = new MoveMatrix();
    private Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), e->{
        deleteEdge();
    }));
    private boolean start = false;
    private  int countChildren = 0;
    public AnchorPane getPane(){
        AnchorPane anchorPane = new AnchorPane();
        figure.setFigureCoordinate();
        figure.divCoordinate();
    //    figure.divCoordinate();

        //панель для отрисовки

        pane.setPrefSize(WIDTH, HEIGHT);
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        //кнопки выбора проекции
        Label planeLabel = new Label("Прекция на плоскость");
        Label planeO = new Label("Ортографическая");
        planeLabel.setLayoutX(1100);
        planeLabel.setLayoutY(5);
        planeO.setLayoutX(1050);
        planeO.setLayoutY(60);
        planeButtons[0] = addRadiobutton("XY", groupPlaneButtons, 1050, 20, 50, 50, true);
        planeButtons[1] = addRadiobutton("YZ", groupPlaneButtons, 1100, 20, 50, 50, false);
        planeButtons[2] = addRadiobutton("ZX", groupPlaneButtons, 1150, 20, 50, 50, false);
        planeButtons[3] = addRadiobutton("CAB", groupPlaneButtons, 1200, 20, 50, 50, false);
        planeButtons[4] = addRadiobutton("Q", groupPlaneButtons, 1250, 20, 50, 50, false);
        anchorPane.getChildren().addAll(planeButtons[0], planeButtons[1], planeButtons[2], planeButtons[3], planeButtons[4], planeLabel, planeO);

        //кнопки выбора оси вращения
        Label rotationLabel = new Label("Поворот по оси");
        rotationLabel.setLayoutX(1100);
        rotationLabel.setLayoutY(100);
        rotationButtons[0] = addRadiobutton("OX", groupRotationButtons, 1050, 120, 50, 50, false);
        rotationButtons[1] = addRadiobutton("OY", groupRotationButtons, 1100, 120, 50, 50, true);
        rotationButtons[2] = addRadiobutton("OZ", groupRotationButtons, 1150, 120, 50, 50, false);
        anchorPane.getChildren().addAll(rotationButtons[0], rotationButtons[1], rotationButtons[2], rotationLabel);


        //кнопки выбора оси масштабирования
        Label scaleLabel = new Label("Масштабирование по оси");
        scaleLabel.setLayoutX(1100);
        scaleLabel.setLayoutY(180);
        scaleButtons[0] = addRadiobutton("OX", groupScaleButtons, 1050, 200, 50, 50, false);
        scaleButtons[1] = addRadiobutton("OY", groupScaleButtons, 1100, 200, 50, 50, true);
        scaleButtons[2] = addRadiobutton("OZ", groupScaleButtons, 1150, 200, 50, 50, false);
        scaleButtons[3] = addRadiobutton("*", groupScaleButtons, 1150, 200, 50, 50, false);

        anchorPane.getChildren().addAll(scaleButtons[0], scaleButtons[1], scaleButtons[2], scaleButtons[3],  scaleLabel);


        //добавить listener для выбора оси
        groupPlaneButtons.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton selectedPlane = (RadioButton)groupPlaneButtons.getSelectedToggle();
                drawForToggle(projectionMatrix, selectedPlane.getText());
            }
        });


        //кнопки выбора оси перемещения
        Label moveLabel = new Label("Перемещение по оси");
        moveLabel.setLayoutX(1100);
        moveLabel.setLayoutY(270);
        moveButtons[0] = addRadiobutton("OX", groupMoveButtons, 1050, 300, 50, 50, false);
        moveButtons[1] = addRadiobutton("OY", groupMoveButtons, 1100, 300, 50, 50, true);
        moveButtons[2] = addRadiobutton("OZ", groupMoveButtons, 1150, 300, 50, 50, false);

        anchorPane.getChildren().addAll(moveButtons[0], moveButtons[1], moveButtons[2], moveLabel);





        ProjectionMatrix projectionMatrix = new ProjectionMatrix();
        projectionMatrix.getXY();
        draw(pane, figure, projectionMatrix, Plane.XY);
        anchorPane.getChildren().add(pane);
        return anchorPane;
    }

    public void scale(ScrollEvent event){
        RadioButton selectScaleButton = (RadioButton) groupScaleButtons.getSelectedToggle();
        RadioButton selectPlaneButton = (RadioButton) groupPlaneButtons.getSelectedToggle();
        scalingMatrix.getScale(event.getDeltaY() < 0 ? 1.1 : 0.9, selectScaleButton.getText());
        multiply(0, figure, scalingMatrix);
        drawForToggle(projectionMatrix, selectPlaneButton.getText());
    }


    private  void drawForToggle(ProjectionMatrix matrix, String plane){
        pane.getChildren().remove(0, pane.getChildren().size());
        switch (plane){
            case "XY":
                matrix.getXY();
                draw(pane, figure, matrix, Plane.XY);
                break;
            case "YZ":
                matrix.getYZ();
                draw(pane, figure, matrix, Plane.YZ);
                break;
            case "ZX":
                matrix.getXZ();
                draw(pane, figure, matrix, Plane.ZX);
                break;
            case "CAB":
                matrix.getCabinet();
                draw(pane, figure, matrix, Plane.CAB);
                break;
            case "Q":
                matrix.getQ();
                draw(pane, figure, matrix, Plane.Q);
                break;

        }
    }

    //отрисовка всей фигуры
    private void draw(Pane pane, Figure figure, Transformation matrix, Plane plane) {
        Figure figureForDraw = new Figure();
        figureForDraw.initFigureMatrix();
        double[] coodrAxis = convert(new double[]{-600, 0, 600, 0});

        for(int i = 0; i < numberOfVertex; i++)
            figureForDraw.matrix[i] = matrix.norm(matrix.multiply(figure.matrix[i]));

        //отрисовка лицевой части
        drawFigure(pane, matrix, figureForDraw, 0, 3, plane);
        //отрисовка задней части
        drawFigure(pane, matrix, figureForDraw, 1, 2, plane);
        //отрисовка середины
        drawFigure(pane, figureForDraw, plane);

        Line axisOne = new Line(coodrAxis[0], coodrAxis[1], coodrAxis[2], coodrAxis[3]);
        coodrAxis = convert(new double[]{0, -600, 0, 600});
        Line axisTwo= new Line(coodrAxis[0], coodrAxis[1], coodrAxis[2], coodrAxis[3]);
        pane.getChildren().addAll(axisOne, axisTwo);

    }

    private void multiply(int start, Figure figure, Transformation matrix){
        for(int i = start; i < numberOfVertex; i++)
             figure.matrix[i] = (matrix.multiply(figure.matrix[i]));
    }

    //отрисовка передней/задней части фигуры
    private void drawFigure(Pane pane, Transformation matrix, Figure figure, int start, int back, Plane plane){
        double[] coordinates;
        for(int i =  start; i < numberOfVertex - back; i++) {
            coordinates = convert(getCoordinate(plane, figure, i, i + 2));
            pane.getChildren().add(new Line(coordinates[0], coordinates[1], coordinates[2], coordinates[3]));
        }
        coordinates = convert(getCoordinate(plane, figure, numberOfVertex - (back - 1), start));
        pane.getChildren().add(new Line(coordinates[0], coordinates[1], coordinates[2], coordinates[3]));
    }

    //отрисовка середины
    private void drawFigure(Pane pane, Figure figure, Plane plane){
        double[] coordinates;
        for(int i = 0 ; i < numberOfVertex - 1; i++) {
            coordinates = convert(getCoordinate(plane, figure, i, i + 1));
            pane.getChildren().add(new Line(coordinates[0], coordinates[1], coordinates[2], coordinates[3]));
        }
        coordinates = convert(getCoordinate(plane, figure, numberOfVertex - 1, 0));
        pane.getChildren().add(new Line(coordinates[0], coordinates[1], coordinates[2], coordinates[3]));
    }

    private RadioButton addRadiobutton(String text, ToggleGroup group, int x, int y, int width, int height, boolean select){
        RadioButton button = new RadioButton();
        button.setText(text);
        button.setToggleGroup(group);
        button.setPrefSize(width, height);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setSelected(select);
        button.setBlendMode(BlendMode.MULTIPLY);
        button.setFocusTraversable(false);
        return button;
    }

    private double[] getCoordinate(Plane plane, Figure figure, int firstIndex, int secondIndex){
        double[] coordinates = new double[4];
        switch(plane){
            case YZ: coordinates[0] = figure.matrix[firstIndex].z;
                coordinates[1] = figure.matrix[firstIndex].y;
                coordinates[2] = figure.matrix[secondIndex].z;
                coordinates[3] = figure.matrix[secondIndex].y;
                break;
            case ZX: coordinates[0] = figure.matrix[firstIndex].x;
                coordinates[1] = figure.matrix[firstIndex].z;
                coordinates[2] = figure.matrix[secondIndex].x;
                coordinates[3] = figure.matrix[secondIndex].z;
                break;
            default:coordinates[0] = figure.matrix[firstIndex].x;
                coordinates[1] = figure.matrix[firstIndex].y;
                coordinates[2] = figure.matrix[secondIndex].x;
                coordinates[3] = figure.matrix[secondIndex].y;
        }
        return coordinates;
    }


    public boolean onKeyEvent(KeyEvent e) {
        if(e.getEventType() == KeyEvent.KEY_PRESSED){
            RadioButton selectedButtonPlane = (RadioButton) groupPlaneButtons.getSelectedToggle();
            if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT) {
                RadioButton selectedButton = (RadioButton) groupRotationButtons.getSelectedToggle();
                switch (selectedButton.getText()) {
                    case "OX":
                        rotationMatrix.getRx(Math.PI / 180 * 3 * (e.getCode().getCode() == 39 ? -1 : 1));
                        multiply(0, figure, rotationMatrix);
                        break;
                    case "OY":
                        rotationMatrix.getRy(Math.PI / 180 * 3 * (e.getCode().getCode() == 39 ? -1 : 1));
                        multiply(0, figure, rotationMatrix);
                        break;
                    case "OZ":
                        rotationMatrix.getRz(Math.PI / 180 * 3 * (e.getCode().getCode() == 39 ? -1 : 1));
                        multiply(0, figure, rotationMatrix);
                        break;
                }

                drawForToggle(projectionMatrix, selectedButtonPlane.getText());

            }else
                if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.DOWN){
                    RadioButton selectedButton = (RadioButton) groupMoveButtons.getSelectedToggle();
                    moveMatrix.getMove(e.getCode() .getCode() == 38 ? 1 : -1, selectedButton.getText());
                    multiply(0, figure, moveMatrix);
                    drawForToggle(projectionMatrix, selectedButtonPlane.getText());
                }
                else
                    if(e.getCode() == KeyCode.SPACE && selectedButtonPlane.getText() != "CAB" && selectedButtonPlane.getText() != "Q"){
                        danceEdge();
                }
        }
        return false;
    }


    private double[] convert(double[] oldCoordinates){
        double[] newCoordinates = new double[4];
        newCoordinates[0] = oldCoordinates[0] + 800 / 2;
        newCoordinates[1] = -oldCoordinates[1] + 600 / 2;
        newCoordinates[2] = oldCoordinates[2] + 800 / 2;
        newCoordinates[3] = -oldCoordinates[3] + 600 / 2;
        return newCoordinates;
    }


    private void danceEdge(){
        RadioButton selectedButtonPlane = (RadioButton) groupPlaneButtons.getSelectedToggle();
        selectButtonPlane = (RadioButton) groupPlaneButtons.getSelectedToggle();
        Random random = new Random();
        double coordOne = 0;
        double coordTwo = 0;
        double[] tempCoord = new double[4];
        int index = random.nextInt(numberOfVertex - 2) + 2;
        int nextIndex = 0;
        if(index % 2 == 0)
            nextIndex = index - 2;
        else
            nextIndex = index - 1;
        switch (selectedButtonPlane.getText()){
            case "XY" :
                coordOne = (figure.matrix[index].x + figure.matrix[nextIndex].x) / 2;
                coordTwo = (figure.matrix[index].y + figure.matrix[nextIndex].y) / 2;
                tempCoord[0] = figure.matrix[index].x;
                tempCoord[1] = figure.matrix[index].y;
                tempCoord[2] = figure.matrix[nextIndex].x;
                tempCoord[3] = figure.matrix[nextIndex].y;
                break;
            case "YZ" :
                coordOne = (figure.matrix[index].z + figure.matrix[nextIndex].z) / 2;
                coordTwo = (figure.matrix[index].y + figure.matrix[nextIndex].y) / 2;
                tempCoord[0] = figure.matrix[index].z;
                tempCoord[1] = figure.matrix[index].y;
                tempCoord[2] = figure.matrix[nextIndex].z;
                tempCoord[3] = figure.matrix[nextIndex].y;
                break;
            case "ZX":
                coordOne = (figure.matrix[index].x + figure.matrix[nextIndex].x) / 2;
                coordTwo = (figure.matrix[index].z + figure.matrix[nextIndex].z) / 2;
                tempCoord[0] = figure.matrix[index].x;
                tempCoord[1] = figure.matrix[index].z;
                tempCoord[2] = figure.matrix[nextIndex].x;
                tempCoord[3] = figure.matrix[nextIndex].z;
                break;
          /*  default:
                coordOne = (figure.matrix[index].x + figure.matrix[nextIndex].x) / 2;
                coordTwo = (figure.matrix[index].y + figure.matrix[nextIndex].y) / 2;
                tempCoord[0] = figure.matrix[index].x;
                tempCoord[1] = figure.matrix[index].y;
                tempCoord[2] = figure.matrix[nextIndex].x;
                tempCoord[3] = figure.matrix[nextIndex].y;*/
        }

        coordOne += random.nextInt(10) + 5;
        double[] newCoordinates;
        newCoordinates = convert(tempCoord);
        Line line = new Line(newCoordinates[0], newCoordinates[1], newCoordinates[2], newCoordinates[3]);
        line.setStroke(Color.WHITE);
        line.setStrokeWidth(5);
        pane.getChildren().add(line);

        newCoordinates = convert(new double[]{tempCoord[0], tempCoord[1], coordOne, coordTwo});
        countChildren = pane.getChildren().size();

        pane.getChildren().add(new Line(newCoordinates[0], newCoordinates[1], newCoordinates[2], newCoordinates[3]));
        newCoordinates = convert(new double[]{coordOne, coordTwo, tempCoord[2], tempCoord[3]});
        pane.getChildren().add(new Line(newCoordinates[0], newCoordinates[1], newCoordinates[2], newCoordinates[3]));




        timer.play();







    }

    private void deleteEdge(){
      //  pane.getChildren().remove(countChildren);
       // pane.getChildren().remove(countChildren);
        drawForToggle(projectionMatrix, selectButtonPlane.getText());
        System.out.println("Remove");
    }

}