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
public class PieceSetTest {

    public PieceSetTest() {
    }

    char whitePawn = 'P';
    char whiteKnight = 'N';
    char whiteBishop = 'B';
    char whiteRook = 'R';
    char whiteQueen = 'Q';
    char whiteKing = 'K';

    char blackPawn = 'p';
    char blackKnight = 'n';
    char blackBishop = 'b';
    char blackRook = 'r';
    char blackQueen = 'q';
    char blackKing = 'k';

    char nonsence = 'H';

    @Test
    public void testAddBlackPawns() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(1, ps.getBlackPawn());
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(2, ps.getBlackPawn());
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(3, ps.getBlackPawn());
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(4, ps.getBlackPawn());
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(5, ps.getBlackPawn());
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(6, ps.getBlackPawn());
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(7, ps.getBlackPawn());
        assertEquals(true, ps.checkPiece(blackPawn));
        assertEquals(true, ps.addPiece(blackPawn));
        assertEquals(8, ps.getBlackPawn());
        assertEquals(false, ps.checkPiece(blackPawn));
        assertEquals(false, ps.addPiece(blackPawn));
        assertEquals(8, ps.getBlackPawn());
        ps.reset();
        assertEquals(0, ps.getBlackPawn());
    }

    @Test
    public void testAddWhitePawns() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(1, ps.getWhitePawn());
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(2, ps.getWhitePawn());
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(3, ps.getWhitePawn());
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(4, ps.getWhitePawn());
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(5, ps.getWhitePawn());
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(6, ps.getWhitePawn());
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(7, ps.getWhitePawn());
        assertEquals(true, ps.checkPiece(whitePawn));
        assertEquals(true, ps.addPiece(whitePawn));
        assertEquals(8, ps.getWhitePawn());
        assertEquals(false, ps.checkPiece(whitePawn));
        assertEquals(false, ps.addPiece(whitePawn));
        assertEquals(8, ps.getWhitePawn());
        ps.reset();
        assertEquals(0, ps.getWhitePawn());
    }

    @Test
    public void testAddBlackKnight() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(blackKnight));
        assertEquals(true, ps.addPiece(blackKnight));
        assertEquals(1, ps.getBlackKnight());
        assertEquals(true, ps.checkPiece(blackKnight));
        assertEquals(true, ps.addPiece(blackKnight));
        assertEquals(2, ps.getBlackKnight());
        assertEquals(false, ps.checkPiece(blackKnight));
        assertEquals(false, ps.addPiece(blackKnight));
        assertEquals(2, ps.getBlackKnight());
        ps.reset();
        assertEquals(0, ps.getBlackKnight());
    }

    @Test
    public void testAddWhiteKnight() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(whiteKnight));
        assertEquals(true, ps.addPiece(whiteKnight));
        assertEquals(1, ps.getWhiteKnight());
        assertEquals(true, ps.checkPiece(whiteKnight));
        assertEquals(true, ps.addPiece(whiteKnight));
        assertEquals(2, ps.getWhiteKnight());
        assertEquals(false, ps.checkPiece(whiteKnight));
        assertEquals(false, ps.addPiece(whiteKnight));
        assertEquals(2, ps.getWhiteKnight());
        ps.reset();
        assertEquals(0, ps.getWhiteKnight());
    }

    @Test
    public void testAddWhiteBishop() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(whiteBishop));
        assertEquals(true, ps.addPiece(whiteBishop));
        assertEquals(1, ps.getWhiteBishop());
        assertEquals(true, ps.checkPiece(whiteBishop));
        assertEquals(true, ps.addPiece(whiteBishop));
        assertEquals(2, ps.getWhiteBishop());
        assertEquals(false, ps.checkPiece(whiteBishop));
        assertEquals(false, ps.addPiece(whiteBishop));
        assertEquals(2, ps.getWhiteBishop());
        ps.reset();
        assertEquals(0, ps.getWhiteBishop());
    }

    @Test
    public void testAddBlackBishop() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(blackBishop));
        assertEquals(true, ps.addPiece(blackBishop));
        assertEquals(1, ps.getBlackBishop());
        assertEquals(true, ps.checkPiece(blackBishop));
        assertEquals(true, ps.addPiece(blackBishop));
        assertEquals(2, ps.getBlackBishop());
        assertEquals(false, ps.checkPiece(blackBishop));
        assertEquals(false, ps.addPiece(blackBishop));
        assertEquals(2, ps.getBlackBishop());
        ps.reset();
        assertEquals(0, ps.getBlackBishop());
    }

    @Test
    public void testAddWhiteRook() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(whiteRook));
        assertEquals(true, ps.addPiece(whiteRook));
        assertEquals(1, ps.getWhiteRook());
        assertEquals(true, ps.checkPiece(whiteRook));
        assertEquals(true, ps.addPiece(whiteRook));
        assertEquals(2, ps.getWhiteRook());
        assertEquals(false, ps.checkPiece(whiteRook));
        assertEquals(false, ps.addPiece(whiteRook));
        assertEquals(2, ps.getWhiteRook());
        ps.reset();
        assertEquals(0, ps.getWhiteRook());
    }

    @Test
    public void testAddBlackRook() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(blackRook));
        assertEquals(true, ps.addPiece(blackRook));
        assertEquals(1, ps.getBlackRook());
        assertEquals(true, ps.checkPiece(blackRook));
        assertEquals(true, ps.addPiece(blackRook));
        assertEquals(2, ps.getBlackRook());
        assertEquals(false, ps.checkPiece(blackRook));
        assertEquals(false, ps.addPiece(blackRook));
        assertEquals(2, ps.getBlackRook());
        ps.reset();
        assertEquals(0, ps.getBlackRook());
    }

    @Test
    public void testAddWhiteQueen() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(whiteQueen));
        assertEquals(true, ps.addPiece(whiteQueen));
        assertEquals(1, ps.getWhiteQueen());
        assertEquals(false, ps.checkPiece(whiteQueen));
        assertEquals(false, ps.addPiece(whiteQueen));
        assertEquals(1, ps.getWhiteQueen());
        ps.reset();
        assertEquals(0, ps.getWhiteQueen());
    }

    @Test
    public void testAddBlackQueen() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(blackQueen));
        assertEquals(true, ps.addPiece(blackQueen));
        assertEquals(1, ps.getBlackQueen());
        assertEquals(false, ps.checkPiece(blackQueen));
        assertEquals(false, ps.addPiece(blackQueen));
        assertEquals(1, ps.getBlackQueen());
        ps.reset();
        assertEquals(0, ps.getBlackQueen());
    }

    @Test
    public void testAddWhiteKing() {
        PieceSet ps = new PieceSet();
        assertEquals(true, ps.checkPiece(whiteKing));
        assertEquals(true, ps.addPiece(whiteKing));
        assertEquals(1, ps.getWhiteKing());
        assertEquals(false, ps.checkPiece(whiteKing));
        assertEquals(false, ps.addPiece(whiteKing));
        assertEquals(1, ps.getWhiteKing());
        ps.reset();
        assertEquals(0, ps.getWhiteKing());
    }

    @Test
    public void testAddNonsense() {
        PieceSet ps = new PieceSet();
        assertEquals(false, ps.checkPiece(nonsence));
        assertEquals(false, ps.addPiece(nonsence));

    }
    
    @Test
    public void testTryAddWithoutCheck() {
        PieceSet ps = new PieceSet();
        assertEquals(false, ps.addPiece(whiteRook));
        assertEquals(true, ps.checkPiece(whiteRook));
        assertEquals(true, ps.addPiece(whiteRook));
        assertEquals(1, ps.getWhiteRook());
        

    }
    
    

}
