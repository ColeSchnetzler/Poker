import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class PlayerLabel extends GLabel
{
  private String name;
  private int myMoney;
  private double myX;
  private double myY;
  
  public PlayerLabel(String s, double x, double y, int money)
  {
    super(s, x, y);
    myX = x;
    myY = y;
    myMoney = money;
  }
   public int getMoney()
   {
     return myMoney;
   }
  
  
}
