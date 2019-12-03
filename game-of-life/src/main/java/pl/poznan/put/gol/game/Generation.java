package pl.poznan.put.gol.game;

import java.util.List;
import java.util.stream.Collectors;

public class Generation {

	private Rules rules;
	private Cells aliveCells;

	public Generation(Rules rules, Cell... aliveCells) {
		this(rules, new Cells(aliveCells));
	}

	public Generation(Rules rules, Cells aliveCells) {
		this.rules = rules;
		this.aliveCells = aliveCells;
	}

	public void evolve() {
		List<Cell> listCell=aliveCells.getNeighbors().cells.stream()
				.filter(neighbor -> rules.inNextGeneration(isAlive(neighbor),countAliveNeighbors(neighbor)))
				.collect(Collectors.toList());

		aliveCells=new Cells();
		listCell.forEach(cell -> aliveCells.add(cell));
	}

	public boolean isAlive(Cell cell) {
		return aliveCells.cells.contains(cell);

	}

	public int countAliveNeighbors(Cell cell) {
		final int[] c = {0};
		cell.neighbors().forEach(cell1 -> {
			if (isAlive(cell1)) {
				c[0]++;
			}
		});
		return c[0];
	}

	public boolean extinct() {
		return aliveCells.isEmpty();
	}

	public Cells getAliveCells() {
		return aliveCells;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Generation)) {
			return false;
		}
		Generation other = (Generation) obj;
		return aliveCells.equals(other.aliveCells);
	}
}
