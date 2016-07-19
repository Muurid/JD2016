package by.it.sereda.jd01_14;

import java.io.*;

public class Runner {

    public static void main(String[] args) throws IOException {
        System.out.println("Running Task A");
        TaskA.generatorRandomFile();
        System.out.println();
        System.out.println("Running TaskB");
        TaskB.countMarksWords();
        System.out.println();
        System.out.println("Running TaskC");
        TaskC.printCatalog();
    }

}
