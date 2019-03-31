/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.transition.transitionDemo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 */
public class Main
   extends Application {
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
   
   public static void main(String[] args) {
      launch(args);
   } // End of main(String[] args)
   
   @Override
   public void start(Stage stage) {
      
      Circle core;
      Ellipse
         petal1,
         petal2,
         petal3,
         petal4,
         petal5,
         petal6,
         petal7,
         petal8;
      Path 
         leafLeft,
         leafRight;
      
      Pane pane;
      Scene scene;
      
      core = this.core();
      Transitions.fade(Duration.seconds(5), core).play();
      
      petal1 = this.petal(85, 120, 135);
      petal2 = this.petal(75, 100, 180);
      petal3 = this.petal(80, 80, 45);
      petal4 = this.petal(100, 70, 90);
      petal5 = this.petal(120, 80, 135);
      petal6 = this.petal(125, 100, 180);
      petal7 = this.petal(115, 120, 45);
      petal8 = this.petal(100, 130, 90);
      
      leafLeft = this.leaf();
      Transitions.path(Duration.seconds(10), leafLeft, "Left").play();
      leafRight = this.leaf();
      Transitions.path(Duration.seconds(10), leafRight, "Right").play();
      
      pane = new Pane();
      pane.setStyle("-fx-background-color: grey");
      pane.getChildren().addAll(
         petal1, petal2, petal3, petal4, petal5, petal6, petal7, petal8,
         leafRight, core , leafLeft);
      
      scene = new Scene(pane, 200, 200);
      stage.setScene(scene);
      stage.show();
      
   } // End of start(Stage stage)
   
   private Circle core() {
      
      Circle core;
      
      core = new Circle(100, 100, 15);
      core.setFill(Color.YELLOW);
      core.setStroke(Color.GOLD);
      
      return core;
      
   } // End of core(Circle core)
   
   private Path leaf() {
      
      Path path;
      
      path = new Path();
      path.setFill(Color.GREENYELLOW);
      path.setStroke(null);
      
      path.getElements().add(new MoveTo(0, 0));
      path.getElements().add(new QuadCurveTo(20, 20, 0, 40));
      path.getElements().add(new QuadCurveTo(-10, 15, -5, 0));
      
      return path;
      
   } // End of leaf(double rotate)
   
   private Ellipse petal(
      double centerX,
      double centerY,
      double rotate) {
      
      Ellipse petal;
      
      petal = new Ellipse(centerX, centerY, 20, 15);
      petal.setFill(Color.PURPLE);
      petal.setStroke(Color.PLUM);
      petal.setRotate(rotate);
      
      return petal;
      
   } // End of petal(double centerX, double centerY)

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        //	*** Setter Methods ***

		// ------------------------------------------------------------------------------------------------
                        //	*** getter Methods ***
   
} // End of class Main
