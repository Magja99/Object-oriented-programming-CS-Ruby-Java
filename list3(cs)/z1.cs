using System;
using Lista;

class Zadanie {
    static void Main() {
        Console.WriteLine("Back: ");
        Lista<int> l = new Lista<int>();
        for(int i = 0; i < 10; i++) 
            l.Push_Back(i);
        while(!l.Empty()) {
            Console.WriteLine(l.Last());
            l.PopBack();
        }
        Console.WriteLine("Front: ");
        for(int i = 0; i < 10; i++) 
            l.Push_Front(i);
        while(!l.Empty()) {
            Console.WriteLine(l.First());
            l.PopFront();
        }
    }
}