# Tic-Tac-Toe Game
This is a simple Tic Tac Toe game implemented in Java using Java Swing. The game allows two players to take turns marking X and O on a 3x3 grid. It utilizes packages such as java.swing, java.awt and java.awt.event for graphical user interface components and event handling.
# How to play
- Run the game application through main.java.
- The game board will be displayed as a 3x3 grid of buttons.
- Player 1 starts the game by clicking on an empty button on the grid. The button will be marked with an X.
- Player 2 then takes their turn by clicking on another empty button. The button will be marked with an O.
- Players continue taking turns until one player wins or the game ends in a draw.
- The game will display a message indicating the current turn (X or O) and the outcome.

# ActionListener Implementation
- The actionPerformed(ActionEvent e) method is implemented to handle button clicks. It iterates through all the buttons in the game and checks if the source of the event (e.getSource()) matches the current button being iterated. The logic then proceeds based on the value of player1_turn.
- If it is Player 1's turn (player1_turn is true), and the clicked button is empty, the button's text is set to "X" and displayed in red color. The turn is then switched to Player 2 (player1_turn is set to false) and the text field is updated accordingly. The check() method is called to verify if the move resulted in a win.
- If it is Player 2's turn (player1_turn is false), and the clicked button is empty, the button's text is set to "O" and displayed in blue color. The turn is switched back to Player 1 (player1_turn is set to true) and the text field is updated. The check() method is called to check for a win.

Note that this is a basic implementation of TicTacToe, and there may be additional features or enhancements that can be added to make the game more interactive or visually appealing. Feel free to customize and expand upon this project according to your preferences and requirements.
