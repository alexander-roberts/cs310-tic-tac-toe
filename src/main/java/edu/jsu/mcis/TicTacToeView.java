package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        System.out.print("\n  012\n\n");
		for(int i=0;i<model.getWidth();i++){
			System.out.print(i+ " ");
			for(int j=0;j<model.getWidth();j++)
				if(model.getMark(i,j) == TicTacToeModel.Mark.EMPTY)
					System.out.print("-");
				else
					System.out.print(model.getMark(i,j).toString());
			System.out.print("\n");
		}
		System.out.print("\n\n\n");
		
		//"\n  012\n\n0 ---\n1 ---\n2 ---\n\n\n\n"
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
		
		System.out.print("Player ");
		if(model.isXTurn())
			System.out.print("1 (X) ");
		else
			System.out.print("2 (O) ");
		System.out.print("Move:\nEnter the row and column numbers, separated by a space:");

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("\nThere was a problem with your input. Please try again.");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}