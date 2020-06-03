using System;

class IntStream
{
        public int poc = 0;
        public int end_stream = 1;
        public int next() {
                if(end_stream == -1) poc = poc + 1;
                return poc;
        }
        public void reset() {
                poc = 1;
                end_stream = -1;
        }
        public bool eos() {
                end_stream *= -1;
                if(end_stream == 1) return true;
                else return false;
        }
}
class PrimeStream: IntStream
{
        public int poc = 2;
        public bool prime(int x) {
                for(int i = 2; i * i <= x; i++) {
                        if(x % i == 0) return false;
                }
                return true;
        }
        public int next() {
                while(!prime(poc) && end_stream != 1) {
                        poc++;
                }
                return poc;
        }
        public bool eos() {
        
                if(poc > 2e9 && end_stream == -1) end_stream *= -1;
                if(end_stream == 1) return true;
                else return false;
        }
}

class RandomStream: IntStream {
        Random random = new Random();
        public int next() {
                return random.Next(97, 122);
        }
}
class RandomWordStream {
        PrimeStream p = new PrimeStream();
        RandomStream znak = new RandomStream();
        int n = 0;
        public string next() {
                n = p.next();
                string s = "";
                for(int i = 0; i < n; i++) {
                        char k = (char)znak.next();
                        s += k;
                }
               return s;
        }
}
class Zadanie
{
        static void Main()
        {
                RandomWordStream slowa = new RandomWordStream();
                for(int i = 0; i < 6; i++) {
                        Console.WriteLine(slowa.next());
                }
        }
}