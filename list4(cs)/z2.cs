using System;
using System.Collections;

class PrimeCollection: IEnumerable {
    public IEnumerator GetEnumerator() {
        return new PrimeNum(); 
    }
}

class PrimeNum: IEnumerator {
    private int p = 1;
    public bool MoveNext() {
        p++;
        bool t = false;
        while(!t){
            t = true;
            for(int i = 2; i < p; i++){
                if(p % i == 0){
                    t = false;
                    p++;
                    break;
                }
            }
        }
        if(p >= 3000) p = 0;
        return this.p != 0;
    }
    public object Current{
        get {
        return this.p;
        }
    }
    public void Reset() {
        p = 1;
    }
}

class Zadanie {
    static void Main() {
        PrimeCollection pc = new PrimeCollection();
        foreach(int e in pc)
        {
            Console.WriteLine(e);
        }
    }
}