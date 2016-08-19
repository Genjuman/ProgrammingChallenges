/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkTheChess;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Libor
 */
public class PieceTypeTest {
    
    public PieceTypeTest() {
    }

    @Test
    public void testContainsAll() {
        assertEquals(true, PieceType.contains('p'));
        assertEquals(true, PieceType.contains('n'));
        assertEquals(true, PieceType.contains('b'));
        assertEquals(true, PieceType.contains('r'));
        assertEquals(true, PieceType.contains('q'));
        assertEquals(true, PieceType.contains('k'));
        
        assertEquals(true, PieceType.contains('P'));
        assertEquals(true, PieceType.contains('N'));
        assertEquals(true, PieceType.contains('B'));
        assertEquals(true, PieceType.contains('R'));
        assertEquals(true, PieceType.contains('Q'));
        assertEquals(true, PieceType.contains('K'));
        
        assertEquals(false, PieceType.contains('.'));
        assertEquals(false, PieceType.contains('!'));
    }
    
}
