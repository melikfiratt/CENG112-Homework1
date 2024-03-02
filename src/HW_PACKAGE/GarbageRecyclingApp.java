package HW_PACKAGE;

public class GarbageRecyclingApp {

	public GarbageRecyclingApp() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//Created each bin as an object of IBag<>
		FileIO fileIO = new FileIO();
		IBag<Garbage> displayCan = fileIO.display();
		TrashCan<Garbage> trashCan = (TrashCan<Garbage>) fileIO.readTrashCan();
		IBag<Garbage> plasticBin = new PlasticRecycleBin<>();
		IBag<Garbage> paperBin = new PaperRecycleBin<>();
		IBag<Garbage> metalBin = new MetalRecycleBin<>();
		IBag<Garbage> glassBin = new GlassRecycleBin<>();
		IBag<Garbage> fabricBin = new FabricRecycleBin<>();
		IBag<Garbage> organicBin = new OrganicRecycleBin<>();
		int firstSize = trashCan.getItemCount();
		
		
		
		// I do the separation below
		for (int i = 0; i<trashCan.getItemCount(); i++) {
			trashCan.separate(plasticBin, glassBin, metalBin, organicBin, paperBin, fabricBin,trashCan.getItem(i));
		
			
			//I updated trashCan and update "updated_garbage.txt"	
		fileIO.updateTrashCan(trashCan);															
		}
		
		//this is the initial trash can display before separation
		System.out.println("TrashCan:"+ " size " + firstSize);
		for (int c = 0; c<displayCan.getItemCount(); c++) {
			System.out.println(displayCan.getItem(c).getAmount()+" "+displayCan.getItem(c).toString());
		}
		System.out.println("\n");
		
		
		//these are the each recycling bin displays 
		System.out.println("Plastic Recycling Bin:"+ " size " + plasticBin.getItemCount());
		display(plasticBin);
		System.out.println("\n");
		
		System.out.println("Paper Recycling Bin:" + " size " + paperBin.getItemCount());
		display(paperBin);
		System.out.println("\n");
		
		System.out.println("Metal Recycling Bin:" + " size " + metalBin.getItemCount());
		display(metalBin);                                                                                         //DISPLAY PART
		System.out.println("\n");
		
		System.out.println("Fabric Recycling Bin:" + " size " + fabricBin.getItemCount());
		display(fabricBin);
		System.out.println("\n");
		
		System.out.println("Organic Recycling Bin:" + " size " + organicBin.getItemCount());
		display(organicBin);
		System.out.println("\n");
		
		System.out.println("Glass Recycling Bin:" + " size " + glassBin.getItemCount());
		display(glassBin);
		System.out.println("\n");
		
		//this show the updated trashCan size
		System.out.println("TrashCan "+ "updated size: "+ trashCan.getItemCount());
		
		
		
		
			
	}
	
	private static IBag<Garbage> remove_duplication(IBag<Garbage> myBag) {
		IBag<Garbage> tempCan= new TrashCan<Garbage>();
	      
	      for (int i = 0; i<myBag.getItemCount();i++) {
	    	    if (!tempCan.contains(myBag.getItem(i))) {
	    	        tempCan.add(myBag.getItem(i));
	    	    }
	    	}
		return tempCan;
	}			
		                                                                                           //DISPLAY METHODS PART
	
	//this method is for only displaying the items by their amounts to see it better
	private static void display(IBag<Garbage> Bag) {
		IBag<Garbage> non_duplicate = remove_duplication(Bag);
		System.out.println("Contents");
		for (int i = 0;i<non_duplicate.getItemCount();i++) {
			for(int c = 0;c<Bag.getItemCount();c++) {
				Garbage item = Bag.getItem(c);
				if (non_duplicate.getItem(i).equals(item)) {	
					System.out.println(Bag.getFrequencyOf(item)+" "+item.toString());
					break;
				}
				
		}
		}		
		}	
			}
		
		
		
		
	
	
	
	
	


