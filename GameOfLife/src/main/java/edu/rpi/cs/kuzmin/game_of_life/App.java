package edu.rpi.cs.kuzmin.game_of_life;

import java.util.stream.IntStream;
import java.awt.BasicStroke;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
		final int TICKS = 10;

        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        this.model = new GameModel(grid);
        int imageWidth = getImageWidth(this.model);
		int imageHeight = getImageHeight(this.model);
        
        stage.setTitle("Game of Life");
        
        final double rem = new Text("").getLayoutBounds().getHeight();

        GridPane pane = new GridPane();
        pane.setHgap(0.8 * rem);
        pane.setVgap(0.8 * rem);
        pane.setPadding(new Insets(0.8 * rem));
        
        Group root = new Group();
        Canvas canvas = new Canvas(imageWidth, imageHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawGrid(imageWidth, imageHeight, gc);
        
        // Draw on the canvas using the GraphicsContext
        root.getChildren().add(canvas);
        Button btnNext = new Button("Next");
        btnNext.setOnAction(event ->
        {
        	 model.nextGen();
        	 gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        	 drawGrid(imageWidth, imageHeight, gc);
        });
        root.getChildren().add(btnNext);
        pane.add(root, 0, 0);
        pane.add(btnNext,  0,  1);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
	
	private int getImageWidth(GameModel model) {
		return CELL_WIDTH * model.getColCount() + GRIDLINE_WIDTH * (model.getColCount() + 1);
	}
	
	private int getImageHeight(GameModel model) {
		return CELL_HEIGHT * model.getRowCount() + GRIDLINE_WIDTH * (model.getRowCount() + 1);
	}
	/**
	 * @param imageWidth
	 * @param imageHeight
	 * @param gc
	 */
	private void drawGrid(int imageWidth, int imageHeight, GraphicsContext gc) {
		gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, imageWidth, imageHeight);
        
        gc.setFill(Color.GRAY);
		assert GRIDLINE_WIDTH % 2 == 0;
		gc.setLineWidth(GRIDLINE_WIDTH);
		for(int idx = 0; idx <= model.getColCount(); ++idx) {
			gc.strokeLine(idx * (CELL_WIDTH + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2, 0,
					idx * (CELL_WIDTH + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2, imageHeight);
		}
		for(int idx = 0; idx <= model.getRowCount(); ++idx) {
			gc.strokeLine(0, idx * (CELL_HEIGHT + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2, 
					imageWidth, idx * (CELL_HEIGHT + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2);
		}
		gc.setFill(Color.GREEN);
	    for(int idx1 = 0; idx1 < model.getColCount(); ++idx1) {
	    	for(int idx2 = 0; idx2 < model.getRowCount(); ++idx2) {
	    		if (this.model.getCell(idx1, idx2) != 0) {
	    			gc.fillRect(idx1 * CELL_WIDTH + (idx1 + 1) * GRIDLINE_WIDTH,
	    					idx2 * CELL_HEIGHT + (idx2 + 1) * GRIDLINE_WIDTH, CELL_WIDTH, CELL_HEIGHT);
	    		}
	    	}
	    }
	}
	
	private static final int CELL_WIDTH = 50, CELL_HEIGHT = 50, GRIDLINE_WIDTH = 2;
	private GameModel model;
}