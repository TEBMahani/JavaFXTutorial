/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.transition.transitionDemo3;

import java.util.List;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
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
      
   } // End of fade(Duration duration, Shape shape)
   
   public static ParallelTransition paralle(List<Animation> animations) {
      
      ParallelTransition pt;
      
      pt = new ParallelTransition();
      pt.setCycleCount(1);
      
      pt.getChildren().addAll(animations);
      
      return pt;
      
   }
   
   private static Path leftPath() {
      
      Path path;
      
      path = new Path();
      path.getElements().add(new MoveTo(0, 0));
      path.getElements().add(new QuadCurveTo(200, 70, 80, 187));
      
      return path;
      
   } // End of leftPath()
   
   private static Path rightPath() {
      
      Path path;
      
      path = new Path();
      path.getElements().add(new MoveTo(200, 0));
      path.getElements().add(new QuadCurveTo(120, 50, 85, 155));
      
      return path;
      
   } // End of rightPath()
   
   public static PathTransition path(Duration duration, Shape shape, String side) {
      
      Path path;
      PathTransition pt;
      
      if(side.equalsIgnoreCase("Left")) {
         path = Transitions.leftPath();
      } // End of if(side.equalsIgnoreCase("Left"))
      else {
         path = Transitions.rightPath();
      } // End of else
          
      pt = new PathTransition();
      pt.setCycleCount(1);
      pt.setDuration(duration);
      pt.setNode(shape);
      pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
      pt.setPath(path);
     
      return pt;
      
   } // End of path(Duration duration, Shape shape, String side)

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        //	*** Setter Methods ***

		// ------------------------------------------------------------------------------------------------
                        //	*** getter Methods ***

} // End of class Transitions
