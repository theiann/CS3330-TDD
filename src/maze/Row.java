package maze;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> cells;
	
	
	
	
	public Row(ArrayList<Cell> list) {
		this.cells = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			cells.add(list.get(i));
		}
		
	}
	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> list) {
		if (list != null) {
			this.cells.clear();
			for (int i = 0; i < list.size(); i++) {
				cells.add(list.get(i));
			}
		} else {this.cells = null;}
	}
	@Override
	public String toString() {
		return "Row [cells=" + cells.toString() + "]";
	}

	
}
