import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.effect.*;

import javafx.scene.text.*;
import javafx.scene.paint.Color;

import javafx.scene.image.*;
import javafx.scene.chart.*;
import javafx.collections.*;

public class View extends BorderPane
{
    private Spiel spiel;  // Modell
    private TextField tipp;

    private Label meldung;
    private TextField anzahl;
    private Label anzahlVersuche;

    private Label[] feld;

    public View(Spiel spiel)
    {
        this.spiel = spiel;   
        guiErstellen();
    }

    public void guiErstellen()
    {
        // ------ oben ---------
        Text titel = new Text("Schiffe versenken");

        HBox oben = new HBox();
        oben.getChildren().add(titel);

        setTop(oben);
        oben.setPadding(new Insets(20));
        oben.setMargin(titel,new Insets(10));

        //------- mitte -----------
        VBox mitte = new VBox(10);
        mitte.setPadding(new Insets(10));
        HBox spielfeld = new HBox();

        int breite = spiel.getBreite();
        feld = new Label[breite];
        for (int i = 0;i < breite; i++)
        {
            final int x = i;
            feld[i] = new Label("" +i);
            feld[i].setOnMouseClicked(e -> tippAbgeben(x));
            spielfeld.getChildren().add(feld[i]);
        }

        HBox hbox1 = new HBox(8);
        Label label1 = new Label("Ziele auf: ");
        tipp = new TextField(" ");       
        Button neu = new Button("Los!");
        neu.setOnAction(e -> tippAbgeben());        
        hbox1.getChildren().addAll(label1, tipp, neu);

        HBox hbox2 = new HBox(8);
        meldung = new Label();
        hbox2.getChildren().addAll(meldung);  

        HBox hbox3 = new HBox(100);
        anzahlVersuche = new Label("Anzahl der Versuche: 0 ");
        Button neuesSpiel = new Button("Neues Spiel");
        neuesSpiel.setOnAction(e->neuesSpiel());
        hbox3.getChildren().addAll(anzahlVersuche, neuesSpiel);

        mitte.getChildren().addAll(spielfeld, hbox2, hbox3);
        // Styles
        hbox1.getStyleClass().add("hbox");
        hbox2.getStyleClass().add("hbox");
        hbox3.getStyleClass().add("hbox");
        oben.getStyleClass().add("hbox");

        tipp.getStyleClass().add("tipp");
        spielfeld.getStyleClass().add("feld");
        titel.getStyleClass().add("titel");

        //--Abstand
        setPadding(new Insets(40));
        setCenter(mitte);

    }

    public void tippAbgeben()
    {
        try{
            int tippZahl = Integer.parseInt(tipp.getText());
            spiel.spielen(tippZahl);
            String erg = spiel.getAusgabe();
            meldung.setText(erg);
            if (erg.equals("Treffer")||erg.equals("Versenkt"))
            {
                feld[tippZahl].setText("x");
            }

            anzahlVersuche.setText("Anzahl der Versuche: " + spiel.getAnzahlVersuche());

        }
        catch(Exception ex)
        {}
        tipp.setText("");
    }

    public void tippAbgeben(int tippZahl)
    {
        try{
            spiel.spielen(tippZahl);
            String erg = spiel.getAusgabe();
            meldung.setText(erg);
            if (erg.equals("Treffer")||erg.equals("Versenkt"))
            {
                feld[tippZahl].setText("x");
            }
            else
            {
                feld[tippZahl].setText(" ");
            }

            anzahlVersuche.setText("Anzahl der Versuche: " + spiel.getAnzahlVersuche());

        }
        catch(Exception ex)
        {}
        //tipp.setText("");
    }

    public void neuesSpiel()
    {
        spiel.spielEinrichten();
        tipp.setText("");
        meldung.setText("");
        anzahlVersuche.setText("Anzahl der Versuche: ");
        for (int i = 0; i < spiel.getBreite(); i++)
        {
            feld[i].setText(i+"");
        }
    }
}