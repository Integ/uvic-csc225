public class MazeRunner {
	Maze mazeToSolve;
	A4Stack<MazeLocation> path;
	
	public MazeRunner(Maze aMaze) {
		mazeToSolve = aMaze;
		int size = mazeToSolve.getSize();
		path = new A4Stack<MazeLocation>(size);
	}
	
	/*
	 * Purpose: Determines whether there is a path from start to finish in this maze
	 * Parameters: MazeLocation start - starting coordinates of this maze
	 *			   MazeLocation finish - finish coordinates of this maze
	 * Returns: true if there is a path from start to finish
	 */
	public boolean solve(MazeLocation start, MazeLocation finish) {
		System.out.println("Searching maze from start: "+start+" to finish: "+finish);
		path.push(start);
		return findPath(start, finish);	
	}
	
	/*
	 * Purpose: Recursively determines if there is a path from cur to finish
	 * Parameters: MazeLocation cur - current cordinates in this maze
	 *			   MazeLocation finish - goal coordinates of this maze
	 * Returns: true if there is a path from cur to finish
	 *
	 * NOTE: This method updates the Maze's mazeData array when locations
	 *       are visited to an 'o', and further updates locations to an 'x'
	 *       if it is determined they lead to dead ends. If the finish 
	 *       location is found, the Stack named path should contain all of 
	 *       loations visited from the start location to the finish. 
	 */
	private boolean findPath(MazeLocation cur, MazeLocation finish) {
		int row = cur.row;
		int col = cur.col;
		mazeToSolve.setChar(row, col, 'o');
		System.out.println("\n"+mazeToSolve.toString());

		// TODO Implement this method so it solves the maze!
		if (path.top() != cur) {
			path.push(cur);
		}
		if (cur.equals(finish)) {
			return true;
		}

		MazeLocation upLoc = new MazeLocation(row - 1, col);
		MazeLocation rightLoc = new MazeLocation(row, col + 1);
		MazeLocation downLoc = new MazeLocation(row + 1, col);
		MazeLocation leftLoc = new MazeLocation(row, col - 1);

		char upCh = '\0';
		char rightCh = '\0';
		char downCh = '\0';
		char leftCh = '\0';
		if (row - 1 >= 0) {
			upCh = mazeToSolve.getChar(row - 1, col);
		}
		if (col + 1 < mazeToSolve.getCols()) {
		 	rightCh = mazeToSolve.getChar(row, col + 1);
		}
		if (row + 1 < mazeToSolve.getRows()) {
		 	downCh = mazeToSolve.getChar(row + 1, col);
		}
		if (col - 1 >= 0) {
			leftCh = mazeToSolve.getChar(row, col - 1);
		}

		if (upCh == ' ') {
			return findPath(upLoc, finish);
		} else if (rightCh == ' ') {
			return findPath(rightLoc, finish);
		} else if (downCh == ' ') {
			return findPath(downLoc, finish);
		} else if (leftCh == ' ') {
			return findPath(leftLoc, finish);
		} else {
			mazeToSolve.setChar(row, col, 'x');
			try {
				path.pop();
				MazeLocation last = path.pop();
				return findPath(last, finish);
			} catch (EmptyStackException e) {
				return false;
			}
		}
	}
	

	/*
	 * Purpose: Creates a string of maze locations found in the stack 
	 * Parameters: None
	 * Returns: A String representation of maze locations
	 */
	public String getPathToSolution() {
		String details = "";
		while(!path.isEmpty()) {
			details = path.pop() + details;
		}	
		return details;
	}
}