import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import acm.gui.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component.*;

public class PokerTable extends GraphicsProgram
{
  private GRect myTable;
  private GOval[] mySeats;
  private PlayerLabel[] myPlayerLabels;
  private GLabel[] mySeatLabel;
  private PlayerLabel myPlayer1;
  private PlayerLabel myPlayer2;
  private PlayerLabel myPlayer3;
  private PlayerLabel myPlayer4;
  private PlayerLabel myPlayer5;
  private PlayerLabel myPlayer6;
  private PlayerLabel myPlayer7;
  private FoldButton myFoldButton;
  private CheckButton myCheckButton;
  private BetButton myBetButton;
  private BetTextField myBetTextField;
  private Card[] myCards;
  private JPanel myButtonPanel;
  private Card myPlayerCard1;
  private Card myPlayerCard2;
  private int myPlayerInt1;
  private int myPlayerInt2;
  private PlayerLabel[] myPlayerActionLabels;
  private PlayerLabel myPlayerAction1;
  private PlayerLabel myPlayerAction2;
  private PlayerLabel myPlayerAction3;
  private PlayerLabel myPlayerAction4;
  private PlayerLabel myPlayerAction5;
  private PlayerLabel myPlayerAction6;
  private PlayerLabel myPlayerAction7;
  private PlayerLabel myPot;
  private Card myMiddleCard1;
  private Card myMiddleCard2;
  private Card myMiddleCard3;
  private Card myMiddleCard4;
  private Card myMiddleCard5;
  private int myMiddleInt1;
  private int myMiddleInt2;
  private int myMiddleInt3;
  private int myMiddleInt4;
  private int myMiddleInt5;
  
  
  public void init()
  {
    
    myFoldButton = new FoldButton("Fold");
    myFoldButton.setButtonSize(30, 10);
    add(myFoldButton, SOUTH);
    
    myCheckButton = new CheckButton("Check");
    myCheckButton.setButtonSize(30, 10);
    add(myCheckButton, SOUTH);
    
    myBetButton = new BetButton("Bet");
    myBetButton.setButtonSize(30, 10);
    add(myBetButton, SOUTH);
    
    myBetTextField = new BetTextField("\t");
    myBetTextField.setTextFieldSize(30, 10);
    add(myBetTextField, SOUTH);
    
    
    myPot = new PlayerLabel("Pot: ", 350, 95, 100000); 
    
    //making the seats
    myTable = new GRect(90, 50, 550, 300);
    mySeats = new GOval[7];
    mySeats[0] = new GOval(55, 100, 25, 25);
    mySeats[1] = new GOval(55, 275, 25, 25);
    mySeats[2] = new GOval(140, 360, 25, 25);
    mySeats[3] = new GOval(340, 360, 25, 25);
    mySeats[4] = new GOval(550, 360, 25, 25);
    mySeats[5] = new GOval(650, 100, 25, 25);
    mySeats[6] = new GOval(650, 275, 25, 25);
    
    //setting values of player labels
    myPlayerLabels = new PlayerLabel[7];
    myPlayerLabels[0] = new PlayerLabel("Spot Empty", 20, 95, 100000);
    myPlayerLabels[1] = new PlayerLabel("Spot Empty", 20, 270, 100000);
    myPlayerLabels[2] = new PlayerLabel("Spot Empty", 130, 400, 100000);
    myPlayerLabels[3] = new PlayerLabel("You: " + "$", 330, 400, 100000);
    myPlayerLabels[4] = new PlayerLabel("Spot Empty", 540, 400, 100000);
    myPlayerLabels[5] = new PlayerLabel("Spot Empty", 677.5, 115, 100000);
    myPlayerLabels[6] = new PlayerLabel("Spot Empty", 677.5, 290, 100000);
    
    //setting values of player action labels
    myPlayerActionLabels = new PlayerLabel[7];
    myPlayerActionLabels[0] = new PlayerLabel("", 20, 95, 100000);
    myPlayerActionLabels[1] = new PlayerLabel("", 20, 270, 100000);
    myPlayerActionLabels[2] = new PlayerLabel("", 130, 400, 100000);
    myPlayerActionLabels[3] = new PlayerLabel("Cost to Call :", 330, 320, 100000);
    myPlayerActionLabels[4] = new PlayerLabel("", 540, 400, 100000);
    myPlayerActionLabels[5] = new PlayerLabel("", 677.5, 115, 100000);
    myPlayerActionLabels[6] = new PlayerLabel("", 677.5, 290, 100000);
    
    myCards = new Card[52];
    myCards = setDeck();
    
    //adding player's first card
    myPlayerInt1 = (int)(Math.random() * 52);
    myPlayerCard1 = new Card(myCards[myPlayerInt1].getString(), 325, 340);
    if (myCards[myPlayerInt1].isUsed() == true)
    {
      myPlayerInt1 = (int)(Math.random() * 52);
      myPlayerCard1 = new Card(myCards[myPlayerInt1].getString(), 325, 340);
    }
    myCards[myPlayerInt1].cardUsed();
   
    //adding player's second card
    myPlayerInt2 = (int)(Math.random() * 52);
    myPlayerCard2 = new Card(myCards[myPlayerInt2].getString(), 365, 340);
    if (myCards[myPlayerInt2].isUsed() == true)
    {
      myPlayerInt2 = (int)(Math.random() * 52);
      myPlayerCard2 = new Card(myCards[myPlayerInt2].getString(), 365, 340);
    }
    myCards[myPlayerInt2].cardUsed();
    
    //setting players first card to red if hearts or diamonds
    if (myPlayerInt1 == 13 || myPlayerInt1 == 14 || myPlayerInt1 == 15 || myPlayerInt1 == 16 || myPlayerInt1 == 17
           || myPlayerInt1 == 18 || myPlayerInt1 == 19 || myPlayerInt1 == 20 || myPlayerInt1 == 21 || myPlayerInt1 == 22 
           || myPlayerInt1 == 23 || myPlayerInt1 == 24 || myPlayerInt1 == 25 || myPlayerInt1 == 39 || myPlayerInt1 == 40
           || myPlayerInt1 == 41 || myPlayerInt1 == 42 || myPlayerInt1 == 43 || myPlayerInt1 == 44 || myPlayerInt1 == 45
           || myPlayerInt1 == 46 || myPlayerInt1 == 47 || myPlayerInt1 == 48 || myPlayerInt1 == 49 || myPlayerInt1 == 50
           || myPlayerInt1 == 51)
    {
      myPlayerCard1.setColor(Color.RED);
    }
    
    //setting players second card to red if hearts or diamonds
    if (myPlayerInt2 == 13 || myPlayerInt2 == 14 || myPlayerInt2 == 15 || myPlayerInt2 == 16 || myPlayerInt2 == 17
           || myPlayerInt2 == 18 || myPlayerInt2 == 19 || myPlayerInt2 == 20 || myPlayerInt2 == 21 || myPlayerInt2 == 22 
           || myPlayerInt2 == 23 || myPlayerInt2 == 24 || myPlayerInt2 == 25 || myPlayerInt2 == 39 || myPlayerInt2 == 40
           || myPlayerInt2 == 41 || myPlayerInt2 == 42 || myPlayerInt2 == 43 || myPlayerInt2 == 44 || myPlayerInt2 == 45
           || myPlayerInt2 == 46 || myPlayerInt2 == 47 || myPlayerInt2 == 48 || myPlayerInt2 == 49 || myPlayerInt2 == 50
           || myPlayerInt2 == 51)
    {
      myPlayerCard2.setColor(Color.RED);
    }
    add(myPlayerCard1);
    add(myPlayerCard2);
    
    
    // adding cards on table
    myMiddleInt1 = (int)(Math.random() * 52);
    myMiddleCard1 = new Card(myCards[myMiddleInt1].getString(), 280, 200);
    if (myCards[myMiddleInt1].isUsed() == true)
    {
      myMiddleInt1 = (int)(Math.random() * 52);
      myMiddleCard1 = new Card(myCards[myMiddleInt1].getString(), 280, 200);
    }
    myCards[myMiddleInt1].cardUsed();
    add(myMiddleCard1);
    
    myMiddleInt2 = (int)(Math.random() * 52);
    myMiddleCard2 = new Card(myCards[myMiddleInt2].getString(), 320, 200);
    if (myCards[myMiddleInt2].isUsed() == true)
    {
      myMiddleInt2 = (int)(Math.random() * 52);
      myMiddleCard2 = new Card(myCards[myMiddleInt2].getString(), 320, 200);
    }
    myCards[myMiddleInt2].cardUsed();
    add(myMiddleCard2);
    
    myMiddleInt3 = (int)(Math.random() * 52);
    myMiddleCard3 = new Card(myCards[myMiddleInt3].getString(), 360, 200);
    if (myCards[myMiddleInt3].isUsed() == true)
    {
      myMiddleInt3 = (int)(Math.random() * 52);
      myMiddleCard3 = new Card(myCards[myMiddleInt3].getString(), 360, 200);
    }
    myCards[myMiddleInt3].cardUsed();
    add(myMiddleCard3);
    
    myMiddleInt4 = (int)(Math.random() * 52);
    myMiddleCard4 = new Card(myCards[myMiddleInt4].getString(), 400, 200);
    if (myCards[myMiddleInt4].isUsed() == true)
    {
      myMiddleInt4 = (int)(Math.random() * 52);
      myMiddleCard4 = new Card(myCards[myMiddleInt4].getString(), 400, 200);
    }
    myCards[myMiddleInt4].cardUsed();
    add(myMiddleCard4);
    
    myMiddleInt5 = (int)(Math.random() * 52);
    myMiddleCard5 = new Card(myCards[myMiddleInt5].getString(), 440, 200);
    if (myCards[myMiddleInt5].isUsed() == true)
    {
      myMiddleInt5 = (int)(Math.random() * 52);
      myMiddleCard5 = new Card(myCards[myMiddleInt5].getString(), 440, 200);
    }
    myCards[myMiddleInt5].cardUsed();
    add(myMiddleCard5);
    
    //making crads invisible intially 
    myMiddleCard1.setVisible(false);
    myMiddleCard2.setVisible(false);
    myMiddleCard3.setVisible(false);
    myMiddleCard4.setVisible(false);
    myMiddleCard5.setVisible(false);
    
    //adding player action label
    myPlayerAction4 = myPlayerActionLabels[3];
  
    
    myPlayer1 = myPlayerLabels[0];
    myPlayer2 = myPlayerLabels[1];
    myPlayer3 = myPlayerLabels[2];
    myPlayer4 = myPlayerLabels[3];
    myPlayer5 = myPlayerLabels[4];
    myPlayer6 = myPlayerLabels[5];
    myPlayer7 = myPlayerLabels[6];
    
    //adding player labels
    for (int k = 0; k < 7; k ++)
    {
      add(myPlayerLabels[k]);
      add(mySeats[k]);
    }
    add(myTable);
    add(myPlayerAction4);
    add(myPot);
    
    
    
    myPlayer4.setLabel("You: " + "$" + myPlayer4.getMoney());
  }
  
  public void run()
  {
    
  }
  
  public PlayerLabel getMyPlayer(int x)
  {
    return myPlayerLabels[x];
  }
  
  //add cards to deck
  public Card[] setDeck()
  {
    Card[] cards;
    cards = new Card[52];
    
    int spades = 2;
    cards[0] = new Card("A S", 0, 0);
    for (int k = 1; k < 10; k ++)
    {
      cards[k] = new Card(spades + " S", 0, 0);
      spades ++;
    }
    cards[10] = new Card("J S", 0, 0);
    cards[11] = new Card("Q S", 0, 0);
    cards[12] = new Card("K S", 0, 0);
    
    int hearts = 2;
    cards[13] = new Card("A H", 0, 0);
    cards[13].setColor(Color.RED);
    for (int k = 14; k < 23; k ++)
    {
      cards[k] = new Card(hearts + " H", 0, 0);
      hearts ++;
      cards[k].setColor(Color.RED);
    }
    cards[23] = new Card("J H", 0, 0);
    cards[23].setColor(Color.RED);
    cards[24] = new Card("Q H", 0, 0);
    cards[24].setColor(Color.RED);
    cards[25] = new Card("K H", 0, 0);
    cards[25].setColor(Color.RED);
    
    int clubs = 2;
    cards[26] = new Card("A C", 0, 0);
    for (int k = 27; k < 36; k ++)
    {
      cards[k] = new Card(clubs + " C", 0, 0);
      clubs ++;
    }
    cards[36] = new Card("J C", 0, 0);
    cards[37] = new Card("Q C", 0, 0);
    cards[38] = new Card("K C", 0, 0);
    
    int diamonds = 2;
    cards[39] = new Card("A D", 0, 0);
    cards[39].setColor(Color.RED);
    for (int k = 40; k < 49; k ++)
    {
      cards[k] = new Card(diamonds + " D", 0, 0);
      diamonds ++;
      cards[k].setColor(Color.RED);
    }
    cards[49] = new Card("J D", 0, 0);
    cards[49].setColor(Color.RED);
    cards[50] = new Card("Q D", 0, 0);
    cards[50].setColor(Color.RED);
    cards[51] = new Card("K D", 0, 0);
    cards[51].setColor(Color.RED);
      
    return cards;
  } 
}
