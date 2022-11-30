package agh.ics.oop.gui;

import java.util.Arrays;
import java.util.Timer;

import agh.ics.oop.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.util.Duration;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
            System.out.println(Arrays.toString(directions));
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            // Title
            primaryStage.setTitle("Simulation Engine");

            // GridPane declarations
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(5, 5, 5, 5));
            gridPane.setGridLinesVisible(true);

            int xMax = map.getMaxX() + 1;
            int yMax = map.getMaxY() + 1;

            int xMin = map.getMinX();
            int yMin = map.getMinY();

            int width = xMax - xMin + 1;
            int height = yMax - yMin + 1;

//            System.out.println("UpperRight: " + xMax + " " + yMax);
//            System.out.println("LowerLeft: " + xMin + " " + yMin);
//            System.out.println("Width: " + width);
//            System.out.println("Height: " + height);

            for(int i = 0; i<width;i++)
            {
                ColumnConstraints columnConstraints = new ColumnConstraints(50);
                columnConstraints.setPercentWidth(100.0 / width);
                gridPane.getColumnConstraints().add(columnConstraints);
            }

            for(int i = 0; i<height;i++)
            {
                RowConstraints rowConstraints = new RowConstraints(50);
                rowConstraints.setPercentHeight(100.0 / height);
                gridPane.getRowConstraints().add(rowConstraints);
            }

            int currRow = yMax - 1;
            int currCol = xMin;

            int currPosX = currCol;
            int currPosY = currRow + 1;

            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    String toDisplay = "";

                    if (i == 0 && j == 0){
                        toDisplay = "y/x";
                    } else if (i == 0) {
                        toDisplay = String.valueOf(currCol);
                        currCol++;
                    } else if (j == 0){
                        toDisplay = String.valueOf(currRow);
                        currRow--;
                    } else {
                        Vector2d obj = new Vector2d(currPosX, currPosY);
                        if (map.objectAt(obj) != null){
                            toDisplay = map.objectAt(obj).toString();
                        }
                        currPosX++;
                    }

                    Label newLabel = new Label(toDisplay);
                    GridPane.setConstraints(newLabel, j, i);
                    GridPane.setHalignment(newLabel, HPos.CENTER);
                    gridPane.add(newLabel, j, i);
                }
                currPosY--;
                currPosX = xMin;
            }

            Scene scene = new Scene(gridPane, 50 * width, 50 * height);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
