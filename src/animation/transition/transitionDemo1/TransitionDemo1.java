/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.transition.transitionDemo1;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author alpha
 */
public class TransitionDemo1
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
      
      final String content;
      final Text text;
      
      final Animation animation;
      
      Pane pane;
      Scene scene;
      
      content = "Lorem ipsum";
      text = new Text(10, 20, "");
      
      animation = new Transition() {
         
         {
            this.setCycleDuration(Duration.millis(3000));
         }
         
         @Override
         protected void interpolate(double frac) {
            
            final int length;
            final int n;
            
            length = content.length();
            n = Math.round(length * (float) frac); System.out.println("frac:\t" + frac + "\tlength of substring:\t" + n);
            text.setText(content.substring(0, n));
            
         } // End of interpolate(double frac)
      };
      
      animation.play();
      
      pane = new Pane();
      pane.getChildren().add(text);
      
      scene = new Scene(pane, 200, 200);
      stage.setScene(scene);      
      stage.show();
      
   } // End of start(Stage primaryStage)

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        //	*** Setter Methods ***

		// ------------------------------------------------------------------------------------------------
                        //	*** getter Methods ***
   
} // End of TransitionDemo1
