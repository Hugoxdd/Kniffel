import java.io.*;
import java.util.*;
class Wuerfelspiel
{
  public static void main(String [] args) throws IOException
  {
    int anfang;
    anfang = 0;
    try {
      System.setOut(new java.io.PrintStream(System.out, true, "CP850"));
    } catch (java.io.UnsupportedEncodingException e) {
      System.out.println(e);
    }
    
    int spieler;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("Kennen Sie die Spielregeln? Ja / Nein");
    String regeln = "";
    regeln = br.readLine();
    if(regeln.equals("N") == true || regeln.equals("Nein") == true || regeln.equals("nein") == true || regeln.equals("n"))
    {
      try
      {
        BufferedReader cr = new BufferedReader(new FileReader("Regeln.txt"));
        for(int x = 0; x < 108; x++)
        {
          regeln = cr.readLine();
          System.out.println(regeln);
        }

      }
      catch(IOException e)
      {

      }
    }
    
    System.out.println("Wie viele Spieler spielen mit? (5 max.) (bei 1 gegen Computer)");
    spieler = Integer.parseInt(br.readLine());

    Wuerfel w1 = new Wuerfel();
    Wuerfel w2 = new Wuerfel();
    Wuerfel w3 = new Wuerfel();
    Wuerfel w4 = new Wuerfel();
    Wuerfel w5 = new Wuerfel();

     switch(spieler)
     {
       case 1:
       System.out.println("Der Spieler mit der gr��ten Augenzahl beginnt.");
       w1.anfangen();
       w2.anfangen();
       System.out.println("Spieler 1: " + w1.w�rfel[0]);
       System.out.println("Spieler 2: " + w2.w�rfel[0]);
       System.out.println("");
       while(w1.w�rfel[0] == w2.w�rfel[0])
       {
       w1.anfangen();
       w2.anfangen();
       System.out.println("Spieler 1: " + w1.w�rfel[0]);
       System.out.println("Spieler 2: " + w2.w�rfel[0]);
       System.out.println("");
       }
       if(w1.w�rfel[0] > w2.w�rfel[0])
       {
         anfang = 1;
       }
       else
       {
         anfang = 2;
       }
       for(int i = 0; i < 13; i++)
       {
        if(anfang == 1)
        {
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus2();
         w2.waehlen2();
        }

         if(anfang == 2)
         {
           System.out.println("");
           System.out.println("Spieler 2 Sie sind dran!");
           w2.w�rfeln();
           w2.w�rfelraus2();
           w2.waehlen2();
           System.out.println("");
           System.out.println("Spieler 1 Sie sind dran!");
           w1.w�rfeln();
           w1.w�rfelraus();
           w1.waehlen();
         }
         }
       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 1");
       System.out.println("          1er : " + w1.ergebnis[0]);
       System.out.println("          2er : " + w1.ergebnis[1]);
       System.out.println("          3er : " + w1.ergebnis[2]);
       System.out.println("          4er : " + w1.ergebnis[3]);
       System.out.println("          5er : " + w1.ergebnis[4]);
       System.out.println("          6er : " + w1.ergebnis[5]);

       if((w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5]) >= 63)
       {
         w1.ergebnis[5] = w1.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }

       System.out.println("  Dreierpasch : " + w1.ergebnis[6]);
       System.out.println("  Viererpasch : " + w1.ergebnis[7]);
       System.out.println("   Full-House : " + w1.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w1.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w1.ergebnis[10]);
       System.out.println("      Kniffel : " + w1.ergebnis[11]);
       System.out.println("       Chance : " + w1.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5] + w1.ergebnis[6] + w1.ergebnis[7] + w1.ergebnis[8] + w1.ergebnis[9] + w1.ergebnis[10] + w1.ergebnis[11] + w1.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 2");
       System.out.println("          1er : " + w2.ergebnis[0]);
       System.out.println("          2er : " + w2.ergebnis[1]);
       System.out.println("          3er : " + w2.ergebnis[2]);
       System.out.println("          4er : " + w2.ergebnis[3]);
       System.out.println("          5er : " + w2.ergebnis[4]);
       System.out.println("          6er : " + w2.ergebnis[5]);

       if((w2.ergebnis[0] + w2.ergebnis[1] + w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5]) >= 63)
       {
         w2.ergebnis[5] = w2.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }

       System.out.println("  Dreierpasch : " + w2.ergebnis[6]);
       System.out.println("  Viererpasch : " + w2.ergebnis[7]);
       System.out.println("   Full-House : " + w2.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w2.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w2.ergebnis[10]);
       System.out.println("      Kniffel : " + w2.ergebnis[11]);
       System.out.println("       Chance : " + w2.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w2.ergebnis[0] + w2.ergebnis[1] + w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5] + w2.ergebnis[6] + w2.ergebnis[7] + w2.ergebnis[8] + w2.ergebnis[9] + w2.ergebnis[10] + w2.ergebnis[11] + w2.ergebnis[12]));

       break;
       case 2:

       System.out.println("Der Spieler mit der gr��ten Augenzahl beginnt.");
       w1.anfangen();
       w2.anfangen();
       System.out.println("Spieler 1: " + w1.w�rfel[0]);
       System.out.println("Spieler 2: " + w2.w�rfel[0]);
       System.out.println("");
       while(w1.w�rfel[0] == w2.w�rfel[0])
       {
       w1.anfangen();
       w2.anfangen();
       System.out.println("Spieler 1: " + w1.w�rfel[0]);
       System.out.println("Spieler 2: " + w2.w�rfel[0]);
       System.out.println("");
       }
       if(w1.w�rfel[0] > w2.w�rfel[0])
       {
         anfang = 1;
       }
       else
       {
         anfang = 2;
       }
       for(int i = 0; i < 13; i++)
       {
        if(anfang == 1)
        {
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
        }

         if(anfang == 2)
         {
           System.out.println("");
           System.out.println("Spieler 2 Sie sind dran!");
           w2.w�rfeln();
           w2.w�rfelraus();
           w2.waehlen();
           System.out.println("");
           System.out.println("Spieler 1 Sie sind dran!");
           w1.w�rfeln();
           w1.w�rfelraus();
           w1.waehlen();
         }
      }
       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 1");
       System.out.println("          1er : " + w1.ergebnis[0]);
       System.out.println("          2er : " + w1.ergebnis[1]);
       System.out.println("          3er : " + w1.ergebnis[2]);
       System.out.println("          4er : " + w1.ergebnis[3]);
       System.out.println("          5er : " + w1.ergebnis[4]);
       System.out.println("          6er : " + w1.ergebnis[5]);
       
       if((w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5]) >= 63)
       {
         w1.ergebnis[5] = w1.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w1.ergebnis[6]);
       System.out.println("  Viererpasch : " + w1.ergebnis[7]);
       System.out.println("   Full-House : " + w1.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w1.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w1.ergebnis[10]);
       System.out.println("      Kniffel : " + w1.ergebnis[11]);
       System.out.println("       Chance : " + w1.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5] + w1.ergebnis[6] + w1.ergebnis[7] + w1.ergebnis[8] + w1.ergebnis[9] + w1.ergebnis[10] + w1.ergebnis[11] + w1.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 2");
       System.out.println("          1er : " + w2.ergebnis[0]);
       System.out.println("          2er : " + w2.ergebnis[1]);
       System.out.println("          3er : " + w2.ergebnis[2]);
       System.out.println("          4er : " + w2.ergebnis[3]);
       System.out.println("          5er : " + w2.ergebnis[4]);
       System.out.println("          6er : " + w2.ergebnis[5]);
       
       if((w2.ergebnis[0] + w2.ergebnis[1] +  w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5]) >= 63)
       {
         w2.ergebnis[5] = w2.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w2.ergebnis[6]);
       System.out.println("  Viererpasch : " + w2.ergebnis[7]);
       System.out.println("   Full-House : " + w2.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w2.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w2.ergebnis[10]);
       System.out.println("      Kniffel : " + w2.ergebnis[11]);
       System.out.println("       Chance : " + w2.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w2.ergebnis[0] + w2.ergebnis[1] + w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5] + w2.ergebnis[6] + w2.ergebnis[7] + w2.ergebnis[8] + w2.ergebnis[9] + w2.ergebnis[10] + w2.ergebnis[11] + w2.ergebnis[12]));

       break;
       case 3:
       System.out.println("Der Spieler mit der gr��ten Augenzahl beginnt.");
       w1.anfangen();
       w2.anfangen();
       w3.anfangen();
       System.out.println("Spieler 1: " + w1.w�rfel[0]);
       System.out.println("Spieler 2: " + w2.w�rfel[0]);
       System.out.println("Spieler 3: " + w3.w�rfel[0]);
       System.out.println("");
       while(w1.w�rfel[0] == w2.w�rfel[0] || w2.w�rfel[0] == w3.w�rfel[0] || w1.w�rfel[0] == w3.w�rfel[0])
       {
        w1.anfangen();
        w2.anfangen();
        w3.anfangen();
        System.out.println("Spieler 1: " + w1.w�rfel[0]);
        System.out.println("Spieler 2: " + w2.w�rfel[0]);
        System.out.println("Spieler 3: " + w3.w�rfel[0]);
        System.out.println("");
       }
       if(w1.w�rfel[0] > w2.w�rfel[0] && w1.w�rfel[0] > w3.w�rfel[0])
       {
         anfang = 1;
       }
       else if(w2.w�rfel[0] > w3.w�rfel[0] && w2.w�rfel[0] > w1.w�rfel[0])
       {
         anfang = 2;
       }
       else if(w3.w�rfel[0] > w2.w�rfel[0] && w3.w�rfel[0] > w1.w�rfel[0])
       {
         anfang = 3;
       }
       
       for(int i = 0; i < 13; i++)
       {
       if(anfang == 1)
       {
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
        }
        if(anfang == 2)
        {
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
        }
        if(anfang == 3)
        {
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
        }
       }
       
       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 1");
       System.out.println("          1er : " + w1.ergebnis[0]);
       System.out.println("          2er : " + w1.ergebnis[1]);
       System.out.println("          3er : " + w1.ergebnis[2]);
       System.out.println("          4er : " + w1.ergebnis[3]);
       System.out.println("          5er : " + w1.ergebnis[4]);
       System.out.println("          6er : " + w1.ergebnis[5]);
       
       if((w1.ergebnis[0] + w1.ergebnis[1] +  w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5]) >= 63)
       {
         w1.ergebnis[5] = w1.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w1.ergebnis[6]);
       System.out.println("  Viererpasch : " + w1.ergebnis[7]);
       System.out.println("   Full-House : " + w1.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w1.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w1.ergebnis[10]);
       System.out.println("      Kniffel : " + w1.ergebnis[11]);
       System.out.println("       Chance : " + w1.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5] + w1.ergebnis[6] + w1.ergebnis[7] + w1.ergebnis[8] + w1.ergebnis[9] + w1.ergebnis[10] + w1.ergebnis[11] + w1.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 2");
       System.out.println("          1er : " + w2.ergebnis[0]);
       System.out.println("          2er : " + w2.ergebnis[1]);
       System.out.println("          3er : " + w2.ergebnis[2]);
       System.out.println("          4er : " + w2.ergebnis[3]);
       System.out.println("          5er : " + w2.ergebnis[4]);
       System.out.println("          6er : " + w2.ergebnis[5]);
       
       if((w2.ergebnis[0] + w2.ergebnis[1] +  w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5]) >= 63)
       {
         w2.ergebnis[5] = w2.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w2.ergebnis[6]);
       System.out.println("  Viererpasch : " + w2.ergebnis[7]);
       System.out.println("   Full-House : " + w2.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w2.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w2.ergebnis[10]);
       System.out.println("      Kniffel : " + w2.ergebnis[11]);
       System.out.println("       Chance : " + w2.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w2.ergebnis[0] + w2.ergebnis[1] + w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5] + w2.ergebnis[6] + w2.ergebnis[7] + w2.ergebnis[8] + w2.ergebnis[9] + w2.ergebnis[10] + w2.ergebnis[11] + w2.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 3");
       System.out.println("          1er : " + w3.ergebnis[0]);
       System.out.println("          2er : " + w3.ergebnis[1]);
       System.out.println("          3er : " + w3.ergebnis[2]);
       System.out.println("          4er : " + w3.ergebnis[3]);
       System.out.println("          5er : " + w3.ergebnis[4]);
       System.out.println("          6er : " + w3.ergebnis[5]);
       
       if((w3.ergebnis[0] + w3.ergebnis[1] + w3.ergebnis[2] + w3.ergebnis[3] + w3.ergebnis[4] + w3.ergebnis[5]) >= 63)
       {
         w3.ergebnis[5] = w3.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w3.ergebnis[6]);
       System.out.println("  Viererpasch : " + w3.ergebnis[7]);
       System.out.println("   Full-House : " + w3.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w3.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w3.ergebnis[10]);
       System.out.println("      Kniffel : " + w3.ergebnis[11]);
       System.out.println("       Chance : " + w3.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w3.ergebnis[0] + w3.ergebnis[1] + w3.ergebnis[2] + w3.ergebnis[3] + w3.ergebnis[4] + w3.ergebnis[5] + w3.ergebnis[6] + w3.ergebnis[7] + w3.ergebnis[8] + w3.ergebnis[9] + w3.ergebnis[10] + w3.ergebnis[11] + w3.ergebnis[12]));

       break;
       case 4:
       System.out.println("Der Spieler mit der gr��ten Augenzahl beginnt.");
       w1.anfangen();
       w2.anfangen();
       w3.anfangen();
       w4.anfangen();
       System.out.println("Spieler 1: " + w1.w�rfel[0]);
       System.out.println("Spieler 2: " + w2.w�rfel[0]);
       System.out.println("Spieler 3: " + w3.w�rfel[0]);
       System.out.println("Spieler 4: " + w4.w�rfel[0]);
       System.out.println("");
       while(w1.w�rfel[0] == w2.w�rfel[0] || w2.w�rfel[0] == w3.w�rfel[0] || w1.w�rfel[0] == w3.w�rfel[0] || w4.w�rfel[0] == w1.w�rfel[0] || w4.w�rfel[0] == w2.w�rfel[0] || w4.w�rfel[0] == w3.w�rfel[0])
       {
        w1.anfangen();
        w2.anfangen();
        w3.anfangen();
        w4.anfangen();
        System.out.println("Spieler 1: " + w1.w�rfel[0]);
        System.out.println("Spieler 2: " + w2.w�rfel[0]);
        System.out.println("Spieler 3: " + w3.w�rfel[0]);
        System.out.println("Spieler 4: " + w4.w�rfel[0]);
        System.out.println("");
       }
       if(w1.w�rfel[0] > w2.w�rfel[0] && w1.w�rfel[0] > w3.w�rfel[0])
       {
         anfang = 1;
       }
       else if(w2.w�rfel[0] > w3.w�rfel[0] && w2.w�rfel[0] > w1.w�rfel[0])
       {
         anfang = 2;
       }
       else if(w3.w�rfel[0] > w2.w�rfel[0] && w3.w�rfel[0] > w1.w�rfel[0])
       {
         anfang = 3;
       }
       else if(w4.w�rfel[0] > w1.w�rfel[0] && w4.w�rfel[0] > w2.w�rfel[0] && w4.w�rfel[0] > w3.w�rfel[0])
       {
         anfang = 4;
       }
       for(int i = 0; i < 13; i++)
       {
        if(anfang == 1)
       {
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
        }
        if(anfang == 2)
        {
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
        }
        if(anfang == 3)
        {
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
        }
        if(anfang == 4)
        {
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
        }
       }
       
       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 1");
       System.out.println("          1er : " + w1.ergebnis[0]);
       System.out.println("          2er : " + w1.ergebnis[1]);
       System.out.println("          3er : " + w1.ergebnis[2]);
       System.out.println("          4er : " + w1.ergebnis[3]);
       System.out.println("          5er : " + w1.ergebnis[4]);
       System.out.println("          6er : " + w1.ergebnis[5]);
       
       if((w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5]) >= 63)
       {
         w1.ergebnis[5] = w1.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w1.ergebnis[6]);
       System.out.println("  Viererpasch : " + w1.ergebnis[7]);
       System.out.println("   Full-House : " + w1.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w1.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w1.ergebnis[10]);
       System.out.println("      Kniffel : " + w1.ergebnis[11]);
       System.out.println("       Chance : " + w1.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5] + w1.ergebnis[6] + w1.ergebnis[7] + w1.ergebnis[8] + w1.ergebnis[9] + w1.ergebnis[10] + w1.ergebnis[11] + w1.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 2");
       System.out.println("          1er : " + w2.ergebnis[0]);
       System.out.println("          2er : " + w2.ergebnis[1]);
       System.out.println("          3er : " + w2.ergebnis[2]);
       System.out.println("          4er : " + w2.ergebnis[3]);
       System.out.println("          5er : " + w2.ergebnis[4]);
       System.out.println("          6er : " + w2.ergebnis[5]);
       
       if((w2.ergebnis[0] + w2.ergebnis[1] + w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5]) >= 63)
       {
         w2.ergebnis[5] = w2.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w2.ergebnis[6]);
       System.out.println("  Viererpasch : " + w2.ergebnis[7]);
       System.out.println("   Full-House : " + w2.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w2.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w2.ergebnis[10]);
       System.out.println("      Kniffel : " + w2.ergebnis[11]);
       System.out.println("       Chance : " + w2.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w2.ergebnis[0] + w2.ergebnis[1] + w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5] + w2.ergebnis[6] + w2.ergebnis[7] + w2.ergebnis[8] + w2.ergebnis[9] + w2.ergebnis[10] + w2.ergebnis[11] + w2.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 3");
       System.out.println("          1er : " + w3.ergebnis[0]);
       System.out.println("          2er : " + w3.ergebnis[1]);
       System.out.println("          3er : " + w3.ergebnis[2]);
       System.out.println("          4er : " + w3.ergebnis[3]);
       System.out.println("          5er : " + w3.ergebnis[4]);
       System.out.println("          6er : " + w3.ergebnis[5]);
       
       if((w3.ergebnis[0] + w3.ergebnis[1] +  w3.ergebnis[2] + w3.ergebnis[3] + w3.ergebnis[4] + w3.ergebnis[5]) >= 63)
       {
         w3.ergebnis[5] = w3.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w3.ergebnis[6]);
       System.out.println("  Viererpasch : " + w3.ergebnis[7]);
       System.out.println("   Full-House : " + w3.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w3.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w3.ergebnis[10]);
       System.out.println("      Kniffel : " + w3.ergebnis[11]);
       System.out.println("       Chance : " + w3.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w3.ergebnis[0] + w3.ergebnis[1] + w3.ergebnis[2] + w3.ergebnis[3] + w3.ergebnis[4] + w3.ergebnis[5] + w3.ergebnis[6] + w3.ergebnis[7] + w3.ergebnis[8] + w3.ergebnis[9] + w3.ergebnis[10] + w3.ergebnis[11] + w3.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 4");
       System.out.println("          1er : " + w4.ergebnis[0]);
       System.out.println("          2er : " + w4.ergebnis[1]);
       System.out.println("          3er : " + w4.ergebnis[2]);
       System.out.println("          4er : " + w4.ergebnis[3]);
       System.out.println("          5er : " + w4.ergebnis[4]);
       System.out.println("          6er : " + w4.ergebnis[5]);
       
       if((w4.ergebnis[0] + w4.ergebnis[1] +  w4.ergebnis[2] + w4.ergebnis[3] + w4.ergebnis[4] + w4.ergebnis[5]) >= 63)
       {
         w4.ergebnis[5] = w4.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w4.ergebnis[6]);
       System.out.println("  Viererpasch : " + w4.ergebnis[7]);
       System.out.println("   Full-House : " + w4.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w4.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w4.ergebnis[10]);
       System.out.println("      Kniffel : " + w4.ergebnis[11]);
       System.out.println("       Chance : " + w4.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w4.ergebnis[0] + w4.ergebnis[1] + w4.ergebnis[2] + w4.ergebnis[3] + w4.ergebnis[4] + w4.ergebnis[5] + w4.ergebnis[6] + w4.ergebnis[7] + w4.ergebnis[8] + w4.ergebnis[9] + w4.ergebnis[10] + w4.ergebnis[11] + w4.ergebnis[12]));

       break;
       case 5:
       System.out.println("Der Spieler mit der gr��ten Augenzahl beginnt.");
       w1.anfangen();
       w2.anfangen();
       w3.anfangen();
       w4.anfangen();
       w5.anfangen();
       System.out.println("Spieler 1: " + w1.w�rfel[0]);
       System.out.println("Spieler 2: " + w2.w�rfel[0]);
       System.out.println("Spieler 3: " + w3.w�rfel[0]);
       System.out.println("Spieler 4: " + w4.w�rfel[0]);
       System.out.println("Spieler 5: " + w5.w�rfel[0]);
       System.out.println("");
       while(w1.w�rfel[0] == w2.w�rfel[0] || w2.w�rfel[0] == w3.w�rfel[0] || w1.w�rfel[0] == w3.w�rfel[0] || w4.w�rfel[0] == w1.w�rfel[0] || w4.w�rfel[0] == w2.w�rfel[0] || w4.w�rfel[0] == w3.w�rfel[0] || w5.w�rfel[0] == w1.w�rfel[0] || w5.w�rfel[0] == w3.w�rfel[0] || w5.w�rfel[0] == w4.w�rfel[0])
       {
        w1.anfangen();
        w2.anfangen();
        w3.anfangen();
        w4.anfangen();
        w5.anfangen();
        System.out.println("Spieler 1: " + w1.w�rfel[0]);
        System.out.println("Spieler 2: " + w2.w�rfel[0]);
        System.out.println("Spieler 3: " + w3.w�rfel[0]);
        System.out.println("Spieler 4: " + w4.w�rfel[0]);
        System.out.println("Spieler 5: " + w5.w�rfel[0]);
        System.out.println("");
       }
       if(w1.w�rfel[0] > w2.w�rfel[0] && w1.w�rfel[0] > w3.w�rfel[0])
       {
         anfang = 1;
       }
       else if(w2.w�rfel[0] > w3.w�rfel[0] && w2.w�rfel[0] > w1.w�rfel[0])
       {
         anfang = 2;
       }
       else if(w3.w�rfel[0] > w2.w�rfel[0] && w3.w�rfel[0] > w1.w�rfel[0])
       {
         anfang = 3;
       }
       else if(w4.w�rfel[0] > w1.w�rfel[0] && w4.w�rfel[0] > w2.w�rfel[0] && w4.w�rfel[0] > w3.w�rfel[0])
       {
         anfang = 4;
       }
       else if(w5.w�rfel[0] > w1.w�rfel[0] && w5.w�rfel[0] > w2.w�rfel[0] && w5.w�rfel[0] > w3.w�rfel[0] && w5.w�rfel[0] > w4.w�rfel[0])
       {
         anfang = 5;
       }
       for(int i = 0; i < 13; i++)
       {
        if(anfang == 1)
        {
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
         System.out.println("");
         System.out.println("Spieler 5 Sie sind dran!");
         w5.w�rfeln();
         w5.w�rfelraus();
         w5.waehlen();
        }
       if(anfang == 2)
        {
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
         System.out.println("");
         System.out.println("Spieler 5 Sie sind dran!");
         w5.w�rfeln();
         w5.w�rfelraus();
         w5.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
        }
        if(anfang == 3)
        {
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
         System.out.println("");
         System.out.println("Spieler 5 Sie sind dran!");
         w5.w�rfeln();
         w5.w�rfelraus();
         w5.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
        }
        if(anfang == 4)
        {
         System.out.println("");
         System.out.println("Spieler 4 Sie sind dran!");
         w4.w�rfeln();
         w4.w�rfelraus();
         w4.waehlen();
         System.out.println("");
         System.out.println("Spieler 5 Sie sind dran!");
         w5.w�rfeln();
         w5.w�rfelraus();
         w5.waehlen();
         System.out.println("");
         System.out.println("Spieler 1 Sie sind dran!");
         w1.w�rfeln();
         w1.w�rfelraus();
         w1.waehlen();
         System.out.println("");
         System.out.println("Spieler 2 Sie sind dran!");
         w2.w�rfeln();
         w2.w�rfelraus();
         w2.waehlen();
         System.out.println("");
         System.out.println("Spieler 3 Sie sind dran!");
         w3.w�rfeln();
         w3.w�rfelraus();
         w3.waehlen();
        }
        if(anfang == 5)
        {
        System.out.println("");
        System.out.println("Spieler 5 Sie sind dran!");
        w5.w�rfeln();
        w5.w�rfelraus();
        w5.waehlen();
        System.out.println("");
        System.out.println("Spieler 1 Sie sind dran!");
        w1.w�rfeln();
        w1.w�rfelraus();
        w1.waehlen();
        System.out.println("");
        System.out.println("Spieler 2 Sie sind dran!");
        w2.w�rfeln();
        w2.w�rfelraus();
        w2.waehlen();
        System.out.println("");
        System.out.println("Spieler 3 Sie sind dran!");
        w3.w�rfeln();
        w3.w�rfelraus();
        w3.waehlen();
        System.out.println("");
        System.out.println("Spieler 4 Sie sind dran!");
        w4.w�rfeln();
        w4.w�rfelraus();
        w4.waehlen();
        }
       }
       
       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 1");
       System.out.println("          1er : " + w1.ergebnis[0]);
       System.out.println("          2er : " + w1.ergebnis[1]);
       System.out.println("          3er : " + w1.ergebnis[2]);
       System.out.println("          4er : " + w1.ergebnis[3]);
       System.out.println("          5er : " + w1.ergebnis[4]);
       System.out.println("          6er : " + w1.ergebnis[5]);
       
       if((w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5]) >= 63)
       {
         w1.ergebnis[5] = w1.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w1.ergebnis[6]);
       System.out.println("  Viererpasch : " + w1.ergebnis[7]);
       System.out.println("   Full-House : " + w1.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w1.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w1.ergebnis[10]);
       System.out.println("      Kniffel : " + w1.ergebnis[11]);
       System.out.println("       Chance : " + w1.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w1.ergebnis[0] + w1.ergebnis[1] + w1.ergebnis[2] + w1.ergebnis[3] + w1.ergebnis[4] + w1.ergebnis[5] + w1.ergebnis[6] + w1.ergebnis[7] + w1.ergebnis[8] + w1.ergebnis[9] + w1.ergebnis[10] + w1.ergebnis[11] + w1.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 2");
       System.out.println("          1er : " + w2.ergebnis[0]);
       System.out.println("          2er : " + w2.ergebnis[1]);
       System.out.println("          3er : " + w2.ergebnis[2]);
       System.out.println("          4er : " + w2.ergebnis[3]);
       System.out.println("          5er : " + w2.ergebnis[4]);
       System.out.println("          6er : " + w2.ergebnis[5]);
       
       if((w2.ergebnis[0] + w2.ergebnis[1] +  w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5]) >= 63)
       {
         w2.ergebnis[5] = w2.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w2.ergebnis[6]);
       System.out.println("  Viererpasch : " + w2.ergebnis[7]);
       System.out.println("   Full-House : " + w2.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w2.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w2.ergebnis[10]);
       System.out.println("      Kniffel : " + w2.ergebnis[11]);
       System.out.println("       Chance : " + w2.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w2.ergebnis[0] + w2.ergebnis[1] + w2.ergebnis[2] + w2.ergebnis[3] + w2.ergebnis[4] + w2.ergebnis[5] + w2.ergebnis[6] + w2.ergebnis[7] + w2.ergebnis[8] + w2.ergebnis[9] + w2.ergebnis[10] + w2.ergebnis[11] + w2.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 3");
       System.out.println("          1er : " + w3.ergebnis[0]);
       System.out.println("          2er : " + w3.ergebnis[1]);
       System.out.println("          3er : " + w3.ergebnis[2]);
       System.out.println("          4er : " + w3.ergebnis[3]);
       System.out.println("          5er : " + w3.ergebnis[4]);
       System.out.println("          6er : " + w3.ergebnis[5]);
       
       if((w3.ergebnis[0] + w3.ergebnis[1] +  w3.ergebnis[2] + w3.ergebnis[3] + w3.ergebnis[4] + w3.ergebnis[5]) >= 63)
       {
         w3.ergebnis[5] = w3.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w3.ergebnis[6]);
       System.out.println("  Viererpasch : " + w3.ergebnis[7]);
       System.out.println("   Full-House : " + w3.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w3.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w3.ergebnis[10]);
       System.out.println("      Kniffel : " + w3.ergebnis[11]);
       System.out.println("       Chance : " + w3.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w3.ergebnis[0] + w3.ergebnis[1] + w3.ergebnis[2] + w3.ergebnis[3] + w3.ergebnis[4] + w3.ergebnis[5] + w3.ergebnis[6] + w3.ergebnis[7] + w3.ergebnis[8] + w3.ergebnis[9] + w3.ergebnis[10] + w3.ergebnis[11] + w3.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 4");
       System.out.println("          1er : " + w4.ergebnis[0]);
       System.out.println("          2er : " + w4.ergebnis[1]);
       System.out.println("          3er : " + w4.ergebnis[2]);
       System.out.println("          4er : " + w4.ergebnis[3]);
       System.out.println("          5er : " + w4.ergebnis[4]);
       System.out.println("          6er : " + w4.ergebnis[5]);
       System.out.println("  Dreierpasch : " + w4.ergebnis[6]);
       
       if((w4.ergebnis[0] + w4.ergebnis[1] +  w4.ergebnis[2] + w4.ergebnis[3] + w4.ergebnis[4] + w4.ergebnis[5]) >= 63)
       {
         w4.ergebnis[5] = w4.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Viererpasch : " + w4.ergebnis[7]);
       System.out.println("   Full-House : " + w4.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w4.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w4.ergebnis[10]);
       System.out.println("      Kniffel : " + w4.ergebnis[11]);
       System.out.println("       Chance : " + w4.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w4.ergebnis[0] + w4.ergebnis[1] + w4.ergebnis[2] + w4.ergebnis[3] + w4.ergebnis[4] + w4.ergebnis[5] + w4.ergebnis[6] + w4.ergebnis[7] + w4.ergebnis[8] + w4.ergebnis[9] + w4.ergebnis[10] + w4.ergebnis[11] + w4.ergebnis[12]));

       System.out.println("          ...::: Ergebnis :::...");
       System.out.println("                Spieler 5");
       System.out.println("          1er : " + w5.ergebnis[0]);
       System.out.println("          2er : " + w5.ergebnis[1]);
       System.out.println("          3er : " + w5.ergebnis[2]);
       System.out.println("          4er : " + w5.ergebnis[3]);
       System.out.println("          5er : " + w5.ergebnis[4]);
       System.out.println("          6er : " + w5.ergebnis[5]);
       
       if((w5.ergebnis[0] + w5.ergebnis[1] +  w5.ergebnis[2] + w5.ergebnis[3] + w5.ergebnis[4] + w5.ergebnis[5]) >= 63)
       {
         w5.ergebnis[5] = w5.ergebnis[5] + 35;
         System.out.println("           Bonus: " + "35");
       }
       
       System.out.println("  Dreierpasch : " + w5.ergebnis[6]);
       System.out.println("  Viererpasch : " + w5.ergebnis[7]);
       System.out.println("   Full-House : " + w5.ergebnis[8]);
       System.out.println("Kleine Stra�e : " + w5.ergebnis[9]);
       System.out.println(" Gro�e Stra�e : " + w5.ergebnis[10]);
       System.out.println("      Kniffel : " + w5.ergebnis[11]);
       System.out.println("       Chance : " + w5.ergebnis[12]);
       System.out.println("");
       System.out.println("        Gesamt: " + (w5.ergebnis[0] + w5.ergebnis[1] + w5.ergebnis[2] + w5.ergebnis[3] + w5.ergebnis[4] + w5.ergebnis[5] + w5.ergebnis[6] + w5.ergebnis[7] + w5.ergebnis[8] + w5.ergebnis[9] + w5.ergebnis[10] + w5.ergebnis[11] + w5.ergebnis[12]));

       break;
       default:
       System.out.println("Ung�ltige Anzahl!");
       break;
     }
    

  }
}

class Wuerfel
{
  int[]w�rfel;
  boolean[]genutzt;
  int[]ergebnis;
  int einser;
  int zwergebnis;
  boolean[]zahlen;
  int[]w�rfel2;
  int[]sortieren;
  int[]zw;
  int[]raus;
  Random Zufall = new Random();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String w�rfelraus;
  
  public Wuerfel()
  {
     try {
      System.setOut(new java.io.PrintStream(System.out, true, "CP850"));
    } catch (java.io.UnsupportedEncodingException e) {
      System.out.println(e);
    }
    w�rfel = new int[5];
    genutzt = new boolean[13];
    ergebnis = new int[13];
    zahlen = new boolean[5];
    w�rfel2 = new int[2];
    sortieren = new int[5];
    zw = new int[4];
    raus = new int[5];
    einser = 0;
    zwergebnis = 0;
    w�rfelraus = "";
  }
  
  public void w�rfeln()
  {
    for(int i = 0; i < 5; i++)
    {
      w�rfel[i] = 1 + Zufall.nextInt(6);
      System.out.println("W�rfel " + (i+1) + " :  " + w�rfel[i]);
    }
  }
  
  public void anfangen()
  {
    w�rfel[0] = 1 + Zufall.nextInt(6);
  }
  
  public void waehlen() throws IOException
  {
    System.out.println("Als was soll ihr Wurf z�hlen?");
    if(genutzt[0] == false)
    {
      System.out.println("1. 1er");
    }
    if(genutzt[1] == false)
    {
      System.out.println("2. 2er");
    }
    if(genutzt[2] == false)
    {
      System.out.println("3. 3er");
    }
    if(genutzt[3] == false)
    {
      System.out.println("4. 4er");
    }
    if(genutzt[4] == false)
    {
      System.out.println("5. 5er");
    }
    if(genutzt[5] == false)
    {
      System.out.println("6. 6er");
    }
    
    System.out.println("");
    
    if(genutzt[6] == false)
    {
      System.out.println("7. Dreierpasch");
    }
    if(genutzt[7] == false)
    {
      System.out.println("8. Viererpasch");
    }
    if(genutzt[8] == false)
    {
      System.out.println("9. Full-House");
    }
    if(genutzt[9] == false)
    {
      System.out.println("10. Kleine Stra�e");
    }
    if(genutzt[10] == false)
    {
      System.out.println("11. Gro�e Stra�e");
    }
    if(genutzt[11] == false)
    {
      System.out.println("12. Kniffel");
    }
    if(genutzt[12] == false)
    {
      System.out.println("13. Chance");
    }
    int waehlen;
    waehlen = Integer.parseInt(br.readLine());
    switch(waehlen)
    {
      case 1:
      if(genutzt[0] == false)
      {
        this.einser();
        einser = 1;
        genutzt[0] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 2:
      if(genutzt[1] == false)
      {
        this.zweier();
        genutzt[1] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 3:
      if(genutzt[2] == false)
      {
        this.dreierr();
        genutzt[2] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 4:
      if(genutzt[3] == false)
      {
        this.viererrr();
        genutzt[3] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 5:
      if(genutzt[4] == false)
      {
        this.f�nfer();
        genutzt[4] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 6:
      if(genutzt[5] == false)
      {
        this.sechser();
        genutzt[5] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 7:
      if(genutzt[6] == false)
      {
        this.dreier();
        genutzt[6] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 8:
      if(genutzt[7] == false)
      {
        this.vierer();
        genutzt[7] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 9:
      if(genutzt[8] == false)
      {
        this.fullhouse();
        genutzt[8] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 10:
      if(genutzt[9] == false)
      {
        genutzt[9] = true;
        this.klstrasse();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 11:
      if(genutzt[10] == false)
      {
        genutzt[10] = true;
        this.grstrasse();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 12:
      if(genutzt[11] == false)
      {
        genutzt[11] = true;
        this.Kniffel();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      case 13:
      if(genutzt[12] == false)
      {
        genutzt[12] = true;
        this.Chance();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen();
      }
      break;
      
      default:
      System.out.println("Ung�ltige Eingabe");
      this.waehlen();
    }
    
  }

  public void w�rfelraus() throws IOException
  {
    boolean[]erf�llt;
    erf�llt = new boolean[5];
    boolean[]erf�llter;
    erf�llter = new boolean[5];
    System.out.println();
    System.out.println("Noch m�gliche K�stchen :");
    if(genutzt[0] == false)
    {
      System.out.println("1. 1er");
    }
    if(genutzt[1] == false)
    {
      System.out.println("2. 2er");
    }
    if(genutzt[2] == false)
    {
      System.out.println("3. 3er");
    }
    if(genutzt[3] == false)
    {
      System.out.println("4. 4er");
    }
    if(genutzt[4] == false)
    {
      System.out.println("5. 5er");
    }
    if(genutzt[5] == false)
    {
      System.out.println("6. 6er");
    }

    System.out.println("");

    if(genutzt[6] == false)
    {
      System.out.println("7. Dreierpasch");
    }
    if(genutzt[7] == false)
    {
      System.out.println("8. Viererpasch");
    }
    if(genutzt[8] == false)
    {
      System.out.println("9. Full-House");
    }
    if(genutzt[9] == false)
    {
      System.out.println("10. Kleine Stra�e");
    }
    if(genutzt[10] == false)
    {
      System.out.println("11. Gro�e Stra�e");
    }
    if(genutzt[11] == false)
    {
      System.out.println("12. Kniffel");
    }
    if(genutzt[12] == false)
    {
      System.out.println("13. Chance");
    }

    System.out.println("Welche W�rfel wollen sie neu w�rfeln?");
    w�rfelraus = br.readLine();

    for(int i = 0; i <w�rfelraus.length(); i++)
    {
     raus[i] = Integer.parseInt(w�rfelraus.substring(i,(i+1)));
    }
    
    if(raus[0] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[0] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }
    
    if(raus[1] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[1] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }
    
    if(raus[2] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[2] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }
    
    if(raus[3] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[3] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }
    
    if(raus[4] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[4] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }
    
    for(int i = 0; i < 5; i++)
    {
      System.out.println("W�rfel " + (i + 1) + " :  " + w�rfel[i]);
    }
    
    for(int i = 0; i < w�rfelraus.length(); i++)
    {
      raus[i] = 0;
    }
    
    System.out.println("Welche W�rfel wollen sie neu w�rfeln?");
    w�rfelraus = br.readLine();

    for(int i = 0; i <w�rfelraus.length(); i++)
    {
     raus[i] = Integer.parseInt(w�rfelraus.substring(i,(i+1)));
    }

    if(raus[0] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[0] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[1] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[1] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[2] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[2] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[3] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[3] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[4] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[4] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    for(int i = 0; i < 5; i++)
    {
      System.out.println("W�rfel " + (i + 1) + " :  " + w�rfel[i]);
    }

    for(int i = 0; i < w�rfelraus.length(); i++)
    {
      raus[i] = 0;
    }
    
  }
  
  public void einser()
  {
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == 1)
      {
        ergebnis[0] = ergebnis[0] + w�rfel[i];
      }
    }
  }
  
  public void zweier()
  {
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == 2)
      {
        ergebnis[1] = ergebnis[1] + w�rfel[i];
      }
    }
  }
  
  public void dreierr()
  {
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == 3)
      {
        ergebnis[2] = ergebnis[2] + w�rfel[i];
      }
    }
  }
  
  public void viererrr()
  {
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == 4)
      {
        ergebnis[3] = ergebnis[3] + w�rfel[i];
      }
    }
  }
  
  public void f�nfer()
  {
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == 5)
      {
        ergebnis[4] = ergebnis[4] + w�rfel[i];
      }
    }
  }
  
  public void sechser()
  {
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == 6)
      {
        ergebnis[5] = ergebnis[5] + w�rfel[i];
      }
    }
  }
  
  public void dreier()
  {
    boolean erf�llt = false;
    int erledigt = 0;
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == w�rfel[0])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[1])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[2])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[3])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[4])
      {
        erledigt = erledigt + 1;
      }
      if(erledigt > 2)
      {
        erf�llt = true;
        break;
      }
      else
      {
        erledigt = 0;
      }
    }
    if(erf�llt == true)
    {
      for(int x = 0; x < 5; x++)
      {
        ergebnis[6] = ergebnis[6] + w�rfel[x];
      }
    }
    else
    {
      ergebnis[6] = 0;
    }
    
  }
  
  public void vierer()
  {
    boolean erf�llt = false;
    int erledigt = 0;
    for(int i = 0; i < 5; i++)
    {
      if(w�rfel[i] == w�rfel[0])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[1])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[2])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[3])
      {
        erledigt = erledigt + 1;
      }
      if(w�rfel[i] == w�rfel[4])
      {
        erledigt = erledigt + 1;
      }
      if(erledigt > 3)
      {
        erf�llt = true;
        break;
      }
      else
      {
        erledigt = 0;
      }
    }
    if(erf�llt == true)
    {
      for(int x = 0; x < 5; x++)
      {
        ergebnis[7] = ergebnis[7] + w�rfel[x];
      }
    }
    else
    {
      ergebnis[7] = 0;
    }
    
    
  }
  
  public void fullhouse()
  {
    Arrays.sort(w�rfel);
    if(w�rfel[0] == w�rfel[1] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] || w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[3] == w�rfel[4])
    {
      ergebnis[8] = 25;
    }
    else
    {
      ergebnis[8] = 0;
    }
  }
        public void klstrasse()
        {
          Arrays.sort(w�rfel);


            sortieren[0] = w�rfel[4] - w�rfel[3];
            sortieren[1] = w�rfel[3] - w�rfel[2];
            sortieren[2] = w�rfel[2] - w�rfel[1];
            sortieren[3] = w�rfel[1] - w�rfel[0];
            if(sortieren[0] == 1 && sortieren[1] == 1 && sortieren[2] == 1 && sortieren[3] == 1 || sortieren[0] == 2 && sortieren[1] == 1 && sortieren[2] == 1 && sortieren[3] == 1 || sortieren[0] == 1 && sortieren[1] == 2 && sortieren[2] == 1 && sortieren[3] == 1 || sortieren[0] == 1 && sortieren[1] == 1 && sortieren[2] == 2 && sortieren[3] == 1 || sortieren[0] == 1 && sortieren[1] == 1 && sortieren[2] == 1 && sortieren[3] == 2 || sortieren[0] == 0 && sortieren[1] == 1 && sortieren[2] == 1 && sortieren[3] == 1 || sortieren[0] == 1 && sortieren[1] == 0 && sortieren[2] == 1 && sortieren[3] == 1 || sortieren[0] == 1 && sortieren[1] == 1 && sortieren[2] == 0 && sortieren[3] == 1 || sortieren[0] == 1 && sortieren[1] == 1 && sortieren[2] == 1 && sortieren[3] == 0)
            {
              ergebnis[9] = 30;
            }
            else
           {
             ergebnis[9] = 0;
             System.out.println("Keine Punkte!");
           }

        }


  public void grstrasse()
  {
          Arrays.sort(w�rfel);


            sortieren[0] = w�rfel[4] - w�rfel[3];
            sortieren[1] = w�rfel[3] - w�rfel[2];
            sortieren[2] = w�rfel[2] - w�rfel[1];
            sortieren[3] = w�rfel[1] - w�rfel[0];

            if(sortieren[0] == 1 && sortieren[1] == 1 && sortieren[2] == 1 && sortieren[3] == 1)
            {
              ergebnis[10] = 40;
            }
            else
            {
              ergebnis[10] = 0;
              System.out.println("Keine Punkte!");
            }


  }
  
  
  public void Kniffel()
  {
    if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4])
    {
      ergebnis[11] = 50;
    }
    
    else
    {
      ergebnis[11] = 0;
    }
  }
  
  public void Chance()
  {
    for(int i = 0; i < 5; i++)
    {
      ergebnis[12] = ergebnis[12] + w�rfel[i];
    }
  }
  
  public void w�rfelraus2() throws IOException
  {
    boolean[]erf�llt;
    erf�llt = new boolean[5];
    boolean[]erf�llter;
    erf�llter = new boolean[5];

    System.out.println("Welche W�rfel wollen sie neu w�rfeln?");
    w�rfelraus = this.suchen();

    for(int i = 0; i <w�rfelraus.length(); i++)
    {
     raus[i] = Integer.parseInt(w�rfelraus.substring(i,(i+1)));
    }

    if(raus[0] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[0] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }

    if(raus[1] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[1] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }

    if(raus[2] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[2] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }

    if(raus[3] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[3] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }

    if(raus[4] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[4] - 1) == i && erf�llt[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llt[i] = true;
         break;
       }
     }
    }

    for(int i = 0; i < 5; i++)
    {
      System.out.println("W�rfel" + (i + 1) + " " + w�rfel[i]);
    }

    for(int i = 0; i < w�rfelraus.length(); i++)
    {
      raus[i] = 0;
    }

    System.out.println("Welche W�rfel wollen sie neu w�rfeln?");
    w�rfelraus = this.suchen();

    for(int i = 0; i <w�rfelraus.length(); i++)
    {
     raus[i] = Integer.parseInt(w�rfelraus.substring(i,(i+1)));
    }

    if(raus[0] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[0] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[1] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[1] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[2] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[2] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[3] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[3] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    if(raus[4] > 0)
    {
     for(int i = 0; i < 5; i++)
     {
       if((raus[4] - 1) == i && erf�llter[i] == false)
       {
         w�rfel[i] = 1 + Zufall.nextInt(6);
         erf�llter[i] = true;
         break;
       }
     }
    }

    for(int i = 0; i < 5; i++)
    {
      System.out.println("W�rfel" + (i+1) + " " + w�rfel[i]);
    }

    for(int i = 0; i < w�rfelraus.length(); i++)
    {
      raus[i] = 0;
    }

  }

  public void waehlen2()
  {
    System.out.println("Als was soll ihr Wurf z�hlen?");
    if(genutzt[0] == false)
    {
      System.out.println("1. 1er");
    }
    if(genutzt[1] == false)
    {
      System.out.println("2. 2er");
    }
    if(genutzt[2] == false)
    {
      System.out.println("3. 3er");
    }
    if(genutzt[3] == false)
    {
      System.out.println("4. 4er");
    }
    if(genutzt[4] == false)
    {
      System.out.println("5. 5er");
    }
    if(genutzt[5] == false)
    {
      System.out.println("6. 6er");
    }

    System.out.println("");

    if(genutzt[6] == false)
    {
      System.out.println("7. Dreierpasch");
    }
    if(genutzt[7] == false)
    {
      System.out.println("8. Viererpasch");
    }
    if(genutzt[8] == false)
    {
      System.out.println("9. Full-House");
    }
    if(genutzt[9] == false)
    {
      System.out.println("10. Kleine Stra�e");
    }
    if(genutzt[10] == false)
    {
      System.out.println("11. Gro�e Stra�e");
    }
    if(genutzt[11] == false)
    {
      System.out.println("12. Kniffel");
    }
    if(genutzt[12] == false)
    {
      System.out.println("13. Chance");
    }
    int waehlen;
    waehlen = Integer.parseInt(this.erkennen());
    switch(waehlen)
    {
      case 1:
      if(genutzt[0] == false)
      {
        this.einser();
        einser = 1;
        genutzt[0] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 2:
      if(genutzt[1] == false)
      {
        this.zweier();
        genutzt[1] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 3:
      if(genutzt[2] == false)
      {
        this.dreierr();
        genutzt[2] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 4:
      if(genutzt[3] == false)
      {
        this.viererrr();
        genutzt[3] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 5:
      if(genutzt[4] == false)
      {
        this.f�nfer();
        genutzt[4] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 6:
      if(genutzt[5] == false)
      {
        this.sechser();
        genutzt[5] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 7:
      if(genutzt[6] == false)
      {
        this.dreier();
        genutzt[6] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 8:
      if(genutzt[7] == false)
      {
        this.vierer();
        genutzt[7] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 9:
      if(genutzt[8] == false)
      {
        this.fullhouse();
        genutzt[8] = true;
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 10:
      if(genutzt[9] == false)
      {
        genutzt[9] = true;
        this.klstrasse();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 11:
      if(genutzt[10] == false)
      {
        genutzt[10] = true;
        this.grstrasse();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 12:
      if(genutzt[11] == false)
      {
        genutzt[11] = true;
        this.Kniffel();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      case 13:
      if(genutzt[12] == false)
      {
        genutzt[12] = true;
        this.Chance();
      }
      else
      {
        System.out.println("Dieses Feld wurde schon genutzt!");
        this.waehlen2();
      }
      break;

      default:
      System.out.println("Ung�ltige Eingabe");
      this.waehlen2();
    }

  }

  public String erkennen()
  {
   Arrays.sort(w�rfel);
   if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[11] == false) // Kniffel?
   {
     return "12";
   }
   else if((w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 && genutzt[10] == false)  // Gro�eStra�e?
   {
     return "11";
   }
   else if((w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) != 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) != 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) != 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) != 1 && genutzt[9]  == false)  // kleineStra�e?
   {
     return "10";
   }
   else if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[3] == w�rfel[4] || w�rfel[0] == w�rfel[1] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4]  && genutzt[8] == false) // Full House?
   {
     return "9";
   }
   else if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] || w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[7] == false)  // Viererpasch?
   {
     return "8";
   }
   else if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && genutzt[6] == false)  // Dreierpasch1
   {
    return "7";
   }
   else if(w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && genutzt[6] == false)  // Dreierpasch2
   {
     return "7";
   }
   else if(w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[6] == false)  // Dreierpasch3
   {
    return "7";
   }
   else if(w�rfel[4] == 6 && w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[5] == false || w�rfel[4] == 6 && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[5] == false || w�rfel[4] == 6 && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[5] == false)
   {
     return "6";
   }
   else if(w�rfel[4] == 5 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[4] == false || w�rfel[4] == 5 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && genutzt[4] == false || w�rfel[4] == 5 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[4] == false || w�rfel[4] == 5 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && genutzt[4] == false || w�rfel[3] == 5 && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[4] == false || w�rfel[2] == 5 && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[4] == false || w�rfel[2] == 5 && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && genutzt[4] == false)
   {
     return "5";
   }
   else if(w�rfel[4] == 4 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[3] == false || w�rfel[4] == 4 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && genutzt[3] == false || w�rfel[4] == 4 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[3] == false || w�rfel[4] == 4 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && genutzt[3] == false || w�rfel[3] == 4 && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[3] == false || w�rfel[2] == 4 && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[3] == false || w�rfel[2] == 4 && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && genutzt[3] == false)
   {
     return "4";
   }
   else if(w�rfel[4] == 3 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[2] == false || w�rfel[4] == 3 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && genutzt[2] == false || w�rfel[4] == 3 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[2] == false || w�rfel[4] == 3 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && genutzt[2] == false || w�rfel[3] == 3 && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[2] == false || w�rfel[2] == 3 && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[2] == false || w�rfel[2] == 3 && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && genutzt[2] == false)
   {
     return "3";
   }
   else if(w�rfel[4] == 2 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[1] == false || w�rfel[4] == 2 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && genutzt[1] == false || w�rfel[1] == 2 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[1] == false || w�rfel[4] == 2 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && genutzt[1] == false || w�rfel[3] == 2 && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[1] == false || w�rfel[2] == 2 && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[1] == false || w�rfel[2] == 2 && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && genutzt[1] == false)
   {
     return "2";
   }
   else if(w�rfel[4] == 5 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[0] == false || w�rfel[4] == 1 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && genutzt[0] == false || w�rfel[4] == 1 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[0] == false || w�rfel[4] == 1 && w�rfel[4] == w�rfel[3] && w�rfel[3] == w�rfel[2] && genutzt[0] == false || w�rfel[3] == 1 && w�rfel[3] == w�rfel[2] && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[0] == false || w�rfel[2] == 1 && w�rfel[2] == w�rfel[1] && w�rfel[1] == w�rfel[0] && genutzt[0] == false || w�rfel[2] == 1 && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && genutzt[0] == false)
   {
     return "3";
   }
   else
   {
    String speicher = " ";
    for(int i = 0; i < 13; i++)
    {
      if(genutzt[i] == false)
      {
        speicher.replace(' ', ((char)i));
        return speicher;
      }
      if(genutzt[i] == false)
      {
        break;
      }
    }
   }
   return "0";
  }

  public String suchen()
  {
   Arrays.sort(w�rfel);
   if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[11] == false) // Kniffel?
   {
     return "0";
   }
   else if((w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 && genutzt[10] == false)  // Gro�eStra�e?
   {
     return "0";
   }
   else if((w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) != 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) != 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) != 1 && (w�rfel[1] - w�rfel[0]) == 1 || (w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) != 1 && genutzt[9]  == false)  // kleineStra�e?
   {
     return "0";
   }
   else if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[3] == w�rfel[4] || w�rfel[0] == w�rfel[1] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4]  && genutzt[8] == false) // Full House?
   {
     return "0";
   }
   else if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] || w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[7] == false)  // Viererpasch?
   {
     return "0";
   }
   else if(w�rfel[0] == w�rfel[1] && w�rfel[1] == w�rfel[2] && genutzt[6] == false)  // Dreierpasch1
   {
    return "45";
   }
   else if(w�rfel[1] == w�rfel[2] && w�rfel[2] == w�rfel[3] && genutzt[6] == false)  // Dreierpasch2
   {
     return "15";
   }
   else if(w�rfel[2] == w�rfel[3] && w�rfel[3] == w�rfel[4] && genutzt[6] == false)  // Dreierpasch3
   {
    return "12";
   }
   else if((w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 && genutzt[10] == false) // Gr Stra�enbau
   {
     return "5";
   }
   else if((w�rfel[4] - w�rfel[2]) == 2 && (w�rfel[3] - w�rfel[2]) != 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) == 1 && genutzt[10] == false) // Gr Stra�enbau
   {
     return "4";
   }
   else if((w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[1]) == 2 && (w�rfel[2] - w�rfel[1]) != 1 && (w�rfel[1] - w�rfel[0]) == 1 && genutzt[10] == false) // Gr Stra�enbau
   {
     return "3";
   }
   else if((w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[0]) == 2 && (w�rfel[1] - w�rfel[0]) != 1 && genutzt[10] == false) // Gr Stra�enbau
   {
     return "2";
   }
   else if((w�rfel[4] - w�rfel[3]) == 1 && (w�rfel[3] - w�rfel[2]) == 1 && (w�rfel[2] - w�rfel[1]) == 1 && (w�rfel[1] - w�rfel[0]) != 1 && genutzt[10] == false) // Gr Stra�enbau
   {
     return "1";
   }
   else
   {
     return "12345";
   }

  }
 }