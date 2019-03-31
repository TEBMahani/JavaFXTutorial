/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.transition.flowerTransition;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
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
   
   private SequentialTransition leafRightSequentialTransition(Path leafRight) {
      
      PathTransition leafRightPathTransition;
      RotateTransition leafRightRotateTransition;
      SequentialTransition leafRightSequentialTransition;
      TranslateTransition leafRightTranslateTransition;
      
      leafRightPathTransition = Transitions.path(Duration.seconds(10), leafRight, "Right");
      leafRightRotateTransition = Transitions.rotate(Duration.seconds(5), leafRight, 225);
      leafRightTranslateTransition = Transitions.translate(Duration.seconds(2), leafRight);
      
      leafRightSequentialTransition = 
         Transitions.sequential(
            new Animation[] {
               leafRightPathTransition,
               leafRightRotateTransition,
               leafRightTranslateTransition});
      
      return leafRightSequentialTransition;
      
   } // End of leafRightSequentialTransition(Path leafRight)
   
   public static void main(String[] args) {
      launch(args);
   } // End of main(String[] args)
   
   private Ellipse petal(
      double centerX,
      double centerY,
      double rotate) {
      
      Ellipse petal;
      
      petal = new Ellipse(centerX, centerY, 20, 15); 
      petal.setFill(null);
      petal.setRotate(rotate);
      petal.setStroke(null);
      
      return petal;
      
   } // End of petal(double centerX, double centerY, double rotate)
   
   private Ellipse[] petals() {
      
      Ellipse[] petals;
      
      petals = new Ellipse[8];
      
      petals[0] = this.petal(85, 120, 135);
      petals[1] = this.petal(75, 100, 180);
      petals[2] = this.petal(80, 80, 45);
      petals[3] = this.petal(100, 70, 90);
      petals[4] = this.petal(120, 80, 135);
      petals[5] = this.petal(125, 100, 180);
      petals[6] = this.petal(115, 120, 45);
      petals[7] = this.petal(100, 130, 90);
      
      return petals;
      
   } // End of petalsFillTransition(Ellipse[] petals)
   
   private FillTransition[] petalsFillTransition(Ellipse[] petals) {
      
      int lengthOfPetals;
      
      FillTransition[] petalsFillTransition;
      
      lengthOfPetals = petals.length;
      petalsFillTransition = new FillTransition[lengthOfPetals];
      
      petalsFillTransition[0] = Transitions.fill(Duration.seconds(5), petals[7]);
      for (int i = 1; i < lengthOfPetals; i++) {
         petalsFillTransition[i] = Transitions.fill(Duration.seconds(5), petals[i - 1]);
      } // End of for (int i = 0; i < lengthOfPetals; i++)
      
      return petalsFillTransition;
      
   } // End of petalsFillTransition(Ellipse[] petals)
   
   private StrokeTransition[] petalsStrokeTransition(Ellipse[] petals) {
      
      int lengthOfPetals;
      
      StrokeTransition[] petalsStrokeTransition;
      
      lengthOfPetals = petals.length;
      petalsStrokeTransition = new StrokeTransition[lengthOfPetals];
      
      for (int i = 0; i < lengthOfPetals; i++) {
         petalsStrokeTransition[i] =
            Transitions.stroke(
               Duration.seconds( (int) (Math.random() * 5) + 1),
               petals[i]);
      } // End of for (int i = 0; i < lengthOfPetals; i++)
      
      return petalsStrokeTransition;
      
   } // End of petalsStrokeTransition(Ellipse[] petals)
   
   private Line stalk() {
      
      Line stalk;
      
      stalk = new Line(100, 200, 100, 200);
      stalk.setStroke(Color.BROWN);
      
      return stalk;
      
   } // End of stalk()
   
   @Override
   public void start(Stage stage) {
      
      Circle core;
      Line stalk;
      Path 
         leafLeft,
         leafRight;
      
      FadeTransition coreFadeTransition;
      ParallelTransition 
         leavesParallelTransition,
         petalsStrokeParallelTransition,
         totalParallelTransition;
      PathTransition
         leafLeftPathTransition;
      ScaleTransition stalkScaleTransition;
      SequentialTransition 
         leafRightSequentialTransition,
         sequentialTransition,
         petalsSequaentialTransition;
      
      Pane pane;
      Scene scene;
      
      stalk = this.stalk();
      stalkScaleTransition = Transitions.scale(Duration.seconds(5), stalk);
      
      core = this.core();
      coreFadeTransition = Transitions.fade(Duration.seconds(5), core);
      
      Ellipse[] petals = this.petals();
      FillTransition[] petalsFillTransition = this.petalsFillTransition(petals);
      StrokeTransition[] petalsStrokeTransition = this.petalsStrokeTransition(petals);
      
      leafLeft = this.leaf();
      leafLeftPathTransition = Transitions.path(Duration.seconds(10), leafLeft, "Left");
      leafRight = this.leaf(); 
      leafRightSequentialTransition = this.leafRightSequentialTransition(leafRight);
      
      leavesParallelTransition =
         Transitions.paralle(
            new Animation[] {
               leafLeftPathTransition,
               leafRightSequentialTransition});
      
      petalsSequaentialTransition = Transitions.sequential(petalsFillTransition);      
      petalsStrokeParallelTransition = Transitions.paralle(petalsStrokeTransition);
      
      sequentialTransition =
         Transitions.sequential(
            new Animation[] {
               stalkScaleTransition,
               leavesParallelTransition,
               petalsSequaentialTransition,
               petalsStrokeParallelTransition});
      
      totalParallelTransition =
         Transitions.paralle(
            new Animation[] {
               coreFadeTransition,
               sequentialTransition});
      
      totalParallelTransition.play();
      
      pane = new Pane();
      pane.setStyle("-fx-background-color: grey");
      pane.getChildren().addAll(stalk);
      pane.getChildren().addAll(petals);
      pane.getChildren().addAll(
         leafRight, leafLeft,
         core);
      
      scene = new Scene(pane, 200, 200);
      stage.setScene(scene);
      stage.show();
      
   } // End of start(Stage stage)

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        //	*** Setter Methods ***

		// ------------------------------------------------------------------------------------------------
                        //	*** getter Methods ***
   
} // End of class Main
