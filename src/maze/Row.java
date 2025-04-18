package maze;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> cells;
	
	
	
	/*
	 * Parameterized constructor for class Row.
	 * @param list ArrayList of Cell objects to be used to construct the Row.
	 */
	public Row(ArrayList<Cell> list) {
		this.cells = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			cells.add(list.get(i));
		}
	}
	
	/*
	 * This method returns the ArrayList of Cell objects.
	 */
	public ArrayList<Cell> getCells() {
		return this.cells;
	}
	
	
	/*
	 * This method will set the cells of a row to the provided ArrayList of Cell objects.
	 * @param list ArrayList of Cell objects for the row to be replaced with.
	 */
	public void setCells(ArrayList<Cell> list) {
		if (list != null) {
			this.cells.clear();
			for (int i = 0; i < list.size(); i++) {
				cells.add(list.get(i));
			}
		} else {this.cells = null;}
	}
	
	/*
	 * This method will return a string of the Row object.
	 */
	@Override
	public String toString() {
		return "Row [cells=" + cells.toString() + "]";
	}

	
}
