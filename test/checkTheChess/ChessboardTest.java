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
public class ChessboardTest {

    public ChessboardTest() {
    }

    String line = "........";
    String line2 = "pppppppp";
    String wLine1 = ".........";
    String wLine2 = ".......";

    @Test
    public void testAddLineMaxLines() {
        Chessboard cb = new Chessboard();

        assertEquals(0, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(1, cb.getActualLineNumber());
        cb.addLine(wLine1);
        assertEquals(1, cb.getActualLineNumber());
        cb.addLine(wLine2);
        assertEquals(1, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(2, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(3, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(4, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(5, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(6, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(7, cb.getActualLineNumber());
        cb.addLine(line2);
        assertEquals(8, cb.getActualLineNumber());
        cb.addLine(line);
        assertEquals(8, cb.getActualLineNumber());
    }

    @Test
    public void testAddLineWrongLenght() {
        Chessboard cb = new Chessboard();
        cb.addLine(wLine1);
        assertEquals(0, cb.getActualLineNumber());
        cb.addLine(wLine2);
        assertEquals(0, cb.getActualLineNumber());
    }

    @Test
    public void testEvaluateFlush() {
        Chessboard cb = new Chessboard();
        for (int i = 0; i < 10; i++) {
            cb.addLine(line);
        }
        cb.addLine(line2);
        assertEquals(8, cb.getActualLineNumber());

        cb.evaluate();
        assertEquals(0, cb.getActualLineNumber());
    }

    @Test
    public void testWhiteKingThrByBlackPawn() {
        Chessboard cb = new Chessboard();
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..p.....");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..p.....");
        cb.addLine("...K....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
    }

    @Test
    public void testBlackKingThrByWhitePawn() {
        Chessboard cb = new Chessboard();
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine(".P......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("...P....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
    }

    @Test
    public void testBlackKingThrByWhiteKnight() {
        Chessboard cb = new Chessboard();
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
    }

    @Test
    public void testWhiteKingThrByBlackKnight() {
        Chessboard cb = new Chessboard();
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
    }

    @Test
    public void testBlackKingThrByWhiteRook() {
        Chessboard cb = new Chessboard();
        cb.addLine("...k....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...R....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...R...k");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...R....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...k....");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("k..R....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("...k....");
        cb.addLine("...p....");
        cb.addLine("........");
        cb.addLine("...R....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...R.p.k");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...R....");
        cb.addLine("........");
        cb.addLine("...p....");
        cb.addLine("...k....");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("kp.R....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...R....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());

    }

    @Test
    public void testWhiteKingThrByBlackRook() {
        Chessboard cb = new Chessboard();
        cb.addLine("...K....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...r....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...r...K");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...r....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...K....");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("K..r....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("...K....");
        cb.addLine("...p....");
        cb.addLine("........");
        cb.addLine("...r....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...r.p.K");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...r....");
        cb.addLine("........");
        cb.addLine("...p....");
        cb.addLine("...K....");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("Kp.r....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...r....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());

    }

    @Test
    public void testWhiteKingThrByBlackBishop() {
        Chessboard cb = new Chessboard();

        cb.addLine("K.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("K.......");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine("K.......");
        cb.addLine(".P......");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());

        cb.addLine("......K.");
        cb.addLine(".....P..");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine(".....P..");
        cb.addLine("......K.");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine(".P......");
        cb.addLine("K.......");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...b....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasWhiteKingThreatened());

    }
    
    @Test
    public void testBlackKingThrByWhiteBishop() {
        Chessboard cb = new Chessboard();

        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("k.......");
        cb.addLine(".p......");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());

        cb.addLine("......k.");
        cb.addLine(".....p..");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine(".....p..");
        cb.addLine("......k.");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine(".p......");
        cb.addLine("k.......");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(false, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...B....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

    }

    @Test
    public void testWhiteKingThrBlackKing() {
        Chessboard cb = new Chessboard();
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".Kk.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("kK......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
    }

    @Test
    public void testBlackKingInDifficultSituations() {
        Chessboard cb = new Chessboard();
        cb.addLine("k.......");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("...k....");
        cb.addLine("...K....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine(".......k");
        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("kK......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......Kk");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("k.......");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...K....");
        cb.addLine("...k....");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine(".......k");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

    }

    @Test
    public void testWhiteKingInDifficultSituations() {
        Chessboard cb = new Chessboard();
        cb.addLine("K.......");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("...K....");
        cb.addLine("...k....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine(".......K");
        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("Kk......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......kK");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("K.......");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...k....");
        cb.addLine("...K....");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine(".......K");

        cb.evaluate();

        assertEquals(true, cb.wasWhiteKingThreatened());
        assertEquals(true, cb.wasBlackKingThreatened());

    }

    @Test
    public void testOtherPiecesInDifficultSituations() {
        Chessboard cb = new Chessboard();
        cb.addLine("P..KQBNR");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("p..kqbnr");

        cb.evaluate();

    }

    @Test
    public void testWhiteKnightInDifficultSituations() {
        Chessboard cb = new Chessboard();
        cb.addLine("N.......");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine("N.......");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());

        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine(".N......");
        cb.addLine("...k....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("...N....");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("...N....");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("......N.");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine(".......k");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine(".......N");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine(".......N");
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("..k.....");
        cb.addLine("N.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("N.......");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("N.......");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("...k....");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("...k....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine(".k......");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine(".....k..");
        cb.addLine("...N....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("....k...");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine(".......k");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine(".....k..");
        cb.addLine(".......N");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".......N");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".......N");
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("N.......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("N.......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("N.......");
        cb.addLine("..k.....");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...k....");
        cb.addLine(".N......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("...k....");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine(".k......");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("...N....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("...N....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...N....");
        cb.addLine(".....k..");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("....k...");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("......N.");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......k");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......N");
        cb.addLine(".....k..");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine(".......N");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine(".......N");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("N.......");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("N.......");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine(".N......");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine(".N......");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...k....");
        cb.addLine(".N......");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("...N....");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("...N....");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("...N....");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("...N....");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("......N.");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("......N.");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......k");
        cb.addLine("........");
        cb.addLine("......N.");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine(".......N");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine(".......N");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("N.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("N.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("N.......");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("N.......");
        cb.addLine("........");
        cb.addLine(".k......");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...k....");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("...k....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("..k.....");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".N......");
        cb.addLine("........");
        cb.addLine("k.......");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".......k");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....k...");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("....k...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......N.");
        cb.addLine("........");
        cb.addLine(".......k");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine(".......N");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....k..");
        cb.addLine(".......N");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......N");
        cb.addLine(".....k..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......N");
        cb.addLine("........");
        cb.addLine("......k.");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasBlackKingThreatened());
    }

    @Test
    public void testBlackKnightInDifficultSituations() {
        Chessboard cb = new Chessboard();
        cb.addLine("n.......");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine("n.......");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());

        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("K.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine(".n......");
        cb.addLine("...K....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("...n....");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("...n....");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("......n.");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine(".......K");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine(".......n");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine(".......n");
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("..K.....");
        cb.addLine("n.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("n.......");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("n.......");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("...K....");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("...K....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("K.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine(".K......");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine(".....K..");
        cb.addLine("...n....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("....K...");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine(".......K");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine(".....K..");
        cb.addLine(".......n");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".......n");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".......n");
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("n.......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("n.......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("n.......");
        cb.addLine("..K.....");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("K.......");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...K....");
        cb.addLine(".n......");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("...K....");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine(".K......");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("...n....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("...n....");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...n....");
        cb.addLine(".....K..");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("....K...");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("......n.");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......K");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......n");
        cb.addLine(".....K..");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine(".......n");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine(".......n");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("n.......");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("n.......");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("K.......");
        cb.addLine("........");
        cb.addLine(".n......");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine(".n......");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...K....");
        cb.addLine(".n......");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("...n....");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("...n....");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("...n....");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("...n....");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("......n.");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("......n.");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......K");
        cb.addLine("........");
        cb.addLine("......n.");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine(".......n");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine(".......n");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("n.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("n.......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("n.......");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("n.......");
        cb.addLine("........");
        cb.addLine(".K......");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("K.......");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("...K....");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("...K....");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("..K.....");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".n......");
        cb.addLine("........");
        cb.addLine("K.......");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".......K");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("....K...");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("....K...");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("......n.");
        cb.addLine("........");
        cb.addLine(".......K");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine(".......n");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".....K..");
        cb.addLine(".......n");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......n");
        cb.addLine(".....K..");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
        
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine("........");
        cb.addLine(".......n");
        cb.addLine("........");
        cb.addLine("......K.");
        cb.addLine("........");
        cb.addLine("........");

        cb.evaluate();
        assertEquals(true, cb.wasWhiteKingThreatened());
    }


}
