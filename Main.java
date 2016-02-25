/*
Author: Kacper �ukasik
Name: Zadanie_1
*/

package zadanie1;

import java.util.ArrayList;
import java.util.Random;

public class Zadanie1 {
    
    public static Random Generator = new Random();
    public static ArrayList<Integer> ListOfNumbers = new ArrayList<Integer>();
    
    //Metoda sprawdzaj�ca czy podana liczba jest parzysta
    public static String CheckEven(int Number)
    {
        if(Number%2 == 0)
            return "parzysta";
        return "nie parzysta";
    }
    
    //Metoda sprawdzaj�ca czy dana liczba zosta�a ju� wylosowana
    //Jezeli nie zostaje dodana do listy wylosowanych liczb
    public static boolean CheckList(int Number)
    {
        if(!ListOfNumbers.contains(Number))
        {
            ListOfNumbers.add(Number);
            return true;
        }
        /*  TUTAJ tkwi haczyk. Specjalnie zosta� tutaj wdro�ony b��d
            Po wygenerowaniu liczby, kt�ra zosta�a juz wylosowana
            Nast�puje powi�kszenie o 1 wygenerowanej liczby.
            I tutaj twoje zadanie przerob kod, aby generowa� losow� liczbe po 
            nieudaniej pr�bie, a nie dodawa� do niej jedynki*/
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
    //Metoda generuj�ca podan� ilo�� liczb
    public static void GenerateNumber(int Size)
    {
        for(int i = 0; i < Size; i++)
        {
            CheckList(Generator.nextInt(101));
        }
    }
    
    public static void main(String[] args)
    {
        //Wywo�anie metody GenerateNumber, kt�rea wylosuje 10 liczb
        GenerateNumber(10);
        
        //Pentla for kt�ra wypisuje zawarto�� Listy ListOfNumbers
        for(int N : ListOfNumbers)
        {
            System.out.println("Liczba " + N + " jest " + CheckEven(N));
        }
    }
    
}