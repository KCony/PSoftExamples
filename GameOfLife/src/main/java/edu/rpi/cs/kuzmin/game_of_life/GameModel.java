package edu.rpi.cs.kuzmin.game_of_life;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class GameModel extends Observable {

   public GameModel(int[][] startingGrid) {
      assert startingGrid.length >= 1;
      assert startingGrid[0].length >= 1;

      this.tick = 0;
      this.rowCount = startingGrid.length;
      this.colCount = startingGrid[0].length;
      this.grid = new int[this.getRowCount()][this.getColCount()];
      this.future = new int[this.getRowCount()][this.getColCount()];

      for(int idx1 = 0; idx1 < startingGrid.length; ++idx1) {
         for(int idx2 = 0; idx2 < startingGrid[idx1].length; ++idx2) {
            this.grid[idx1][idx2] = startingGrid[idx1][idx2];
         }
      }
   }

   public void nextGen() {
      int[][] temp;

      for(int idx1 = 0; idx1 < this.getRowCount(); ++idx1) {
         for(int idx2 = 0; idx2 < this.getColCount(); ++idx2) {
            int aliveNeighbors = 0;

            for(int i = -1; i <= 1; ++i) {
               for(int j = -1; j <= 1; ++j) {
                  if (idx1 + i >= 0 && idx1 + i < this.getRowCount() && idx2 + j >= 0 && idx2 + j < this.getColCount()) {
                     aliveNeighbors += this.grid[idx1 + i][idx2 + j];
                  }
               }
            }

            aliveNeighbors -= this.grid[idx1][idx2];
            if (this.grid[idx1][idx2] == 1 && aliveNeighbors < 2) {
            	this.future[idx1][idx2] = 0;
            } else if (this.grid[idx1][idx2] == 1 && aliveNeighbors > 3) {
            	this.future[idx1][idx2] = 0;
            } else if (this.grid[idx1][idx2] == 0 && aliveNeighbors == 3) {
            	this.future[idx1][idx2] = 1;
            } else {
            	this.future[idx1][idx2] = this.grid[idx1][idx2];
            }
         }
      }
      temp = this.grid;
      this.grid = this.future;
      this.future = temp;
      this.tick++;
      this.setChanged();
      this.notifyObservers();
   }

   public void notifyObservers() {
      Iterator<Observer> observerIterator = this.observers.iterator();

      while(observerIterator.hasNext()) {
         Observer observer = (Observer)observerIterator.next();
         observer.update(this, (Object)null);
      }
      this.clearChanged();
   }

   public void addObserver(Observer observer) {
      this.observers.add(observer);
   }

   public int getRowCount() {
      return this.rowCount;
   }
   
   public int getTick() {
	      return this.tick;
	   }

   public int getColCount() {
      return this.colCount;
   }

   public int getCell(int row, int col) {
      return this.grid[row][col];
   }

   private int[][] grid, future;
   private int rowCount;
   private int colCount;
   private int tick;
   private List<Observer> observers = new ArrayList<Observer>();
}
