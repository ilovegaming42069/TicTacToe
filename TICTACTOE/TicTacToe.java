package TICTACTOE;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1;


    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(50, 50 ,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        text_field.setBackground(new Color(25, 25, 25));
        text_field.setForeground(new Color(25, 255, 0));
        text_field.setFont(new Font("Ink Free", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(10, 10, 700, 100);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            button_panel.add(buttons[i]);

        }
        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        turn();
    }
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 9; i++){
            if(e.getSource()==buttons[i]){
                if(player1){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1 = false;
                        text_field.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1 = true;
                        text_field.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    public void turn(){
        if (random.nextInt(2) == 0){
            player1 = true;
            text_field.setText("X Turn");
        }
        else{
            player1 = false;
            text_field.setText("O Turn");
        }
    }
    public void check(){
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))){
            xWins(0, 1, 2);
        }
        else if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))){
            xWins(3, 4, 5);
        }
        else if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWins(6, 7, 8);
        }
        else if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))){
            xWins(0, 3, 6);
        }
        else if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))){
            xWins(1, 4, 7);
        }
        else if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWins(2, 5, 8);
        }
        else if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWins(0, 4, 8);
        }
        else if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))){
            xWins(2, 4, 6);
        }
        else if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))){
            oWins(0, 1, 2);
        }
        else if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))){
            oWins(3, 4, 5);
        }
        else if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))){
            oWins(6, 7, 8);
        }
        else if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))){
            oWins(0, 3, 6);
        }
        else if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))){
            oWins(1, 4, 7);
        }
        else if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))){
            oWins(2, 5, 8);
        }
        else if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))){
            oWins(0, 4, 8);
        }
        else if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))){
            oWins(2, 4, 6);
        }
        else if (isTie()){
            for (int i=0; i<9; i++){
                buttons[i].setEnabled(false);
            }
            text_field.setText("Draw!!");
        }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("X Win!!");
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Win!!");
    }

    public boolean isTie(){
        for (int i = 0; i < 9; i++){
            if (buttons[i].getText().equals("")){
                return false;
            }
        }
        return true;
    }
}

