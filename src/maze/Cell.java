package maze;


public class Cell {
	private CellComponents left, right, up, down;
	
	
	
	
	/*
	 *  Parameterized constructor for class Cell
	 *  
	 *  @param left CellComponent for the left side of the cell
	 *  @param right CellComponent for the right side of the cell
	 *  @param up CellComponent for the up side of the cell
	 *  @param down CellComponent for the down side of the cell
	 */
	public Cell (CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}
	
	
	
	/*
	 * This method will get the left side CellComponent of the cell.
	 */
	public CellComponents getLeft() {
		return this.left;
	}
	
	
	/*
	 * This method will set the left side CellComponent of the cell.
	 * @param c CellComponent to be set to the left side of the cell. If null, it will by default be set to WALL.
	 */
	public void setLeft(CellComponents c) {
		if (c == null) {
			this.left = CellComponents.WALL;
		} else {
			this.left = c;
		}
	}
	
	/*
	 * This method will get the right side CellComponent of the cell.
	 */
	public CellComponents getRight() {
		return this.right;
	}
	
	
	/*
	 * This method will set the right side CellComponent of the cell.
	 * @param c CellComponent to be set to the right side of the cell. If null, it will by default be set to WALL.
	 */
	public void setRight(CellComponents c) {
		if (c == null) {
			this.right = CellComponents.WALL;
		} else {
			this.right = c;
		}
	}
	
	/*
	 * This method will get the up side CellComponent of the cell.
	 */
	public CellComponents getUp() {
		return this.up;
	}
	
	
	/*
	 * This method will set the up side CellComponent of the cell.
	 * @param c CellComponent to be set to the up side of the cell. If null, it will by default be set to WALL.
	 */
	public void setUp(CellComponents c) {
		if (c == null) {
			this.up = CellComponents.WALL;
		} else {
			this.up = c;
		}
	}
	/*
	 * This method will get the down side CellComponent of the cell.
	 */
	public CellComponents getDown() {
		return this.down;
	}
	
	
	/*
	 * This method will set the down side CellComponent of the cell.
	 * @param c CellComponent to be set to the down side of the cell. If null, it will by default be set to WALL.
	 */
	public void setDown(CellComponents c) {
		if (c == null) {
			this.down = CellComponents.WALL;
		} else {
			this.down = c;
		}
	}



	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}

