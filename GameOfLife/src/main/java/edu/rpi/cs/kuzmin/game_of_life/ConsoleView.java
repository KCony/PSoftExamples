package edu.rpi.cs.kuzmin.game_of_life;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ConsoleView implements Observer {
   public void update(Observable o, Object arg) {
      GameModel model = (GameModel)o;

      for(int idx1 = 0; idx1 < model.getColCount(); ++idx1) {
         for(int idx2 = 0; idx2 < model.getRowCount(); ++idx2) {
            if (model.getCell(idx1, idx2) == 0) {
               System.out.print(".");
            } else {
               System.out.print("*");
            }
         }
         System.out.println();
      }
      System.out.println();
   }
}
