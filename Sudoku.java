
public class Sudoku {
	
	
	public LinearNode<Integer>[] board;
	private int [][] matrix;

	
	public Sudoku (int [][] doubleArray) {		// Takes in 2D array and makes an array of linked lists	
		matrix = doubleArray;
		board = new LinearNode[9];	// new array with length 9
		LinearNode<Integer> current;		// Pointer
		LinearNode<Integer> NewNode;		// represent newNode being added
		
		
		//Lets loop through the columns!
		for (int col = 0; col < 9; col++) {
			
			board[col] = new LinearNode<Integer>(doubleArray[col][0]); // populate board array with column heads
			current = board[col];	//pointer points to column head										
			 
			//Lets loop through the rows!
			for (int row = 1; row < 9; row++) {	// start at position after column head
				NewNode = new LinearNode<Integer> (doubleArray[col][row]);	//create a new node 
				 current.setNext(NewNode);			// set next to be the new Node
				 current = NewNode;					// move pointer to new Node
						
				
				} // end for				
				
			} // end for			
			
		} // end Sudoku method
		

	public boolean isValidRow(int rowNum) {		
		UniqueArray <Integer> tempArray = new UniqueArray <Integer> ();			// new unique array
		LinearNode<Integer> Head = board[rowNum-1];	// new LinearNode Head, assigned with index of board array
		LinearNode<Integer> current = Head;			// new pointer node at head
		tempArray.addItem(Head.getElement());		// add head node into array
//		current = current.getNext();				// change pointer to next
		
		for (int x = 0; x < 9; x++) {					// loop through 8 times				
			if (current.getElement() >= 1 && current.getElement() <= 9) 	
				tempArray.addItem(current.getElement());	// add current node to array
				current = current.getNext();				// change pointer to next
			
			
			} // end for
		
			
		if (tempArray.getNumElements() == 9) {		// if 9 items were added in the array
			return true;
		
			} // end if
							
		return false;	
	
	} // end isValid Method
			
	
	public boolean isValidCol(int colNum) {
		UniqueArray <Integer> tempArray = new UniqueArray <Integer> ();			// new unique array
		LinearNode<Integer> Head;							// head node
		LinearNode<Integer> current;						// current node
		
		int count = 0;
			
		for (int x = 0; x < board.length; x++) {		// loop through board array
			Head = board[x];							// set board element as Head node
			current = Head;								// point current to head
		
			for (int i = 0; i < colNum -1; i++) {			// loop through rows
				current = current.getNext();			
					
			}
			
			if(current.getElement() >= 1 && current.getElement() <= 9) // if sudoku value is greater than 1 and less than 9			
					tempArray.addItem(current.getElement());			// add item to array
			
		
			if (tempArray.getNumElements() == 9) {		// if num elements in array is 9, return true		
				return true;	
				
				}
		
			}
		
		return false;
	
		} // end isValidCol
		 	

	
	public boolean isValidBox(int rowNum, int colNum) {
		UniqueArray <Integer> tempArray = new UniqueArray <Integer> ();			// new unique array
		LinearNode<Integer> current = board[rowNum];
		
		if (rowNum > 7 || colNum > 7) { 	// if x or y is greater than 7, return false
			return false;
			}
		
		else {			
						
			for (int x = rowNum -1; x < rowNum + 2; x++) { // loop through rows 3 times				
				
				for (int y = colNum -1; y < colNum+2; y++) {
					if(current.getElement() >= 1 && current.getElement() <= 9)
						tempArray.addItem(current.getElement());	// add current node to array
						current = current.getNext();						
					
				} // end if			
				
			} // end for
			
			if (tempArray.getNumElements() == 9) {		// if num elements in array is 9, return true		
				return true;	
				
				} // end if
			
			return false;
		}
			
	}
	
	
	
		public boolean isValidSolution() {
			
			LinearNode<Integer> Head;					
			LinearNode<Integer> current;
			
			boolean isValid = true;
			
			for (int row = 1; row < 10; row ++) {		// loop through 9 times
				
				
				
				if (!isValidRow(row) || (!isValidCol(row))) { 	// check valid rows and columns on board elements				
						isValid = false;				 		// return false;
									
						} // end if					
				
			}
			
			// check if sudoko boxes are invalid!

			if (!isValidBox(1, 1) ||(!isValidBox(1, 4)) ||!isValidBox(1,7) || !isValidBox(4, 1) || !isValidBox(4, 4) || !isValidBox(4, 7) || !isValidBox(7, 1) || !isValidBox(7, 4) || !isValidBox(7, 7) )	{			
					isValid = false;
				
				}
		
			return isValid; // return true if all is valid!
			
		} // endIsValidSolution Method
		
		
		
	
	
	public String toString() {
    
		String str = "";
		LinearNode<Integer> current;
		LinearNode<Integer> Head;
		
		// loop through the columns!
		for (int x = 0; x < 9; x++) { 
			Head = board[x];
			current = Head;
			
			// loop through the rows!
			for (int y = 0; y < 9; y++) {	// loop through 9 times					
					
				if (y == 8) {		// if y is the last element in row					
					str += + current.getElement(); // don't add spaces at end
						
					} // end if
				
				else {
					str += + current.getElement() + "  "; 	// add 2 spaces between each number
					current = current.getNext(); 			// set pointer to next node
					
					} // end else
				
				} // end for
			
			if ( x < board.length-1) {   // new line at the end of each row    		
				str += "\n";
				
				} // end if
		
			}  // end for 

		return str;
		
    } // end toString method
	
	
	
} // end Sudoku Method!
