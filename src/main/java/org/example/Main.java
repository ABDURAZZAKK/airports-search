package org.example;


import java.io.*;


public class Main {


    static BufferedReader readerIn = null;
    static final String sep = ";";
    static String sub = " ";
    static long time;
    static MemoryFileSearch file = null;


    public static void main(String[] args){
        try {
            readerIn = new BufferedReader(new InputStreamReader(System.in));
            int column;
            if (args.length > 0)
                column = Integer.parseInt(args[0].trim());
            else{
                System.out.println("Enter column number:");
                column = Integer.parseInt(readerIn.readLine().trim());}

            file = new MemoryFileSearch("src/words.dat");

            int colCount = file.columnCount(sep);
            if(colCount >= column && column > 0)
            while(true) {

                System.out.println("Enter a substring:");
                sub = readerIn.readLine().trim().toLowerCase();

                time = System.currentTimeMillis();
                if (sub.equals("!quit"))
                    break;

                int count=0;
                for(String line : file.search(sub, sep, column)){
                    count++;
                    System.out.println(line);
                }

                time = System.currentTimeMillis() - time;
                System.out.println("\n\n" + "lines: " + count + "," + "time: " + time + " ms");

            }
            else{
                System.out.println("Please enter number 1 < x"+" < "+colCount);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number !!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
