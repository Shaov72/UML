import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Map extends JFrame implements ActionListener
{
    private JPanel container;
    private JScrollPane jsp;
    private final String mapName;
    private final String[] imgList;
    public Map(String[] imgList, String mapName)
    {
        this.imgList = imgList;
        this.mapName = mapName;
        setTitle(mapName);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1600, 1000);
        GUI.center(this);
        setLayout(null);
        setVisible(false);

        JButton sova = new JButton("SOVA");
        sova.addActionListener(this);
        JButton brim = new JButton("BRIMSTONE");
        brim.addActionListener(this);
        JButton viper = new JButton("VIPER");
        viper.addActionListener(this);

        JPanel btns = new JPanel();
        btns.add(sova);
        btns.add(brim);
        btns.add(viper);
        btns.setBounds(0,0,1600,35);
        btns.setBackground(Color.black);


        add(btns);

        container = new JPanel();
        jsp = new JScrollPane(container);
        this.add(jsp);
    }

    public void addImages(String agentName)
    {
        this.remove(jsp);
        for (String s : imgList) {
            if ((s.contains(agentName)) && (s.contains(this.mapName))) {
                ImageIcon imageIcon = new ImageIcon("src/Assets/" + s + ".png");
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);  // transform it back
                JLabel lbl = new JLabel(imageIcon);
                container.add(lbl);
            }
        }
        jsp = new JScrollPane(container);
        jsp.setBackground(Color.gray);
        jsp.setBounds(0,35,1600,950);
        this.add(jsp);
        jsp.paintAll(jsp.getGraphics());
    }
    public void actionPerformed(ActionEvent e)
    {
        container = new JPanel();
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton btn = (JButton)source;
            String butSrcTxt = btn.getText();
            addImages(butSrcTxt);
        }
    }


}