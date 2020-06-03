class Pojazd {
public string marka; public string rejestracja; public string rok_prod;
public void info() {
Console.WriteLine("Marka: {0}, rocznik: {1}",
        } }

class Samochod : Pojazd { bool hybryda;
        public void info() {
        base.info();
        Console.WriteLine("hybryda: {0}", hybryda); }
        }

Samochod fiat = new Samochod
fiat.info()
