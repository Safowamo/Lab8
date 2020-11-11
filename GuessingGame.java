import java.awt.*;
import java.awt.event.*;
import javax.swing. *;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JFrame frame;
  JTextField userGuessText;
  private Random r;
  int randomNum;

  JButton guessButton;
  JButton playAgainButton;
  JLabel enterGuessLabel;
  JLabel highOrLowGuessLabel;
  JLabel lastGuessLabel;
  // generate a number in the interval [1 - 100]
  GuessingGame(){
    r = new Random();
    randomNum = r.nextInt(100)+1;

    frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());

    frame.setSize(240, 120);

    userGuessText = new JTextField(10);
    userGuessText.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");
    userGuessText.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    enterGuessLabel = new JLabel("Enter your guess: ");
    highOrLowGuessLabel = new JLabel();
    lastGuessLabel = new JLabel();

    frame.add(enterGuessLabel);
    frame.add(userGuessText);
    frame.add(guessButton);
    frame.add(highOrLowGuessLabel);
    frame.add(lastGuessLabel);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    String command = ae.getActionCommand();
    if(command.equals("Guess")){
      int guess = Integer.parseInt(userGuessText.getText());
      if(guess < randomNum) {
          highOrLowGuessLabel.setText("Too Low!");
      } else if (guess > randomNum) {
          highOrLowGuessLabel.setText("Too high!");
      } else if(guess == randomNum){
       highOrLowGuessLabel.setText("You got it!");
      }
      lastGuessLabel.setText("Last guess was " + guess);
    } else if(command.equals("Play Again")){
        randomNum = r.nextInt(100)+1;
        enterGuessLabel.setText("Enter your guess: ");
        highOrLowGuessLabel.setText("");
        lastGuessLabel.setText("");
        userGuessText.setText("");
    } else {
      highOrLowGuessLabel.setText("You pressed Enter. Please press the Guess Button.");
    }
  }
}