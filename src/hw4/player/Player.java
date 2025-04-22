package hw4.player;
import hw4.maze.*;

public class Player {
	private Cell currentCell;
	private Row currentRow;
	
	
	/*
	 * This method will construct a Player object with parameters currRow and currCell.
	 * @param currRow the row that the player will start on
	 * @param currCell the cell that the player will start on
	 */
	public Player(Row currRow, Cell currCell) {
		this.currentRow = currRow;
		this.currentCell = currCell;
	}

	
	/*
	 * This method will set the current cell to the cell provided.
	 * @param cell This is the cell being set as the current cell.
	 */
	public void setCurrentCell(Cell cell) {
		this.currentCell = cell;
	}

	
	/*
	 * This method will set the current row to the row provided.
	 * @param cell This is the row being set as the current row.
	 */
	public void setCurrentRow(Row row) {
		this.currentRow = row;
	}
	
	
	/*
	 * This method will get the player object's current cell.
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}

	/*
	 * This method will get the player object's current row.
	 */
	public Row getCurrentRow() {
		return currentRow;
	}

	
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell.toString() + ", currentRow=" + currentRow.toString() + "]";
	}
}
