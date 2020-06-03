import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.io.Serializable;
import java.lang.Math;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Figura
{
    public Double pole;
    public String nazwa;
    public void nazwa()
    {
        System.out.println(nazwa);
    }
}
class FiguraInterface extends JLabel implements ActionListener
{
    Figura F = new Figura();
    JTextField Pole = new JTextField(10);
    JTextField Name = new JTextField(10);
    JButton save_button = new JButton("Zapisz");
    JFrame Edit = new JFrame("Figura");
    Container inter;
    GridBagLayout layout = new GridBagLayout();
    JLabel Pole_label= new JLabel("Pole: ");
    JLabel Name_label = new JLabel("Nazwa");
    GridBagConstraints gr = new GridBagConstraints();
    public FiguraInterface() {
        Edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inter = Edit.getContentPane();
        inter.setLayout(layout);
        save_button.addActionListener(this);
        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.gridx = 0;
        gr.gridy = 0;
        inter.add(Pole_label, gr);
        gr.gridy = 1;
        inter.add(Pole, gr);
        gr.gridy = 2;
        inter.add(Name_label, gr);
        gr.gridy = 3;
        inter.add(Name, gr);
        gr.gridx = 0;
        gr.gridy = 4;
        gr.gridwidth = 2;
        gr.ipady = 15;
        inter.add(save_button, gr);
        Edit.pack();
        Edit.setVisible(true);
    }

    public void actionPerformed (ActionEvent ev) {
        F.pole = Double.parseDouble(Pole.getText());
        F.nazwa = Name.getText();
        System.out.printf("%s %f\n", F.nazwa, F.pole);
    }
}
class Okrag extends Figura
{
    public int ox, oy, r;
    public double pole()
    {
        return 3.14 * r * r;
    }
    public void wypisz()
    {
        System.out.printf("%d %d %d\n", ox, oy, r);
    }
}
class OkragInterface extends JLabel implements ActionListener
{
    Okrag O = new Okrag();
    JTextField Pole = new JTextField();
    JTextField Name = new JTextField();
    JButton save_button = new JButton("Zapisz");
    JFrame Edit = new JFrame("Okrąg");
    Container inter;
    GridBagLayout layout = new GridBagLayout();
    JLabel Pole_label= new JLabel("Pole: ");
    JLabel Srodek_label = new JLabel("Środek okręgu: ");
    JLabel Name_label = new JLabel("Nazwa");
    JLabel Promien_label = new JLabel("Promien");
    JTextField x1 = new JTextField(10);
    JTextField y1 = new JTextField(10);
    JTextField r = new JTextField(10);
    GridBagConstraints gr = new GridBagConstraints();

    public OkragInterface()
    {
        Edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inter = Edit.getContentPane();
        inter.setLayout(layout);
        save_button.addActionListener(this);
        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.gridx = 0;
        gr.gridy = 0;
        inter.add(Pole_label, gr);
        gr.gridy = 1;
        inter.add(Pole, gr);
        gr.gridy = 2;
        inter.add(Name_label, gr);
        gr.gridy = 3;
        inter.add(Name, gr);
        gr.gridx = 0;
        gr.gridy = 4;
        gr.gridwidth = 2;
        inter.add(Srodek_label, gr);
        gr.gridy = 5;
        gr.gridwidth = 1;
        inter.add(x1, gr);
        gr.gridx = 1;
        inter.add(y1, gr);
        gr.gridy = 7;
        gr.gridx = 0;
        gr.gridwidth = 2;
        inter.add(Promien_label, gr);
        gr.gridy = 8;
        inter.add(r, gr);
        gr.gridy = 9;
        gr.gridwidth = 2;
        gr.ipady = 15;
        inter.add(save_button, gr);
        Edit.pack();
        Edit.setVisible(true);
    }

    public void actionPerformed (ActionEvent ev) {
        O.ox = Integer.parseInt(x1.getText());
        O.oy = Integer.parseInt(y1.getText());
        O.r = Integer.parseInt(r.getText());
        O.nazwa = Name.getText();
        Pole.setText(Double.toString(O.pole()));
        O.wypisz();
        System.out.println(O.nazwa);
    }
}
class Trojkat extends Figura
{
    public int x1, y1, x2, y2, x3, y3;
    public double pole()
    {
        return Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) / 2;
    }
    public String toString()
    {
        return Integer.toString(x1) + "," + Integer.toString(y1) + " " + Integer.toString(x2) + "," + Integer.toString(y2) + " " + Integer.toString(x3) + "," + Integer.toString(y3);
    }
}

class TrojkatInterface extends JLabel implements ActionListener
{
    Trojkat T = new Trojkat();
    JTextField Pole = new JTextField();
    JTextField Name = new JTextField();
    JButton save_button = new JButton("Zapisz");
    JFrame Edit = new JFrame("Trojkat");
    Container inter;
    GridBagLayout layout = new GridBagLayout();
    JLabel Pole_label= new JLabel("Pole: ");
    JLabel Wierzcholki_label = new JLabel("Werzchołki: ");
    JLabel Name_label = new JLabel("Nazwa");
    JTextField x1 = new JTextField(10);
    JTextField x2 = new JTextField(10);
    JTextField x3 = new JTextField(10);
    JTextField y1 = new JTextField(10);
    JTextField y2 = new JTextField(10);
    JTextField y3 = new JTextField(10);
    GridBagConstraints gr = new GridBagConstraints();

    public TrojkatInterface(){
        Edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inter = Edit.getContentPane();
        inter.setLayout(layout);
        save_button.addActionListener(this);
        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.gridx = 0;
        gr.gridy = 0;
        inter.add(Pole_label, gr);
        gr.gridx = 1;
        gr.gridy = 0;
        inter.add(Name_label, gr);
        gr.gridy = 1;
        gr.gridx = -1;
        inter.add(Pole, gr);
        gr.gridx = 1;
        inter.add(Name, gr);
        gr.gridx = 0;
        gr.gridy = 4;
        gr.gridwidth = 2;
        inter.add(Wierzcholki_label, gr);
        gr.gridy = 5;
        gr.gridwidth = 1;
        inter.add(x1, gr);
        gr.gridy = 6;
        inter.add(x2, gr);
        gr.gridy = 7;
        inter.add(x3, gr);
        gr.gridx = 1;
        gr.gridy = 5;
        inter.add(y1, gr);
        gr.gridy = 6;
        inter.add(y2, gr);
        gr.gridy = 7;
        inter.add(y3, gr);
        gr.gridy = 8;
        gr.gridx = 0;
        gr.gridwidth = 2;
        gr.ipady = 20;
        inter.add(save_button, gr);
        Edit.pack();
        Edit.setVisible(true);
    }

    public void actionPerformed (ActionEvent ev) {
        T.x1 = Integer.parseInt(x1.getText());
        T.x2 = Integer.parseInt(x2.getText());
        T.x3 = Integer.parseInt(x3.getText());
        T.y1 = Integer.parseInt(y1.getText());
        T.y2 = Integer.parseInt(y2.getText());
        T.y3 = Integer.parseInt(y3.getText());
        T.nazwa = Name.getText();
        Pole.setText(Double.toString(T.pole()));
        System.out.print(T.toString() + "\n");
        System.out.println(T.nazwa);
    }
}
public class z
{
    public static void main(String [] args)
    {
        switch (args[0]) {
            case "F":
                FiguraInterface fu = new FiguraInterface();
                break;
            case "T":
                TrojkatInterface tr = new TrojkatInterface();
                break;
            case "O":
                OkragInterface ko = new OkragInterface();
                break;
            default:
                System.out.println("Nie ma takiej klasy");
        }
        return;
    }
}
