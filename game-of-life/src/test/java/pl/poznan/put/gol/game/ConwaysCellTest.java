package pl.poznan.put.gol.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConwaysCellTest {
    private ConwaysCell conwaysCell= new ConwaysCell(2,2);

    @Test
    public void neighbors() {
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(1,2)));
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(1,1)));
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(1,3)));
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(2,3)));
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(2,1)));
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(3,1)));
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(3,2)));
        assertTrue(conwaysCell.neighbors().contains(new ConwaysCell(3,3)));
    }

    @Test
    public void equal()
    {
        assertEquals(new ConwaysCell(2,2), conwaysCell);
    }


}