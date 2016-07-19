package by.it.sereda.jd01_14;

import java.io.*;
import java.util.Scanner;

public class TaskB {

    static void countMarksWords() throws FileNotFoundException {

        String src = System.getProperty("user.dir") + "/src/by/it/sereda/";
        String filename = src + "jd01_14/TextFile.txt";
        File file = new File(filename);
        Scanner marksMatcher = new Scanner(file);
        marksMatcher.useDelimiter("[^.!?,-:;]*");
        int counterForMarks = 0;
        while (marksMatcher.hasNext()) {
            marksMatcher.next(); ++counterForMarks;
        }
        marksMatcher.close();
        System.out.println("Количество знаков препинания в тексте:" + counterForMarks);


        Scanner marksWords = new Scanner(file);
        marksWords.useDelimiter("[^a-zA-z]*");
        int counterForWords = 0;
        while (marksWords.hasNext()) {
            marksWords.next();
            ++counterForWords;
        }
        marksWords.close();
        System.out.println("Количество слов в тексте:" + counterForWords);

    }
}
