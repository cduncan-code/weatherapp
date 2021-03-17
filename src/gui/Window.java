package gui;

import java.io.IOException;

import forecast.WeatherFetch;
import forecast.WeatherForecast;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import obj.Location;
import obj.Response;
public class Window extends Application{
	Response res;
	final String DEGREE = "\u00B0";

	public void start(Stage primaryStage) throws Exception {
		Location entry = new Location();
		WeatherFetch WF = new WeatherFetch(entry);
		Pane canvas = new Pane();
		canvas.setStyle("-fx-background-color: blue;");
	    canvas.setPrefSize(100,100);
		TextField tf = new TextField("Enter zip code");
		Button subB = new Button("Check weather");
		

		Parent content = canvas;
	    canvas.getChildren().addAll(tf,subB);
	    tf.relocate(75, 25);
	    subB.relocate(245, 24);
	    subB.setOnAction(e -> {
	         //Retrieving data
	    	
	         String zipCode = tf.getText();
	         entry.setZipCode(zipCode);
	         try {
				res = WF.fetch();	
				//WeatherForecast.Forecast(res);//This will make the results pretty and have it written as .toString() which needs to be formatted too.

				System.out.println("Currently feels like: "+ res.getMain().getFeelsLike()+DEGREE+"F");//for debug rn
				System.out.println("Currently feels like: "+ res.getWeather().get(0).getId());
				//TODO Display results to window, not sysout
				
				
				
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
	            });
	    
	    
	    // create scene containing the content
		Scene scene = new Scene(content, 400, 75);
		Stage window = new Stage();
		window.setTitle("Check the Weather");
		window.setScene(scene);
		// make window visible
		window.show();
	}
 
public static void main(String []args) {
launch(args);

}

}
