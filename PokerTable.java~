import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import acm.gui.*;
import java.awt.event.*;
import javax.swing.*;

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
  private Card[] myCards;
  private JPanel myButtonPanel;
  private Card myPlayerCard1;
  private Card myPlayerCard2;
  private int myPlayerInt1;
  private int myPlayerInt2;
  
  
  public void init()
  {
    
    setLayout(new TableLayout(1, 4));
    //add(new FoldButton("Fold", 100, 100), "gridwidth=2");
    //add (new FoldButton("Fold", 100, 100), "gridwidth=2");
    
    
    myTable = new GRect(90, 50, 550, 300);
    mySeats = new GOval[7];
    mySeats[0] = new GOval(55, 100, 25, 25);
    mySeats[1] = new GOval(55, 275, 25, 25);
    mySeats[2] = new GOval(140, 360, 25, 25);
    mySeats[3] = new GOval(340, 360, 25, 25);
    mySeats[4] = new GOval(550, 360, 25, 25);
    mySeats[5] = new GOval(650, 100, 25, 25);
    mySeats[6] = new GOval(650, 275, 25, 25);
    
    myPlayerLabels = new PlayerLabel[7];
    myPlayerLabels[0] = new PlayerLabel("Spot Empty", 20, 95, 100000);
    myPlayerLabels[1] = new PlayerLabel("Spot Empty", 20, 270, 100000);
    myPlayerLabels[2] = new PlayerLabel("Spot Empty", 130, 400, 100000);
    myPlayerLabels[3] = new PlayerLabel("You: " + "$", 330, 400, 100000);
    myPlayerLabels[4] = new PlayerLabel("Spot Empty", 540, 400, 100000);
    myPlayerLabels[5] = new PlayerLabel("Spot Empty", 677.5, 115, 100000);
    myPlayerLabels[6] = new PlayerLabel("Spot Empty", 677.5, 290, 100000);
    
    myCards = new Card[52];
    myCards = setDeck();
    
    myPlayerInt1 = (int)(Math.random() * 52);
    myPlayerCard1 = new Card(myCards[myPlayerInt1].getString(), 325, 340);
    if (myCards[myPlayerInt1].isUsed() == true)
    {
      myPlayerInt1 = (int)(Math.random() * 52);
      myPlayerCard1 = new Card(myCards[myPlayerInt1].getString(), 325, 340);
    }
    myCards[myPlayerInt1].cardUsed();
    
    myPlayerInt2 = (int)(Math.random() * 52);
    myPlayerCard2 = new Card(myCards[myPlayerInt2].getString(), 365, 340);
    if (myCards[myPlayerInt2].isUsed() == true)
    {
      myPlayerInt2 = (int)(Math.random() * 52);
      myPlayerCard2 = new Card(myCards[myPlayerInt2].getString(), 365, 340);
    }
    myCards[myPlayerInt2].cardUsed();
    
    if (myPlayerInt1 == 13 || myPlayerInt1 == 14 || myPlayerInt1 == 15 || myPlayerInt1 == 16 || myPlayerInt1 == 17
           || myPlayerInt1 == 18 || myPlayerInt1 == 19 || myPlayerInt1 == 20 || myPlayerInt1 == 21 || myPlayerInt1 == 22 
           || myPlayerInt1 == 23 || myPlayerInt1 == 24 || myPlayerInt1 == 25 || myPlayerInt1 == 39 || myPlayerInt1 == 40
           || myPlayerInt1 == 41 || myPlayerInt1 == 42 || myPlayerInt1 == 43 || myPlayerInt1 == 44 || myPlayerInt1 == 45
           || myPlayerInt1 == 46 || myPlayerInt1 == 47 || myPlayerInt1 == 48 || myPlayerInt1 == 49 || myPlayerInt1 == 50
           || myPlayerInt1 == 51)
    {
      myPlayerCard1.setColor(Color.RED);
    }
    
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
    
    
    
    myFoldButton = new FoldButton("Fold", 100, 100);
    myFoldButton.setSize(50, 5);
    
    
    
    
    for (int k = 0; k < 7; k ++)
    {
      add(myPlayerLabels[k]);
      add(mySeats[k]);
    }
    add(myTable);
    
    myPlayer1 = myPlayerLabels[0];
    myPlayer2 = myPlayerLabels[1];
    myPlayer3 = myPlayerLabels[2];
    myPlayer4 = myPlayerLabels[3];
    myPlayer5 = myPlayerLabels[4];
    myPlayer6 = myPlayerLabels[5];
    myPlayer7 = myPlayerLabels[6];
  }
  
  public void run()
  {
    myPlayer4.setLabel("You: " + "$" + myPlayer4.getMoney());
  }
  
  public PlayerLabel getMyPlayer(int x)
  {
    return myPlayerLabels[x];
  }
  
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
