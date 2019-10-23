package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;


public class Main extends Application {
	
	public static void main(String[] args){
		Application.launch(Main.class, (java.lang.String[])null);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			SplitPane root = (SplitPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
