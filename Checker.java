import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Checker{

	BufferedReader file;
	HashSet<String> dictionary;
	int exitCode = 0;
	
	/*
	 * Creates an object of Checker to spell check a file
	 * @param file. The text file that needs to be checked
	 * @param dictionary. The dictionary to check the text file against.
	 */
	public Checker(BufferedReader file, HashSet<String> dictionary){
		this.file = file;
		this.dictionary = dictionary;
	    }
	
	/*
	 * Method to check for spelling mistakes in a file
	 */
	public void checkFile() throws IOException{
		String currentLine;
		int lineCount = 1;
		ArrayList<String> mispelledWords = new ArrayList<String>();
		while ((currentLine = file.readLine()) != null) {
			//ArrayList<String> mispelledWords = new ArrayList<String>();
			mispelledWords.clear();
			
	        mispelledWords = checkWords(getWords(currentLine));
	        
	          if (mispelledWords.size() > 0){
	        	  if (exitCode !=1) {exitCode = 1;};
	        	  System.out.print(lineCount + " ");
	        	  System.out.print(currentLine);
	        	  System.out.println("");
	        	  for (String word : mispelledWords){
	        		  System.out.print(word + " ");
	        	  }
	        	  System.out.println(System.lineSeparator());
	          }
	          lineCount++;
	     }
	}
	
	/*
	 * Method to extract words from a given line of the text file disregarding anything
	 * but letters and apostrophe's
	 * @param line. The line of text to split into words
	 * @return words. A String array of words from the line
	 */
	private String[] getWords(String line){
		line = line.toLowerCase();
		String regex = "[^a-z']+";
		String[] words = line.split(regex);
		return words;
	}
	
	/*
	 * Method to check an individual set of words from a line against a dictionary
	 * @param words. A String array of words from the current line being inspected
	 * @return incorrectWords. The Array List of words that are spelt incorrectly
	 */
	private ArrayList<String> checkWords(String[] words){
		ArrayList<String> incorrectWords = new ArrayList<String>();
		for (String word : words) {
			if (!(dictionary.contains(word))){
				incorrectWords.add(word);
			}
		}
		return incorrectWords;
	}
	
	/*
	 * Method to make sure program exits correctly
	 * @return exitCode. The exit code to exit the program by
	 */
	public int getExitCode(){
		return exitCode;
	}
	
}