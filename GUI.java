import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GUI implements MouseListener, ActionListener
{
  JFrame homeFrame;
  final String[] maps = {"ASCENT", "BREEZE", "FRACTURE", "HAVEN", "PEARL", "BIND", "ICEBOX"};
  final JComboBox<String> cb = new JComboBox<String>(maps);

  private String[] imgList = {"ASCENT_BRIMSTONE","ASCENT_SOVA","ASCENT_VIPER",
          "BIND_BRIMSTONE","BIND_SOVA","BIND_VIPER",
          "BREEZE_BRIMSTONE","BREEZE_SOVA","BREEZE_VIPER",
          "FRACTURE_BRIMSTONE","FRACTURE_SOVA","FRACTURE_VIPER",
          "HAVEN_BRIMSTONE","HAVEN_SOVA","HAVEN_VIPER",
          "ICEBOX_BRIMSTONE","ICEBOX_SOVA","ICEBOX_VIPER",
          "PEARL_BRIMSTONE","PEARL_SOVA","PEARL_VIPER"};
  
  public void setup()
  {
    homeFrame = new JFrame("VALORANT LINEUPS");
    homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    homeFrame.setSize(500, 200);
    center(homeFrame);
    homeFrame.setVisible(true);
    
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    homeFrame.add(panel);

    JLabel lbl = new JLabel("Select a map and click SELECT");
    lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(lbl);

    cb.setMaximumSize(cb.getPreferredSize());
    cb.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(cb);

    JButton btn = new JButton("SELECT");
    btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(btn);
    btn.addActionListener(this);

    homeFrame.setVisible(true); 
  }
  public static void center(JFrame frame)
  {
    // get the size of the screen, on systems with multiple displays,
    // the primary display is used
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    // calculate the new location of the window
    int w = frame.getSize().width;
    int h = frame.getSize().height;

    int x = (dim.width - w) / 2;
    int y = (dim.height - h) / 2;

    // moves this component to a new location, the top-left corner of
    // the new location is specified by the x and y
    // parameters in the coordinate space of this component's parent
    frame.setLocation(x, y);
  }
  public static void location(JFrame frame)
  {
    // get the size of the screen, on systems with multiple displays,
    // the primary display is used
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    // calculate the new location of the window
    int w = frame.getSize().width;
    int h = frame.getSize().height;

    int x = (dim.width - w) / 2;
    int y = (dim.height - h);

    // moves this component to a new location, the top-left corner of
    // the new location is specified by the x and y
    // parameters in the coordinate space of this component's parent
    frame.setLocation(x, y);
  }
  public void mouseClicked(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
      
  }

  public void mouseReleased(MouseEvent e) {
      
  }

  public void mouseEntered(MouseEvent e) {
      
  }

  public void mouseExited(MouseEvent e) {
      
  }
  public void actionPerformed(ActionEvent e) 
  {
    System.out.println(homeFrame.getX());
    String text = cb.getSelectedItem().toString();
    Map map = new Map(imgList, text);
    map.setVisible(true);
  }
}