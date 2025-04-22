package hw4.player;
import hw4.maze.*;

public class Player {
	private Cell currentCell;
	private Row currentRow;
	
	public Player(Row currRow, Cell currCell) {
		this.currentRow = currRow;
		this.currentCell = currCell;
	}

	public void setCurrentCell(Cell cell) {
		this.currentCell = cell;
	}

	public void setCurrentRow(Row row) {
		this.currentRow = row;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}


	public Row getCurrentRow() {
		return currentRow;
	}

	
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell.toString() + ", currentRow=" + currentRow.toString() + "]";
	}
}
