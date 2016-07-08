import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class Card extends GLabel
{
  private int myValue;
  private int mySuit;
  private String myName;
  private boolean myCardIsUsed = false;
  
  public Card(String s, double x, double y)
  {
    super(s, x, y);
    myName = s;
    
  }
  
  public String getString()
  {
    return myName;
  }
  
  public boolean isUsed()
  {
    return myCardIsUsed;
  }
  
  public void cardUsed()
  {
    myCardIsUsed = true;
  }
  
  
}
