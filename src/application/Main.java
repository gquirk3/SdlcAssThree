package application;
	
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	Button button;
	TextArea textArea;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Text Analyzer - The Raven");
			button = new Button();
			button.setText("Calculate Word Count");
			
			button.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent event) {
			   
			    	String text = "";  // variable to store the poem
					
					Path fileName = Path.of("poem.txt");
					try {
						text = Files.readString(fileName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// cleaning the data to get an accurate word count by
					// removing punctuation and changing everything to lowercase 
					
					String[] textArray = text.toLowerCase().split("\\W+");  	

					// creating three collections 
					// 2 hashmaps - one to get frequency of each word - one to hold the sorted words
					// 1 list to do the sorting/ranking top to bottom
					
					ArrayList<Integer> list = new ArrayList<>();
				    Map<String, Integer> freqMap = new HashMap<>();
				    LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
				    
				    // loop to iterate through clean data 
				    // if word exists - ups the count by 1
				    // if word doesn't exist - adds word and sets count to 1
				    for (String s : textArray)
				    {	    	
				        if (freqMap.containsKey(s)) {
				            Integer count = freqMap.get(s);
				            freqMap.put(s, count + 1);
				        } else {
				            freqMap.put(s, 1);
				        }

				    }
				    // adds values to list
			        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			            list.add(entry.getValue());
			        }
			        // sorts list
			        Collections.sort(list, new Comparator<Integer>() {
			            public int compare(Integer str, Integer str1) {
			                return (str1).compareTo(str);
			            }
			        });
			        // uses list and keys from sorted data and
			        // adds to new hashtable
			        for (Integer str : list) {
			            for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			                if (entry.getValue().equals(str)) {
			                    sortedMap.put(entry.getKey(), str);
			                }
			            }
			        }
			        // iterates through sorted has table and outputs word and count
			        // from highest count to lowest - top 20
			        int count = 1;  // variable to count to 20
			        for (Map.Entry<String, Integer> e: sortedMap.entrySet())
			        {
			        	
			        	if (count < 21)
			        	{
			            textArea.appendText(count + ". " + e.getKey() + " " + e.getValue()+"\n");    	
			        	System.out.println(count + ". " + e.getKey() + " " + e.getValue());
			        	count += 1;
			        	}

			        }

			    }
			});
			
			
			textArea = new TextArea();
			textArea.setPrefHeight(700);
			FlowPane layout = new FlowPane();
			layout.getChildren().add(button);
			layout.getChildren().add(textArea);
			Scene scene = new Scene(layout,400,400);
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
