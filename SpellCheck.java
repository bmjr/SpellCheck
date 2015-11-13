import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class SpellCheck {
	
	public static void main(String[] args){

		BufferedReader inputFile = null;
	    BufferedReader dictRead = null;
	    HashSet<String> dictionary = new HashSet<String>();
	    int exitCode = 0;
		
	    //Try statement to catch I/O errors with dictionary retrieval
	    try {
	    	if (args.length == 1) {
	    		dictRead = new BufferedReader(new FileReader("/usr/share/dict/words"));
	    	}
	    	else if(args.length ==2){
	    		dictRead = new BufferedReader(new FileReader(args[1]));
			}
	    	else{
	    		System.out.println("Usage: java SpellCheck <filename> <dictionary>");
		        System.exit(2);
	    	}
	    	try{
	    		Dictionary dict = new Dictionary(dictRead);
	    	    dict.extractDict();
	    	    dictionary = dict.getDict();
	    	}
	    	finally{
	    		dictRead.close();
	    	}
	    }
	    catch (IOException e){
	    	System.out.println("A problem has occured when accessing the dictionary file, please ensure dictionary exists");
	        System.exit(2);
	    }
	    
		
	     //Try statement to catch I/O errors with textfile retrieval
	     try {
		    	inputFile = new BufferedReader(new FileReader(args[0]));
		    	try{
		    		Checker spCheck = new Checker(inputFile, dictionary);
		    		spCheck.checkFile(); 
		    		exitCode = spCheck.getExitCode();
			    	}
			    finally{
			    	inputFile.close();
			    }  
		 }
		 catch (IOException e) {
		 System.out.println("The file " + args + " could not be opened");
		 System.exit(2);
		 }
	     finally{
	    	// Exit code is 1 if spelling error, 0 if no spell error
			System.exit(exitCode);
		 }
	}

} 