/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.transition.transitionDemo3;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 */
public class Transitions{
                              // Static Final Values

	// ***********************************************************************************************************************
                              // Static Variables

	// ***********************************************************************************************************************
                              // Final Fields

	// ***********************************************************************************************************************
                              // Fields

	// ***********************************************************************************************************************
                              // Constructors

	// ***********************************************************************************************************************
                              // Methods
   
   public static FadeTransition fade(Duration duration, Shape shape) {
      
      FadeTransition fd;
      
      fd = new FadeTransition(duration, shape);
      fd.setFromValue(1.);
      fd.setToValue(0.2);
      fd.setCycleCount(Timeline.INDEFINITE);
      fd.setAutoReverse(true);
      
      return fd;
      
   } // End of fade(Shape shape)

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        //	*** Setter Methods ***

		// ------------------------------------------------------------------------------------------------
                        //	*** getter Methods ***

} // End of class Transitions
