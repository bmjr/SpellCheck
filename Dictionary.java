import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;


public class Dictionary {
	
	private BufferedReader dict;
	private HashSet<String> setOfWords;
	
	/*
	 * Creates an object of dictionary
	 * @param dict. The dictionary file to extract words from
	 */
	public Dictionary(BufferedReader dict){
		this.dict = dict;
		setOfWords = new HashSet<String>();
	}
	
	/*
	 * Method to extract the correctly spelt words from dictionary and input into
	 * a hash set
	 */
	public void extractDict() throws IOException{
		String word;
		while ((word = dict.readLine()) != null) {
			setOfWords.add(word.toLowerCase());
	     }
	}
	
	/*
	 * Method to get the HashSet of dictionary
	 */
	public HashSet<String> getDict(){
		return setOfWords;
	}
}