package one;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Set;

public class TextAnalyzer4 {
//implements Comparable<>{
	
    public static void main(String[] args) throws Exception {
    	
        FileReader file = new FileReader("C:\\Users\\bn0r3\\Documents\\Text Analyzer\\TheRaven.txt");
        BufferedReader br = new BufferedReader(file);
        
        //ArrayList<String>word =new ArrayList<String>();
        
        String line;
        Map<String, Integer> value = new HashMap<>();
        while ((line = br.readLine()) != null) {
            
            String[] string = line.toLowerCase().split("([,.\\s!?'â€;”œ ™]+)");
            for (String text : string) {
                text = text.trim();
                if (text.length() > 0) {
                    if (value.containsKey(text)) {
                        value.put(text, value.get(text) + 1);
                    } else {
                        value.put(text, 1);
                    }
                } 
            }
                
				Set<Map.Entry<String, Integer>>set = value.entrySet();
				
                List<Map.Entry<String, Integer>> arrayList = new ArrayList<Map.Entry<String, Integer>>(set);
                
                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>(){
                	
                	public int compare(Map.Entry<String, Integer> first, Map.Entry<String, Integer> second) {
                		return (second.getValue()).compareTo(first.getValue());
                	}
                });
                for (Map.Entry<String, Integer> list:arrayList) {
                	//arraylist.trimToSize();
                	System.out.println(list.getKey()+" = "+list.getValue());
                	
                }
                
        }
        br.close();
        
    }
    
}