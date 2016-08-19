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
public enum PieceType {
    p('p'),
    P('P'), 
    n('n'), 
    N('N'), 
    b('b'), 
    B('B'), 
    r('r'), 
    R('R'), 
    q('q'), 
    Q('Q'), 
    k('k'), 
    K('K');

    private final char value;

    private PieceType(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

    public static boolean contains(char value) {

        for (PieceType c : PieceType.values()) {
            if (c.getValue()==value) {
                return true;
            }
        }

        return false;
    }
}
