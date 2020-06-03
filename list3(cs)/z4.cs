using System;
using System.Collections.Generic;

class ListaLeniwa {
    public List<int> l = new List<int>();
    Random r = new Random();
    public int element(int i) {
        if(i >= l.Count) {
            int temp = l.Count;
            for(int j = 0; j < i - temp; j++){
                int x = r.Next(-100, 100);
                l.Add(x);
            }
        }
         return l[i - 1];
    }
    public int size() {
        return l.Count;
    }
}

class Pierwsze: ListaLeniwa {
     public int p = 2;
     public bool prime(int x)
     {
         for(int i = 2; i * i <= x; i++){
             if(x % i == 0) return false;
         }
         return true;
     }
     public int element(int i) {
         if(i >= l.Count) {
             int temp = l.Count;
             for(int j = 0; j < i - temp; j++){
                while(!prime(p)){
                    p++;
                }
                l.Add(p);
                p++;
             }
         }
         return l[i - 1];
     }
}

class Zadanie {
    static void Main() {
        ListaLeniwa t = new ListaLeniwa();
        Pierwsze p = new Pierwsze();
        Console.WriteLine(t.element(40));
        Console.WriteLine(t.size());
        Console.WriteLine(t.element(15));
        Console.WriteLine(t.size());
        Console.WriteLine(p.element(30));
        Console.WriteLine(p.size());
        Console.WriteLine(p.element(15));
        Console.WriteLine(p.size());
    }
}