package agh.ics.oop.gui;

import agh.ics.oop.*;



import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
public class App extends Application {
    private final GridPane grid = new GridPane();
    private IWorldMap map;

    @Override
    public void start(Stage primaryStage) {
        try {
            TextField textField = new TextField();
            Button startButton = getStartButton(textField);
            HBox hBox = new HBox(this.grid, textField, startButton);
            Scene scene = new Scene(hBox, 700, 700);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Button getStartButton(TextField textField){
        Button startButton = new Button("Start");

        startButton.setOnAction((action) -> {
            String text = textField.getText();
            MoveDirection[] directions = new OptionsParser().parse(text.split(" "));
            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3,4)};
            this.map = new GrassField(10);
            IEngine engine = new SimulationEngine(directions, this.map, positions, this);
            Thread engineThread = new Thread(engine::run);
            engineThread.start();
        });

        return startButton;
    }

    public void drawMap(IWorldMap map){
        int xMax = map.getMaxX() + 1;
        int yMax = map.getMaxY() + 1;

        int xMin = map.getMinX();
        int yMin = map.getMinY();

        int width = xMax - xMin + 1;
        int height = yMax - yMin + 1;


        for(int i = 0; i<width;i++)
        {
            ColumnConstraints columnConstraints = new ColumnConstraints(40);
            this.grid.getColumnConstraints().add(columnConstraints);
        }

        for(int i = 0; i<height;i++)
        {
            RowConstraints rowConstraints = new RowConstraints(40);
            this.grid.getRowConstraints().add(rowConstraints);
        }

        int currRow = yMax - 1;
        int currCol = xMin;

        int currPosX = currCol;
        int currPosY = currRow + 1;

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                String toDisplay = "";
                boolean elem = false;

                if (i == 0 && j == 0) {
                    toDisplay = "y\\x";
                } else if (i == 0) {
                    toDisplay = String.valueOf(currCol);
                    currCol++;
                } else if (j == 0) {
                    toDisplay = String.valueOf(currRow);
                    currRow--;
                } else {
                    Vector2d potObj = new Vector2d(currPosX, currPosY);
                    if (map.objectAt(potObj) != null) {
                        elem = true;
                        GuiElementBox obj = new GuiElementBox((IMapElement) map.objectAt(potObj));
                        Label label = new Label();
                        GridPane.setHalignment(label, HPos.CENTER);
                        this.grid.add(obj.vBox, j, i, 1, 1);
                    }
                    currPosX++;
                }

                if (!elem) {
                    Label newLabel = new Label(toDisplay);
                    GridPane.setConstraints(newLabel, j, i);
                    GridPane.setHalignment(newLabel, HPos.CENTER);
                    this.grid.add(newLabel, j, i, 1, 1);
                }
            }
            currPosY--;
            currPosX = xMin;
        }
    }

    public void renderMap(IWorldMap map){
        this.grid.setGridLinesVisible(false);
        this.grid.getColumnConstraints().clear();
        this.grid.getRowConstraints().clear();
        this.grid.getChildren().clear();
        this.grid.setGridLinesVisible(true);
        drawMap(map);
    }
}
