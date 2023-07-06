import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class TicTacToe implements ActionListener{


    Random random = new Random(); // To randomly generate player turn
    JFrame frame = new JFrame(); // To create an application window
    JPanel title_panel = new JPanel(); // Panel to hold title of the game
    JPanel button_panel = new JPanel(); // Panel to hold all the buttons
    JLabel textField = new JLabel(); // Serves to display a text field
    JButton[] buttons = new JButton[9];
    boolean player1_turn; // True if its is player 1's turn

    /***
     *
     */
    TicTacToe(){

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout()); //sets components in the frame in north, south, east, west and center


        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0)); // text color
        textField.setFont(new Font("DejaVu Sans", Font.ITALIC, 65));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150, 150, 150));

        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("DejaVu Sans", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this); // action listener added to each of the buttons
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    /***
     * everytime a button is clicked this method will check which button it was by
     * going through each indexed button and then a .setText method is applied to display
     * either X or O on the button. other actions such as changing the text of the title panel is also done.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < 9; i++)
        {
            // checks if the source of the actionPerformed is the button of the current index
            if(e.getSource()==buttons[i])
            {
                /*
                if-else block executes based on player1_turn
                 */
                if(player1_turn)
                {
                    if(buttons[i].getText() == "") //block executes when the button has no text on it
                    {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X"); //sets the text on the button
                        player1_turn = false; // setting this false so that the next button clicked will be marked O
                        textField.setText("O turn");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    /***
     * Randomly determines player turn and also pauses thread execution for 2 seconds to
     * display the title of the game, 'tic-tac-toe', before showing which player's turn it is.
     */
    public void firstTurn()
    {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        /* if an InterruptedException is caught it is wrapped in a
        RuntimeException and thrown. this allows the exception to propagate up the call stack
         */

        if(random.nextInt(2) == 0)
        {
            player1_turn = true;
            textField.setText("X turn");
        }
        else
        {
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    /**
     * Checks if there are any winning conditions. Then calls the respective
     * 'xWins/oWins', method of the winner.
     */
    public void check() {
        //checks winning conditions for X
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X"))
        {
            xWins(3, 4, 5);
        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X"))
        {
            xWins(6, 7, 8);
        }
            if(
                    (buttons[0].getText()=="X") &&
                            (buttons[3].getText()=="X") &&
                            (buttons[6].getText()=="X"))
            {
                xWins(0, 3, 6);
            }
                if(
                        (buttons[1].getText()=="X") &&
                                (buttons[4].getText()=="X") &&
                                (buttons[7].getText()=="X"))
                {
                    xWins(1, 4, 7);
                }
                    if(
                            (buttons[2].getText()=="X") &&
                                    (buttons[5].getText()=="X") &&
                                    (buttons[8].getText()=="X"))
                    {
                        xWins(2, 5, 8);
                    }
                        if(
                                (buttons[0].getText()=="X") &&
                                        (buttons[4].getText()=="X") &&
                                        (buttons[8].getText()=="X"))
                        {
                            xWins(0, 4, 8);
                        }
                            if (
                                    (buttons[2].getText() == "X") &&
                                            (buttons[4].getText() == "X") &&
                                            (buttons[6].getText() == "X")) {
                                xWins(2, 4, 6);
                            }

        // Checks winning conditions for O
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O"))
        {
            oWins(3, 4, 5);
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O"))
        {
            oWins(6, 7, 8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O"))
        {
            oWins(0, 3, 6);
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O"))
        {
            oWins(1, 4, 7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O"))
        {
            oWins(2, 5, 8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O"))
        {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
    }


    /***
     * Colors the winning buttons green. gets the winning buttons combination from 'check' method.
     * Parameters are the button indexes.
     * @param a
     * @param b
     * @param c
     */
    public void xWins ( int a, int b, int c) {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);

        // disabling all buttons so the remaining buttons can't be clicked after someone wins.
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            textField.setText("X wins");
        }

    public void oWins ( int a, int b, int c)
        {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);

            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            textField.setText("O wins");
        }
    }
