package sample;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



public class Draw {

    private Stage primaryStage;

    public void drawPicture(){

        DrawFigure drawFigure = new DrawFigure();
        AnchorPane root = drawFigure.getPane();
        primaryStage = new Stage();
        primaryStage.setTitle("Компьютерная графика");
        Scene scene = new Scene(root, 1300, 700);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            drawFigure.onKeyEvent(event);
        });
        scene.setOnScroll(event -> drawFigure.scale(event));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
