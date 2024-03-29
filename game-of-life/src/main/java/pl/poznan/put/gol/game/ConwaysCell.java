package pl.poznan.put.gol.game;

import java.util.Objects;

public class ConwaysCell implements Cell {

	protected int i;
	protected int j;

	public ConwaysCell(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public Cells neighbors() {
		Cells cells = new Cells();
		cells.add(new ConwaysCell(i - 1, j + 1));
		cells.add(new ConwaysCell(i - 1, j));
		cells.add(new ConwaysCell(i - 1, j - 1));
		cells.add(new ConwaysCell(i, j + 1));
		cells.add(new ConwaysCell(i, j - 1));
		cells.add(new ConwaysCell(i + 1, j + 1));
		cells.add(new ConwaysCell(i + 1, j));
		cells.add(new ConwaysCell(i + 1, j - 1));

		return cells;
	}

	@Override
	public String toString() {
		return "c(" + i + ":" + j + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConwaysCell that = (ConwaysCell) o;
		return i == that.i &&
				j == that.j;
	}

	@Override
	public int hashCode() {
		return Objects.hash(i, j);
	}
}
