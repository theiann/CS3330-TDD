package hw4.maze;

import java.util.ArrayList;

public class Grid {
	private ArrayList<Row> rows;
	
	
	
	/*
	 * Parameterized constructor for class Grid.
	 * @param list ArrayList of Row objects to be used to construct the Grid.
	 */
	public Grid(ArrayList<Row> list) {
		this.rows = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			rows.add(list.get(i));
		}
	}
	
	/*
	 * This method returns the ArrayList of Row objects.
	 */
	public ArrayList<Row> getRows() {
		return this.rows;
	}
	
	
	/*
	 * This method will set the rows of a grid to the provided ArrayList of Row objects.
	 * @param list ArrayList of Row objects for the Grid to be replaced with.
	 */
	public void setRows(ArrayList<Row> list) {
		if (list != null) {
			this.rows.clear();
			for (int i = 0; i < list.size(); i++) {
				rows.add(list.get(i));
			}
		} else {this.rows = null;}
	}
	
	/*
	 * This method will return a string of the Grid object.
	 */
	@Override
	public String toString() {
		return "Grid [rows=" + rows.toString() + "]";
	}

	

}
