/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkTheChess;

import java.util.stream.IntStream;

/**
 *
 * @author Libor
 */
public class Chessboard {

    private char[][] chessboard;
    private int actualLineNumber;
    private PieceSet pieceSet;
    private boolean whiteKingThreatened;
    private boolean blackKingThreatened;

    public Chessboard() {
        this.chessboard = new char[8][8];
        this.actualLineNumber = 0;
        this.pieceSet = new PieceSet();
        this.whiteKingThreatened = false;
        this.blackKingThreatened = false;
    }

    public boolean wasWhiteKingThreatened() {
        return whiteKingThreatened;
    }

    public boolean wasBlackKingThreatened() {
        return blackKingThreatened;
    }

    public void evaluate() {
        if (actualLineNumber != 8) {
            System.out.println("Chessboard is still not complete.");
            return;
        }
        this.blackKingThreatened = false;
        this.whiteKingThreatened = false;

        System.out.println("\nStarting output:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessboard[i][j]);
                if (chessboard[i][j] != '.' && !(blackKingThreatened && whiteKingThreatened)) {
                    checkPiece(i, j, chessboard[i][j]);
                }
            }
            System.out.println("");
        }
        if (whiteKingThreatened && blackKingThreatened) {
            System.out.println("Impossible situation appeared. Both kings threatened!");
        } else if (whiteKingThreatened) {
            System.out.println("White king Threatened");
        } else if (blackKingThreatened) {
            System.out.println("Black king Threatened");
        } else {
            System.out.println("No king Threatened");
        }

        System.out.println("----------");

        actualLineNumber = 0;
        pieceSet.reset();
    }

    private void checkPiece(int x, int y, char piece) {
        switch (piece) {
            case 'p':
                if (!whiteKingThreatened) {
                    checkBlackPawn(x, y);
                }
                break;
            case 'P':
                if (!blackKingThreatened) {
                    checkWhitePawn(x, y);
                }
                break;
            case 'n':
                if (!whiteKingThreatened) {
                    checkBlackKnight(x, y);
                }
                break;
            case 'N':
                if (!blackKingThreatened) {
                    checkWhiteKnight(x, y);
                }
                break;
            case 'b':
                if (!whiteKingThreatened) {
                    checkBlackBishop(x, y);
                }
                break;
            case 'B':
                if (!blackKingThreatened) {
                    checkWhiteBishop(x, y);
                }
                break;
            case 'r':
                if (!whiteKingThreatened) {
                    checkBlackRook(x, y);
                }
                break;
            case 'R':
                if (!blackKingThreatened) {
                    checkWhiteRook(x, y);
                }
                break;
            case 'q':

                if (!whiteKingThreatened) {
                    checkBlackQueen(x, y);
                }
                break;
            case 'Q':
                if (!blackKingThreatened) {
                    checkWhiteQueen(x, y);
                }
                break;
            case 'k':
                if (!whiteKingThreatened) {
                    checkBlackKing(x, y);
                }
                break;
            case 'K':
                if (!blackKingThreatened) {
                    checkWhiteKing(x, y);
                }
                break;
            default:
                System.out.println("Wrong piece detected in output. (This is propably bug.)");
                break;
        }
    }

    private void checkWhitePawn(int x, int y) {

        if (x == 0) {
            return;
        }
        switch (y) {
            case 0:
                if (chessboard[x - 1][y + 1] == 'k') {
                    blackKingThreatened = true;
                }
                break;
            case 7:
                if (chessboard[x - 1][y - 1] == 'k') {
                    blackKingThreatened = true;
                }
                break;
            default:
                if (chessboard[x - 1][y - 1] == 'k' || chessboard[x - 1][y + 1] == 'k') {
                    blackKingThreatened = true;
                }
        }

    }

    private void checkWhiteKnight(int x, int y) {

        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        if (chessboard[x + 1][y + 2] == 'k' || chessboard[x + 2][y + 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x + 1][y + 2] == 'k' || chessboard[x + 2][y + 1] == 'k'
                                || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x + 2][y + 1] == 'k' || chessboard[x + 1][y - 2] == 'k'
                                || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x + 1][y - 2] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x + 1][y + 2] == 'k' || chessboard[x + 2][y + 1] == 'k'
                                || chessboard[x + 1][y - 2] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                }
                break;
            case 1:
                switch (y) {
                    case 0:
                        if (chessboard[x - 1][y + 2] == 'k' || chessboard[x + 1][y + 2] == 'k'
                                || chessboard[x + 2][y + 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 1][y + 2] == 'k' || chessboard[x + 1][y + 2] == 'k'
                                || chessboard[x + 2][y + 1] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x + 2][y + 1] == 'k' || chessboard[x + 2][y - 1] == 'k'
                                || chessboard[x - 1][y - 2] == 'k' || chessboard[x + 1][y - 2] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 1][y - 2] == 'k' || chessboard[x + 1][y - 2] == 'k'
                                || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 1][y + 2] == 'k' || chessboard[x + 1][y + 2] == 'k' || chessboard[x + 2][y + 1] == 'k'
                                || chessboard[x - 1][y - 2] == 'k' || chessboard[x + 1][y - 2] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                }
                break;
            case 6:
                switch (y) {
                    case 0:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k'
                                || chessboard[x + 1][y + 2] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k'
                                || chessboard[x + 1][y + 2] == 'k' || chessboard[x - 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 2][y - 1] == 'k'
                                || chessboard[x - 1][y - 2] == 'k' || chessboard[x + 1][y - 2] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 2][y - 1] == 'k' || chessboard[x - 1][y - 2] == 'k'
                                || chessboard[x + 1][y - 2] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k' || chessboard[x + 1][y + 2] == 'k'
                                || chessboard[x - 2][y - 1] == 'k' || chessboard[x - 1][y - 2] == 'k' || chessboard[x + 1][y - 2] == 'k') {
                            blackKingThreatened = true;
                        }
                }
                break;
            case 7:
                switch (y) {
                    case 0:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k'
                                || chessboard[x - 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 2][y - 1] == 'k'
                                || chessboard[x - 1][y - 2] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 2][y - 1] == 'k' || chessboard[x - 1][y - 2] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k'
                                || chessboard[x - 2][y - 1] == 'k' || chessboard[x - 1][y - 2] == 'k') {
                            blackKingThreatened = true;
                        }
                }
                break;
            default:
                switch (y) {
                    case 0:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k'
                                || chessboard[x + 1][y + 2] == 'k' || chessboard[x + 2][y + 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k' || chessboard[x + 1][y + 2] == 'k'
                                || chessboard[x + 2][y + 1] == 'k' || chessboard[x - 2][y - 1] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x + 2][y + 1] == 'k' || chessboard[x - 2][y - 1] == 'k'
                                || chessboard[x - 1][y - 2] == 'k' || chessboard[x + 1][y - 2] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 2][y - 1] == 'k' || chessboard[x - 1][y - 2] == 'k'
                                || chessboard[x + 1][y - 2] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 2][y + 1] == 'k' || chessboard[x - 1][y + 2] == 'k' || chessboard[x + 1][y + 2] == 'k' || chessboard[x + 2][y + 1] == 'k'
                                || chessboard[x - 2][y - 1] == 'k' || chessboard[x - 1][y - 2] == 'k' || chessboard[x + 1][y - 2] == 'k' || chessboard[x + 2][y - 1] == 'k') {
                            blackKingThreatened = true;
                        }
                }
        }
    }

    private void checkWhiteBishop(int x, int y) {
        int tempX = x;
        int tempY = y;

        while (tempX > 0 && tempY > 0) {
            tempX--;
            tempY--;

            if (chessboard[tempX][tempY] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }

        tempX = x;
        tempY = y;

        while (tempX > 0 && tempY < 7) {
            tempX--;
            tempY++;

            if (chessboard[tempX][tempY] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }

        tempX = x;
        tempY = y;

        while (tempX < 7 && tempY > 0) {
            tempX++;
            tempY--;

            if (chessboard[tempX][tempY] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }

        tempX = x;
        tempY = y;

        while (tempX < 7 && tempY < 7) {
            tempX++;
            tempY++;

            if (chessboard[tempX][tempY] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }
    }

    private void checkWhiteRook(int x, int y) {
        int tempX;
        int tempY;

        tempX = x;
        while (tempX != 0) {
            tempX--;
            if (chessboard[tempX][y] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[tempX][y] != '.') {
                break;
            }
        }

        tempX = x;
        while (tempX != 7) {
            tempX++;
            if (chessboard[tempX][y] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[tempX][y] != '.') {
                break;
            }
        }

        tempY = y;
        while (tempY != 0) {
            tempY--;
            if (chessboard[x][tempY] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[x][tempY] != '.') {
                break;
            }
        }

        tempY = y;
        while (tempY != 7) {
            tempY++;
            if (chessboard[x][tempY] == 'k') {
                blackKingThreatened = true;
                return;
            }
            if (chessboard[x][tempY] != '.') {
                break;
            }
        }

    }

    private void checkWhiteQueen(int x, int y) {
        checkWhiteRook(x, y);
        if (!blackKingThreatened) {
            checkWhiteBishop(x, y);
        }
    }

    private void checkWhiteKing(int x, int y) {
        switch (x) {
            case 0:
                switch (y) {
                    case 0: //x == 0, y == 0
                        if (chessboard[x + 1][y + 1] == 'k' || chessboard[x + 1][y] == 'k' || chessboard[x][y + 1] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7://x == 0, y == 7
                        if (chessboard[x + 1][y] == 'k' || chessboard[x + 1][y - 1] == 'k' || chessboard[x][y - 1] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    default://x == 0, y == 1-6
                        if (chessboard[x + 1][y + 1] == 'k' || chessboard[x + 1][y] == 'k' || chessboard[x][y + 1] == 'k' || chessboard[x + 1][y - 1] == 'k' || chessboard[x][y - 1] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                }
                break;
            case 7:
                switch (y) {
                    case 0://x == 7, y == 0
                        if (chessboard[x][y + 1] == 'k' || chessboard[x - 1][y + 1] == 'k' || chessboard[x - 1][y] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7://x == 7, y == 7
                        if (chessboard[x - 1][y] == 'k' || chessboard[x][y - 1] == 'k' || chessboard[x - 1][y - 1] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                            break;
                        }
                        break;
                    default://x == 7, y == 1-6
                        if (chessboard[x][y + 1] == 'k' || chessboard[x - 1][y + 1] == 'k' || chessboard[x - 1][y] == 'k' || chessboard[x][y - 1] == 'k' || chessboard[x - 1][y - 1] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                }
                break;
            default:
                switch (y) {
                    case 0://x == 1-6, y == 0
                        if (chessboard[x + 1][y + 1] == 'k' || chessboard[x + 1][y] == 'k' || chessboard[x][y + 1] == 'k'
                                || chessboard[x - 1][y + 1] == 'k' || chessboard[x - 1][y] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7://x == 1-6, y == 7
                        if (chessboard[x + 1][y] == 'k' || chessboard[x + 1][y - 1] == 'k'
                                || chessboard[x - 1][y] == 'k' || chessboard[x][y - 1] == 'k' || chessboard[x - 1][y - 1] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;

                        }
                        break;
                    default://x == 1-6, y == 1-6
                        if (chessboard[x + 1][y + 1] == 'k' || chessboard[x + 1][y] == 'k' || chessboard[x][y + 1] == 'k' || chessboard[x + 1][y - 1] == 'k'
                                || chessboard[x - 1][y + 1] == 'k' || chessboard[x - 1][y] == 'k' || chessboard[x][y - 1] == 'k' || chessboard[x - 1][y - 1] == 'k') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;

                        }
                }
                break;
        }
    }

    private void checkBlackPawn(int x, int y) {
        if (x == 7) {
            return;
        }
        switch (y) {
            case 0:
                if (chessboard[x + 1][y + 1] == 'K') {
                    whiteKingThreatened = true;
                }
                break;
            case 7:
                if (chessboard[x + 1][y - 1] == 'K') {
                    whiteKingThreatened = true;
                }
                break;
            default:
                if (chessboard[x + 1][y - 1] == 'K' || chessboard[x + 1][y + 1] == 'K') {
                    whiteKingThreatened = true;
                }
        }
    }

    private void checkBlackKnight(int x, int y) {
        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        if (chessboard[x + 1][y + 2] == 'K' || chessboard[x + 2][y + 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x + 1][y + 2] == 'K' || chessboard[x + 2][y + 1] == 'K'
                                || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x + 2][y + 1] == 'K' || chessboard[x + 1][y - 2] == 'K'
                                || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x + 1][y - 2] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x + 1][y + 2] == 'K' || chessboard[x + 2][y + 1] == 'K'
                                || chessboard[x + 1][y - 2] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                }
                break;
            case 1:
                switch (y) {
                    case 0:
                        if (chessboard[x - 1][y + 2] == 'K' || chessboard[x + 1][y + 2] == 'K'
                                || chessboard[x + 2][y + 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 1][y + 2] == 'K' || chessboard[x + 1][y + 2] == 'K'
                                || chessboard[x + 2][y + 1] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x + 2][y + 1] == 'K' || chessboard[x + 2][y - 1] == 'K'
                                || chessboard[x - 1][y - 2] == 'K' || chessboard[x + 1][y - 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 1][y - 2] == 'K' || chessboard[x + 1][y - 2] == 'K'
                                || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 1][y + 2] == 'K' || chessboard[x + 1][y + 2] == 'K' || chessboard[x + 2][y + 1] == 'K'
                                || chessboard[x - 1][y - 2] == 'K' || chessboard[x + 1][y - 2] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                }
                break;
            case 6:
                switch (y) {
                    case 0:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K'
                                || chessboard[x + 1][y + 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K'
                                || chessboard[x + 1][y + 2] == 'K' || chessboard[x - 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 2][y - 1] == 'K'
                                || chessboard[x - 1][y - 2] == 'K' || chessboard[x + 1][y - 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 2][y - 1] == 'K' || chessboard[x - 1][y - 2] == 'K'
                                || chessboard[x + 1][y - 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K' || chessboard[x + 1][y + 2] == 'K'
                                || chessboard[x - 2][y - 1] == 'K' || chessboard[x - 1][y - 2] == 'K' || chessboard[x + 1][y - 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                }
                break;
            case 7:
                switch (y) {
                    case 0:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K'
                                || chessboard[x - 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 2][y - 1] == 'K'
                                || chessboard[x - 1][y - 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 2][y - 1] == 'K' || chessboard[x - 1][y - 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K'
                                || chessboard[x - 2][y - 1] == 'K' || chessboard[x - 1][y - 2] == 'K') {
                            whiteKingThreatened = true;
                        }
                }
                break;
            default:
                switch (y) {
                    case 0:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K'
                                || chessboard[x + 1][y + 2] == 'K' || chessboard[x + 2][y + 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 1:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K' || chessboard[x + 1][y + 2] == 'K'
                                || chessboard[x + 2][y + 1] == 'K' || chessboard[x - 2][y - 1] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 6:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x + 2][y + 1] == 'K' || chessboard[x - 2][y - 1] == 'K'
                                || chessboard[x - 1][y - 2] == 'K' || chessboard[x + 1][y - 2] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7:
                        if (chessboard[x - 2][y - 1] == 'K' || chessboard[x - 1][y - 2] == 'K'
                                || chessboard[x + 1][y - 2] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                        break;
                    default:
                        if (chessboard[x - 2][y + 1] == 'K' || chessboard[x - 1][y + 2] == 'K' || chessboard[x + 1][y + 2] == 'K' || chessboard[x + 2][y + 1] == 'K'
                                || chessboard[x - 2][y - 1] == 'K' || chessboard[x - 1][y - 2] == 'K' || chessboard[x + 1][y - 2] == 'K' || chessboard[x + 2][y - 1] == 'K') {
                            whiteKingThreatened = true;
                        }
                }
        }
    }

    private void checkBlackBishop(int x, int y) {
        int tempX = x;
        int tempY = y;

        while (tempX > 0 && tempY > 0) {
            tempX--;
            tempY--;

            if (chessboard[tempX][tempY] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }

        tempX = x;
        tempY = y;

        while (tempX > 0 && tempY < 7) {
            tempX--;
            tempY++;

            if (chessboard[tempX][tempY] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }

        tempX = x;
        tempY = y;

        while (tempX < 7 && tempY > 0) {
            tempX++;
            tempY--;

            if (chessboard[tempX][tempY] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }

        tempX = x;
        tempY = y;

        while (tempX < 7 && tempY < 7) {
            tempX++;
            tempY++;

            if (chessboard[tempX][tempY] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[tempX][tempY] != '.') {
                break;
            }
        }

    }

    private void checkBlackRook(int x, int y) {
        int tempX;
        int tempY;

        tempX = x;
        while (tempX != 0) {
            tempX--;
            if (chessboard[tempX][y] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[tempX][y] != '.') {
                break;
            }
        }

        tempX = x;
        while (tempX != 7) {
            tempX++;
            if (chessboard[tempX][y] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[tempX][y] != '.') {
                break;
            }
        }

        tempY = y;
        while (tempY != 0) {
            tempY--;
            if (chessboard[x][tempY] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[x][tempY] != '.') {
                break;
            }
        }

        tempY = y;
        while (tempY != 7) {
            tempY++;
            if (chessboard[x][tempY] == 'K') {
                whiteKingThreatened = true;
                return;
            }
            if (chessboard[x][tempY] != '.') {
                break;
            }
        }
    }

    private void checkBlackQueen(int x, int y) {
        checkBlackRook(x, y);
        if (!whiteKingThreatened) {
            checkBlackBishop(x, y);
        }

    }

    private void checkBlackKing(int x, int y) {
        switch (x) {
            case 0:
                switch (y) {
                    case 0: //x == 0, y == 0
                        if (chessboard[x + 1][y + 1] == 'K' || chessboard[x + 1][y] == 'K' || chessboard[x][y + 1] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7://x == 0, y == 7
                        if (chessboard[x + 1][y] == 'K' || chessboard[x + 1][y - 1] == 'K' || chessboard[x][y - 1] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    default://x == 0, y == 1-6
                        if (chessboard[x + 1][y + 1] == 'K' || chessboard[x + 1][y] == 'K' || chessboard[x][y + 1] == 'K' || chessboard[x + 1][y - 1] == 'K' || chessboard[x][y - 1] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                }
                break;
            case 7:
                switch (y) {
                    case 0://x == 7, y == 0
                        if (chessboard[x][y + 1] == 'K' || chessboard[x - 1][y + 1] == 'K' || chessboard[x - 1][y] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7://x == 7, y == 7
                        if (chessboard[x - 1][y] == 'K' || chessboard[x][y - 1] == 'K' || chessboard[x - 1][y - 1] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                            break;
                        }
                        break;
                    default://x == 7, y == 1-6
                        if (chessboard[x][y + 1] == 'K' || chessboard[x - 1][y + 1] == 'K' || chessboard[x - 1][y] == 'K' || chessboard[x][y - 1] == 'K' || chessboard[x - 1][y - 1] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                }
                break;
            default:
                switch (y) {
                    case 0://x == 1-6, y == 0
                        if (chessboard[x + 1][y + 1] == 'K' || chessboard[x + 1][y] == 'K' || chessboard[x][y + 1] == 'K'
                                || chessboard[x - 1][y + 1] == 'K' || chessboard[x - 1][y] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;
                        }
                        break;
                    case 7://x == 1-6, y == 7
                        if (chessboard[x + 1][y] == 'K' || chessboard[x + 1][y - 1] == 'K'
                                || chessboard[x - 1][y] == 'K' || chessboard[x][y - 1] == 'K' || chessboard[x - 1][y - 1] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;

                        }
                        break;
                    default://x == 1-6, y == 1-6
                        if (chessboard[x + 1][y + 1] == 'K' || chessboard[x + 1][y] == 'K' || chessboard[x][y + 1] == 'K' || chessboard[x + 1][y - 1] == 'K'
                                || chessboard[x - 1][y + 1] == 'K' || chessboard[x - 1][y] == 'K' || chessboard[x][y - 1] == 'K' || chessboard[x - 1][y - 1] == 'K') {
                            blackKingThreatened = true;
                            whiteKingThreatened = true;

                        }
                }
                break;
        }

    }

    public void addLine(String line) {
        if (this.actualLineNumber >= 8) {
            System.out.println("Max line number exceeded.");
            return;
        }

        if (line.length() != 8) {
            System.out.println("Input line has wrong lenght.");
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!addChar(line.charAt(i), i)) {
                return;
            }
        }

        this.actualLineNumber++;

    }

    private boolean addChar(char piece, int position) {
        if (piece == '.') {
            insert(piece, position);
            return true;
        }

        if (!PieceType.contains(piece)) {
            System.out.println("Unexpected character detected. L:" + this.actualLineNumber + 1 + " C:" + position + 1);
            return false;
        }

        if (this.pieceSet.checkPiece(piece)) {
            this.pieceSet.addPiece(piece);
            insert(piece, position);
            return true;
        } else {
            System.out.println("Exceeded maximum number of this pieces. L:" + this.actualLineNumber + 1 + " C:" + position + 1);
            return false;
        }
    }

    private void insert(char piece, int position) {
        this.chessboard[actualLineNumber][position] = piece;
    }

    public int getActualLineNumber() {
        return actualLineNumber;
    }

}
