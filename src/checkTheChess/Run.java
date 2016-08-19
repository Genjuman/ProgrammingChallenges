/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkTheChess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Libor
 */
public class Run {
    public static void main(String[] args) throws IOException {
        Chessboard chessboard = new Chessboard();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        while (true) {            
            input = br.readLine();
            if ("quit".equals(input.toLowerCase())) {
                break;
            }
            
            chessboard.addLine(input);
            if (chessboard.getActualLineNumber()==8) {
                chessboard.evaluate();
            }
        }
    }
}
