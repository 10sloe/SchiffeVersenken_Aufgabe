
/**
 * Die Klasse Spiel
 */
public class Spiel
{
    // Attribute
    private int[] feld;
    private int anzahlVersuche;
    private int anzahlTreffer;
    private String ausgabeText;

    // Konstruktor
    public Spiel()
    {
        feld = new int[10];
        spielEinrichten();
    }

    // Methoden
    public void spielEinrichten()
    {
        // Alle Zellen des Spielfeldes auf 0 setzen.
        for (int i = 0; i < 10; i++)
        {
           feld[i] = 0;
        }
        // Anfangsposition des Schiffes festlegen
        int anfang = (int)(Math.random()*(8));  //anfang ist eine Zufallszahl zwischen 0 und 8

        // Schiff ins Spielfeld eintragen
        feld[anfang] = 1;
        feld[anfang + 1] = 1;
        feld[anfang + 2] = 1;

        // Anzahl der Treffer auf 0 setzen
        anzahlTreffer = 0;
        // Anzahl der Rateversuche auf 0 setzen
        anzahlVersuche = 0;
    }

    public void spielen(int tipp)
    {
        // Deine Aufgabe!

    }

    
    public String getAusgabe()
    {
        return ausgabeText;
    }

    public int getAnzahlVersuche()
    {
        return anzahlVersuche;
    }

    public int getBreite()
    {
        return 10;
    }
}

