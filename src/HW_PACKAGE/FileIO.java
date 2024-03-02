package HW_PACKAGE;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 



public class FileIO {

	public FileIO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public IBag<Garbage> readTrashCan(){
		TrashCan<Garbage> garbages = new TrashCan<>();
		//I read from the text file line by line and split each line by commas
		//and defined 3 String variables then add each of them to trashCan as garbage objects
		//then return the trashCan object that i created
		try {
		      File myObj = new File("garbage.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] dataArray = data.trim().split("\\s*,\\s*");    
		        String garbageName = dataArray[0];                                                     //READ FROM GARBAGE.TXT
		        String garbageType = dataArray[1];
		        String amount = dataArray[2];  
		        int i=Integer.parseInt(amount);    
		        //here I create an object for each line of text file
		        Garbage garbage = new Garbage(garbageName, garbageType, amount);
		       
		        for(int a=0; a<=(i-1); a++ ) {
		        	garbages.add(garbage); 	
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return garbages;
		
	
	}
	//This method creates a new text every time I run the GarbageRecycling Application
	// the new text contains the updated text after separation.
	//method takes a bag parameter whose size is reduced after the separation,
	
	public boolean updateTrashCan(IBag<Garbage> myBag) {
		IBag<Garbage> tempCan= new TrashCan<Garbage>();
	      for (int i = 0; i<myBag.getItemCount();i++) {
	    	    if (!tempCan.contains(myBag.getItem(i))) {
	    	        tempCan.add(myBag.getItem(i));
	    	    }
	    	}
		
		File file = new File("updated_garbage.txt");
		 try {
		      // this clears the updated text every time i run it
		      file.createNewFile();

		      //created a writer object
		      FileWriter write = new FileWriter(file);

		      // I created a new string array to add my "updated_garbage.txt" file 
		                                                                                               //UPDATE A NEW UPDATED_GARBAGE.TXT
		      String[] linesToAdd = new String[tempCan.getItemCount()];
		     
		      
		      for (int i = 0; i<tempCan.getItemCount();i++) {
		    	  
		    		  linesToAdd[i] = (tempCan.getItem(i).toString()+","+tempCan.getItem(i).getType()+","+myBag.getFrequencyOf(tempCan.getItem(i)));
		    		  	  	   
		      }
		           
		          
		      for (String line : linesToAdd) {
		        write.write(line + "\n");
		      }

		      
		      write.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  
		return true;
}
	
	
	
	
	//this is an additional method that returns a different garbage text with the same objects inside of it 
	//I write this method because if I try to use the current trash can that I used for the separation that the displaying seems too confusing to look at
	// I could have done without this method, but the output seems much more ordered when I use. 
	public IBag<Garbage> display(){
		IBag<Garbage> garbages1 = new TrashCan<>();
		try {
		      File myObj = new File("garbage.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] dataArray = data.trim().split("\\s*,\\s*");    
		        String garbageName = dataArray[0];
		        String garbageType = dataArray[1];
		        String amount = dataArray[2];	   
		        Garbage garbage = new Garbage(garbageName, garbageType, amount);
		        garbages1.add(garbage);
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		return garbages1;
		}

}
