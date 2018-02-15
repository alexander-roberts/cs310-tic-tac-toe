package edu.jsu.mcis;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener {

    private TicTacToeModel model;
	private JButton[][] squares;
	private JPanel squaresPanel;
	private JLabel resultLabel;
	
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
		squares = new JButton[model.getWidth()][model.getWidth()];
		squaresPanel = new JPanel(new GridLayout(model.getWidth(),model.getWidth()));
		// loop through every row and col
		for(int row=0;row<model.getWidth();row++){
			for(int col=0;col<model.getWidth();col++){
				squares[row][col] = new JButton();
				squares[row][col].addActionListener(this);
				squares[row][col].setName("Square" + row + col);
				squares[row][col].setPreferredSize(new Dimension(64, 64));
				squares[row][col].setText(" ");
				squaresPanel.add(squares[row][col]);
			}
		}
		
		resultLabel = new JLabel();
		resultLabel.setName("ResultLabel");

        add(squaresPanel);
		add(resultLabel);
    }
	
	public void actionPerformed(ActionEvent e){
		
		String button = ((JButton)e.getSource()).getName();
		System.out.println(button);
		model.makeMark(button.charAt(6),button.charAt(7));
		resultLabel.setText(button);
		
	}
	
    public void viewModel() {
        
		for(int i=0;i<model.getWidth();i++){ //traverse view and update buttons
			for(int j=0;j<model.getWidth();j++) {
				if(model.getMark(i,j) == TicTacToeModel.Mark.EMPTY) {
				squares[i][j].setText("-"); }
				else {
				squares[i][j].setText(model.getMark(i,j).toString());
				}
			}
		}
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
		String s = "";
		
		s+="Player ";
		if(model.isXTurn())
			s+="1 (X) ";
		else
			s+="2 (O) ";
		s+="Move:\nEnter the row and column numbers, separated by a space:";
		
		resultLabel.setText(s);
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        resultLabel.setText("\nThere was a problem with your input. Please try again.");

    }

    public void showResult(String r) {

        /* Display final winner */

        resultLabel.setText(r + "!");

    }
	
	
	
}