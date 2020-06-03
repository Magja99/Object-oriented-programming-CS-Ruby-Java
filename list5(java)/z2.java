import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Wyrazenie 
{
    public abstract double oblicz();
    public abstract String ToString();
    public static Map<String,Double> map = new HashMap<String, Double>();
}

class Zmienna extends Wyrazenie
{
    private String zmienna;
    public double oblicz() 
    {
        return map.get(zmienna);
    }
    Zmienna(String x)
    {
        zmienna = x;
    }
    Zmienna(String x, Double val) {
        zmienna = x;
        map.put(x, val);
    }
    public String ToString() 
    {
        return "" + zmienna;
    }
}

class Stala extends Wyrazenie
{
    private double stala;
    public double oblicz() 
    {
        return stala;
    }
    Stala(double x)
    {
        stala = x;
    }
    public String ToString() 
    {
        return "" + stala;
    }
}

class Wierzcholek extends Wyrazenie
{
    private String op;
    private Wyrazenie Lewy;
    private Wyrazenie Prawy;

    public void Dodawanie(Wyrazenie L, Wyrazenie P) 
    {
        Lewy = L;
        Prawy = P;
        op = " + ";
    }
    public void Odejmowanie(Wyrazenie L, Wyrazenie P) 
    {
        Lewy = L;
        Prawy = P;
        op = " - ";
    }
    public void Mnozenie(Wyrazenie L, Wyrazenie P) 
    {
        Lewy = L;
        Prawy = P;
        op = " * ";
    }
    public void Dzielenie(Wyrazenie L, Wyrazenie P) 
    {
        Lewy = L;
        Prawy = P;
        op = " / ";
    }
    public double oblicz() 
    {
        if(op == " + ") return Lewy.oblicz() + Prawy.oblicz();
        if(op == " - ") return Lewy.oblicz() - Prawy.oblicz();
        if(op == " * ") return Lewy.oblicz() * Prawy.oblicz();
        return Lewy.oblicz() / Prawy.oblicz();
    }
    public String ToString() 
    {
        String l = Lewy.ToString();
        String p = Prawy.ToString();
        String n1 = "", n2 = "", n3 = "", n4 = "";
        if(l.indexOf(" ") != -1 && (op == " * " || op == " / "))
        {
            n1 = "(";
            n2 = ")";
        }
        if(p.indexOf(" ") != -1 && (op == " * " || op == " / "))
        {
            n3 = "(";
            n4 = ")";
        }
        return n1 + l + n2 + op + n3 + p + n4;
    }
}
public class z2
{
     public static void main(String [] args) 
    {
         Wierzcholek dod1 = new Wierzcholek();
         Wierzcholek dod2 = new Wierzcholek();
         Wierzcholek od = new Wierzcholek();
         Wierzcholek dziel = new Wierzcholek();
         Wierzcholek il = new Wierzcholek();
         dod1.Dodawanie(new Zmienna("x", 5.0), new Stala(6.0));
         dod2.Dodawanie(new Stala(10.0), new Stala(-4.0));
         od.Odejmowanie(dod1, new Zmienna("y", 2.0));
         dziel.Dzielenie(od, new Zmienna("y"));
         il.Mnozenie(dod2, dziel);
         System.out.println(il.ToString());
         System.out.println(il.oblicz());
    }
}