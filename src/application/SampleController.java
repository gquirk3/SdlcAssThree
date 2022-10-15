package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SampleController {
	
	public void buttonClicked() throws IOException 
	{
		System.out.println("is this working?");
		String text = "";  // variable to store the poem
		
		Path fileName = Path.of("poem.txt");
		text = Files.readString(fileName);
		
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
        	System.out.println(count + ". " + e.getKey() + " " + e.getValue());
        	count += 1;
        	}

        }

	}
}
