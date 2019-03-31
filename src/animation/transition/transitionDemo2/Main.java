/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.transition.transitionDemo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
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
      
      String content;
      
      Circle circle;
      Text
         text1,
         text2;
      
      TransitionDemo
         td1,
         td2;
      
      Pane pane;
      Scene scene;
      
      content = "Start";
      text1 = new Text(75, 20, content);
      td1 = new TransitionDemo(text1);
      td1.play();
      
      circle = new Circle(100, 100, 50);
      td1 = new TransitionDemo(circle, Duration.seconds(14));
      td1.play();
      
      content = "The End";
      text2 = new Text(75, 180, content);
      td2 = new TransitionDemo(text2, Duration.seconds(21));
      td2.play();
      
      pane = new Pane();
      pane.setStyle("-fx-background-color: grey;");      
      pane.getChildren().addAll(text1, circle, text2);
      
      scene = new Scene(pane, 200, 200);
      stage.setScene(scene);
      stage.show();
      
   } // End of start(Stage primaryStage)

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        //	*** Setter Methods ***

		// ------------------------------------------------------------------------------------------------
                        //	*** getter Methods ***
   
} // End of class Main
