/*
Author: Kacper £ukasik
Name: Zadanie_1
*/

package zadanie1;

import java.util.ArrayList;
import java.util.Random;

public class Zadanie1 {
    
    public static Random Generator = new Random();
    public static ArrayList<Integer> ListOfNumbers = new ArrayList<Integer>();
    
    //Metoda sprawdzaj¹ca czy podana liczba jest parzysta
    public static String CheckEven(int Number)
    {
        if(Number%2 == 0)
            return "parzysta";
        return "nie parzysta";
    }
    
    //Metoda sprawdzaj¹ca czy dana liczba zosta³a ju¿ wylosowana
    //Jezeli nie zostaje dodana do listy wylosowanych liczb
    public static boolean CheckList(int Number)
    {
        if(!ListOfNumbers.contains(Number))
        {
            ListOfNumbers.add(Number);
            return true;
        }
        /*  TUTAJ tkwi haczyk. Specjalnie zosta³ tutaj wdro¿ony b³¹d
            Po wygenerowaniu liczby, która zosta³a juz wylosowana
            Nastêpuje powiêkszenie o 1 wygenerowanej liczby.
            I tutaj twoje zadanie przerob kod, aby generowa³ losow¹ liczbe po 
            nieudaniej próbie, a nie dodawa³ do niej jedynki*/
        else
        {
            int Counter = 1;
            while(true)
            {
                if(!ListOfNumbers.contains(Number+Counter))
                {
                    ListOfNumbers.add(Number+Counter);
                    break;
                }
                Counter++;
            }
            return true;
        }
            
    }
    //Metoda generuj¹ca podan¹ iloœæ liczb
    public static void GenerateNumber(int Size)
    {
        for(int i = 0; i < Size; i++)
        {
            CheckList(Generator.nextInt(101));
        }
    }
    
    public static void main(String[] args)
    {
        //Wywo³anie metody GenerateNumber, którea wylosuje 10 liczb
        GenerateNumber(10);
        
        //Pentla for która wypisuje zawartoœæ Listy ListOfNumbers
        for(int N : ListOfNumbers)
        {
            System.out.println("Liczba " + N + " jest " + CheckEven(N));
        }
    }
    
}