package edu.rpi.cs.kuzmin.game_of_life;

import com.squareup.gifencoder.FloydSteinbergDitherer;
import com.squareup.gifencoder.GifEncoder;
import com.squareup.gifencoder.ImageOptions;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

@SuppressWarnings("deprecation")
public class AnimatedGifView implements Observer {
	public void update(Observable o, Object arg) {
		GameModel model = (GameModel) o;
		createGenerationGif(model);
		createAnimatedGif(model);
	}

	private static final int CELL_WIDTH = 100, CELL_HEIGHT = 100, GRIDLINE_WIDTH = 2;
	private int getImageWidth(GameModel model) {
		return CELL_WIDTH * model.getColCount() + GRIDLINE_WIDTH * (model.getColCount() + 1);
	}
	
	private int getImageHeight(GameModel model) {
		return CELL_HEIGHT * model.getRowCount() + GRIDLINE_WIDTH * (model.getRowCount() + 1);
	}

	private void createGenerationGif(GameModel model) {
		int imageWidth = getImageWidth(model);
		int imageHeight = getImageHeight(model);
		BufferedImage bi = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics2 = bi.createGraphics();
		
		graphics2.setPaint(Color.white);
		graphics2.fillRect(0, 0, imageWidth, imageHeight);
		graphics2.setPaint(Color.gray);
		assert GRIDLINE_WIDTH % 2 == 0;
		graphics2.setStroke(new BasicStroke(GRIDLINE_WIDTH));
		for(int idx = 0; idx <= model.getColCount(); ++idx) {
			graphics2.drawLine(idx * (CELL_WIDTH + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2, 0,
					idx * (CELL_WIDTH + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2, imageHeight);
		}
		for(int idx = 0; idx <= model.getRowCount(); ++idx) {
			graphics2.drawLine(0, idx * (CELL_HEIGHT + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2, 
					imageWidth, idx * (CELL_HEIGHT + GRIDLINE_WIDTH) + GRIDLINE_WIDTH / 2);
		}
		graphics2.setPaint(Color.green);
	    for(int idx1 = 0; idx1 < model.getColCount(); ++idx1) {
	    	for(int idx2 = 0; idx2 < model.getRowCount(); ++idx2) {
	    		if (model.getCell(idx1, idx2) != 0) {
	    			graphics2.fillRect(idx1 * CELL_WIDTH + (idx1 + 1) * GRIDLINE_WIDTH,
	    					idx2 * CELL_HEIGHT + (idx2 + 1) * GRIDLINE_WIDTH, CELL_WIDTH, CELL_HEIGHT);
	    		}
	    	}
	    }

	    try {
	    	ImageIO.write(bi, "PNG", new File("data/" + Integer.toString(model.getTick() - 1) + ".png"));
		}
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createAnimatedGif(GameModel model) {
		File image;
		int imageWidth = getImageWidth(model);
		int imageHeight = getImageHeight(model);
		try (FileOutputStream outputStream = new FileOutputStream("data/Game of Life animation.gif")) {
			ImageOptions options = new ImageOptions();
			options.setDelay(500, TimeUnit.MILLISECONDS);
			options.setDitherer(FloydSteinbergDitherer.INSTANCE);
			GifEncoder encoder = new GifEncoder(outputStream, imageWidth, imageHeight, 0);
			for (int idx = 0; idx < model.getTick(); idx++) {
				image = new File("data/" + Integer.toString(idx) + ".png");
				encoder.addImage(this.convertImageToArray(image), options);
			}
			encoder.finishEncoding();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int[][] convertImageToArray(File file) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(file);
		int[][] rgbArray = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];
		for (int i = 0; i < bufferedImage.getHeight(); ++i) {
			for (int j = 0; j < bufferedImage.getWidth(); ++j) {
				rgbArray[i][j] = bufferedImage.getRGB(j, i);
			}
		}
		return rgbArray;
	}
}
