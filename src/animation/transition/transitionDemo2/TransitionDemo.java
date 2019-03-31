/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.transition.transitionDemo2;

import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 */
public class TransitionDemo
   extends Transition {
                              // Static Final Values

	// ***********************************************************************************************************************
                              // Static Variables

	// ***********************************************************************************************************************
                              // Final Fields

	// ***********************************************************************************************************************
                              // Fields
   
   private Shape shape;

	// ***********************************************************************************************************************
                              // Constructors
   
   public TransitionDemo(Shape shape) {
      
      this(shape, Duration.seconds(7));
      
   } // End of TransitionDemo(Shape shape)
   
   public TransitionDemo(Shape shape, Duration duration) {
      
      this.shape = shape;
      this.setCycleDuration(duration);
      
   } // End of TransitionDemo(Shape shape, Duration duration)

	// ***********************************************************************************************************************
                              // Methods
   
   @Override
   protected void interpolate(double frac) {
      
      int frame;
      
      frame = (int) (frac * 6) + 1; System.out.println("frac:\t" + frac + "\tframe:\t" + frame);
      shape.setFill(this.getRainbowColor(frame));
      
   } // End of interpolate(double frac)
   
   private Color getRainbowColor(int frame) {
      
      if(frame >= 1 && frame <= 7) {
         
         switch(frame) {
            case 1:
               return Color.RED;
            case 2:
               return Color.ORANGE;
            case 3:
               return Color.YELLOW;
            case 4:
               return Color.GREEN;
            case 5:
               return Color.BLUE;
            case 6:
               return Color.BLUEVIOLET;
            default:
               return Color.VIOLET;
      } // End of switch(frame)
         
      } // End of if(frame >= 1 && frame <= 7)
      
      System.out.println("Your number of frame is wrong." +
         " It should be between 1 and 7" +
         " but it is " + frame);
      return null;
      
   } // End of getRainbowColor(int frame)

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        //	*** Setter Methods ***

		// ------------------------------------------------------------------------------------------------
                        //	*** getter Methods ***
   
} // End of class TransitionDemo
