import java.awt.*;
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import acm.gui.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component.*;

public class BetTextField extends JTextField
{
  
  public BetTextField(String s)
  {
    super(s);
  }
  
  public void setTextFieldSize(int width, int height)
  {
    setSize(width, height);
  }
  
}
