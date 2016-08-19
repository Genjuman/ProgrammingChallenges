/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkTheChess;

/**
 *
 * @author Libor
 */
public class PieceSet {

    private int whitePawn;
    private int whiteKnight;
    private int whiteBishop;
    private int whiteRook;
    private int whiteQueen;
    private int whiteKing;

    private int blackPawn;
    private int blackKnight;
    private int blackBishop;
    private int blackRook;
    private int blackQueen;
    private int blackKing;

    private boolean setPossible;

    public PieceSet() {
        this.whitePawn = 0;
        this.whiteKnight = 0;
        this.whiteBishop = 0;
        this.whiteRook = 0;
        this.whiteQueen = 0;
        this.whiteKing = 0;
        this.blackPawn = 0;
        this.blackKnight = 0;
        this.blackBishop = 0;
        this.blackRook = 0;
        this.blackQueen = 0;
        this.blackKing = 0;
        this.setPossible = false;
    }

    public boolean checkPiece(char pieceType) {
        switch (pieceType) {
            case 'p':
                if (this.blackPawn < 8) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'P':
                if (this.whitePawn < 8) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'n':
                if (this.blackKnight < 2) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'N':
                if (this.whiteKnight < 2) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'b':
                if (this.blackBishop < 2) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'B':
                if (this.whiteBishop < 2) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'r':
                if (this.blackRook < 2) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'R':
                if (this.whiteRook < 2) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'q':
                if (this.blackQueen < 1) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'Q':
                if (this.whiteQueen < 1) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'k':
                if (this.blackKing < 1) {
                    this.setPossible = true;
                    return true;
                }
                break;
            case 'K':
                if (this.whiteKing < 1) {
                    this.setPossible = true;
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public boolean addPiece(char pieceType) {
        if (!setPossible) {
            return setPossible;
        }

        switch (pieceType) {
            case 'p':
                if (this.blackPawn < 8) {
                    this.setPossible = false;
                    this.blackPawn++;
                    return true;
                }
                break;
            case 'P':
                if (this.whitePawn < 8) {
                    this.setPossible = false;
                    this.whitePawn++;
                    return true;
                }
                break;
            case 'n':
                if (this.blackKnight < 2) {
                    this.setPossible = false;
                    this.blackKnight++;
                    return true;
                }
                break;
            case 'N':
                if (this.whiteKnight < 2) {
                    this.setPossible = false;
                    this.whiteKnight++;
                    return true;
                }
                break;
            case 'b':
                if (this.blackBishop < 2) {
                    this.setPossible = false;
                    this.blackBishop++;
                    return true;
                }
                break;
            case 'B':
                if (this.whiteBishop < 2) {
                    this.setPossible = false;
                    this.whiteBishop++;
                    return true;
                }
                break;
            case 'r':
                if (this.blackRook < 2) {
                    this.setPossible = false;
                    this.blackRook++;
                    return true;
                }
                break;
            case 'R':
                if (this.whiteRook < 2) {
                    this.setPossible = false;
                    this.whiteRook++;
                    return true;
                }
                break;
            case 'q':
                if (this.blackQueen < 1) {
                    this.setPossible = false;
                    this.blackQueen++;
                    return true;
                }
                break;
            case 'Q':
                if (this.whiteQueen < 1) {
                    this.setPossible = false;
                    this.whiteQueen++;
                    return true;
                }
                break;
            case 'k':
                if (this.blackKing < 1) {
                    this.setPossible = false;
                    this.blackKing++;
                    return true;
                }
                break;
            case 'K':
                if (this.whiteKing < 1) {
                    this.setPossible = false;
                    this.whiteKing++;
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public int getWhitePawn() {
        return whitePawn;
    }

    public int getWhiteKnight() {
        return whiteKnight;
    }

    public int getWhiteBishop() {
        return whiteBishop;
    }

    public int getWhiteRook() {
        return whiteRook;
    }

    public int getWhiteQueen() {
        return whiteQueen;
    }

    public int getWhiteKing() {
        return whiteKing;
    }

    public int getBlackPawn() {
        return blackPawn;
    }

    public int getBlackKnight() {
        return blackKnight;
    }

    public int getBlackBishop() {
        return blackBishop;
    }

    public int getBlackRook() {
        return blackRook;
    }

    public int getBlackQueen() {
        return blackQueen;
    }

    public int getBlackKing() {
        return blackKing;
    }

    public void reset() {
        this.whitePawn = 0;
        this.whiteKnight = 0;
        this.whiteBishop = 0;
        this.whiteRook = 0;
        this.whiteQueen = 0;
        this.whiteKing = 0;
        this.blackPawn = 0;
        this.blackKnight = 0;
        this.blackBishop = 0;
        this.blackRook = 0;
        this.blackQueen = 0;
        this.blackKing = 0;
    }

}
