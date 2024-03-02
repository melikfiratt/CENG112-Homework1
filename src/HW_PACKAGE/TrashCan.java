package HW_PACKAGE;

public class TrashCan<T> implements IBag<T>{
	
	private T[] trashCan;
	private int numberOfItems;
	private static int DEFAULT_CAPACITY = 450;
	private boolean initialized = false;
	private static int MAX_CAPACITY = 10000;

	public TrashCan() {
		this(DEFAULT_CAPACITY);
		
	}
	public TrashCan(int capacity) {
		if (capacity<= MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempCan = (T[])new Object[capacity];
			trashCan = tempCan;
			numberOfItems = 0;
			initialized = true;
		}
		else {
			throw new IllegalStateException("Attempt to create a bag with over max allowed capacity."); 
		}
		
	}
	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException("Array bag object is not initialized properly.");
			
		}
	}
	
	
	public boolean separate(IBag<T> targetBag, IBag<T> targetBag1, IBag<T> targetBag2,IBag<T> targetBag3,IBag<T> targetBag4,IBag<T> targetBag5,T item) {
		
		if (item instanceof Garbage) {
			if (((Garbage) item).getType().equals("plastic")){
				if (transferTo(targetBag, item)) 
					remove(item);		
				}
			else if (((Garbage) item).getType().equals("glass")){
				if (transferTo(targetBag1, item)) 
					remove(item);		
				}
			else if (((Garbage) item).getType().equals("metal")){
				if (transferTo(targetBag2, item)) 
					remove(item);		
				}
			else if (((Garbage) item).getType().equals("organic")){
				if (transferTo(targetBag3, item)) 
					remove(item);		
				}
			else if (((Garbage) item).getType().equals("paper")){
				if (transferTo(targetBag4, item)) 
					remove(item);		
				}
			else if (((Garbage) item).getType().equals("fabric")){
				if (transferTo(targetBag5, item)) 
					remove(item);		
				}
				
			
						
			}	
		
						
		return true;
	}

	@Override
	public boolean add(T newItem) {
		checkInitialization();
		boolean result = true;
		if (isFull()) {
			result = false;
					
		}
		else {
			trashCan[numberOfItems] = newItem;
			numberOfItems ++;
			
		}
		return result;
		
	}	

	@Override
	public boolean isEmpty() {
		
		return numberOfItems == 0;
	}

	@Override
	public boolean isFull() {
		
		return numberOfItems >= trashCan.length;
	}

	@Override
	public T removeByIndex(int index) {
		T result = null;
		if (!isEmpty()&&index>=0) {
			result = trashCan[index];
			trashCan[index] = trashCan[numberOfItems-1];
			trashCan[numberOfItems-1] = null;
			numberOfItems --;
		}
		return result;
	}

	@Override
	public T remove() {
		checkInitialization();
		T result = null;
		if (!isEmpty()) {
			result = trashCan[numberOfItems-1];
			trashCan[numberOfItems-1] = null;
			numberOfItems--;
		}
		return result;
		
		
	}

	@Override
	public T remove(T item) {
		checkInitialization();
		int index = getIndexOf(item);
		T result = removeByIndex(index);
		return result;
	}

	@Override
	public int getItemCount() {
		
		return numberOfItems;
	}

	@Override
	public int getIndexOf(T item) {
		int where = -1;
		boolean found = false;
		int index = 0;
		while (!found&&(index<numberOfItems)) {
			if(item.equals(trashCan[index])) {
				found = true;
				where = index;			
			}
			index ++;
		}
		
		return where;
	}

	@Override
	public boolean contains(T item) {
		checkInitialization();
		return getIndexOf(item)>-1;
	}

	@Override
	public void displayItems() {
		System.out.println("Contents: ");
		for(int i = 0; i<=numberOfItems-1; i++) {
			System.out.println(trashCan[i]);
		}		
	}

	@Override
	public void dump() {
		while(!isEmpty()) {
			remove();
		}
		
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {	
		return targetBag.add(item);
		
	}
	
	public T getItem(int i) {
		return trashCan[i];
	}
	@Override
	public int getFrequencyOf(T item) {
		checkInitialization();
		int counter = 0;
		for(int i = 0; i<numberOfItems;i++) {
			if (item.equals(trashCan[i])){
				counter++;			
			}
		}
		return counter;
	}
}
	