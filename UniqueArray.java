

public class UniqueArray <T> {

	private T[] array;
	private int num;
	
	//Constructor 
	public UniqueArray() {
		
		array = (T[])new Object[5]; //initialize with length 5
		num = 0;
		
	} // end constructor
	
	
	// expand capacity of the array by 5 slots
	private void ExpandCapacity() {
		
		T[] tempArray = (T[])(new Object[array.length + 5]);

	      for (int x = 0; x < array.length; x++)
	         tempArray[x] = array[x];		// transfer elements into temp array

	      array = tempArray;			// set array as temp array
	   }
		                                                                                                 
	
	// check if array is full
	private boolean isFull() { 	
			
		if (num != array.length-1) {  // if number of elements is not the last space in the array				
			return false;
		} // end if	
		
		return true;
	
	} // end isFull method
	
	
	// return number of items/elements in array
	public int getNumElements() {
		return num;

	}
	
	
	// check if an element is present in the array
	private boolean isPresent(T element) {
		
		for (int x = 0; x < array.length; x++ ) {
			
			if(array[x] == element) { //if element is present, return true
			
				return true;
				
				} // end if
			
			} // end for
		
			return false;		// else return false
		
	} // end isPresent method

	
	// add an element to the end of the array
	public void addItem(T Element) {
		
		if (isPresent(Element)) { // If element is present in the array, do nothing								
			return;
		}
			 			
		else {	 	
			if (isFull())			// if array is full, expand capacity
		 		ExpandCapacity();
			
			array[num] = Element;	// add element to the end of the array
			num++;					// increase item counter
			
	 } // end else
		
			
		} // end addItem method
		

	//return length of array
	public int getLength() {		
		return array.length;		
		
	}
	
	
	//return string representation of array
	public String toString() {
		String str = "";
		
		for (int i = 0; i < num; i++) { // loop through array
		
			if (i == num-1){  // if item is the last element
		
				str += array[i];	//print without a comma or space
			
			} // end if
			
			else {					//print item with a ","
				
				str += array[i] + ", ";
				
			} // end else
		
		} // end for
		
		return str;
		
	} // end toString method


} // END UNIQUE ARRAY CLASS
