package application;
	
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Label labelOutput = new Label("1. the 57\r\n"
					+ "2. and 38\r\n"
					+ "3. i 32\r\n"
					+ "4. my 24\r\n"
					+ "5. of 22\r\n"
					+ "6. that 18\r\n"
					+ "7. this 16\r\n"
					+ "8. a 15\r\n"
					+ "9. door 14\r\n"
					+ "10. is 11\r\n"
					+ "11. raven 11\r\n"
					+ "12. nevermore 11\r\n"
					+ "13. chamber 11\r\n"
					+ "14. bird 10\r\n"
					+ "15. on 10\r\n"
					+ "16. me 9\r\n"
					+ "17. at 8\r\n"
					+ "18. by 8\r\n"
					+ "19. with 8\r\n"
					+ "20. or 8");
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,800,800);
			root.getChildren().add(labelOutput);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
