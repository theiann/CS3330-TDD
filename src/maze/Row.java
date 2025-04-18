package maze;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> cells;
	
	public Row(ArrayList<Cell> list) {
		this.cells = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			this.cells.add(list.get(i));
		}
	}
}
