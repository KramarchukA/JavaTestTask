package org.example;

import org.example.fileProcessors.FileProcessor;
import org.example.sorter.Sorter;
import org.example.storageSortedData.SortedData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        List<String> inputFiles = new ArrayList<>();
        String outputPath = ".";
        String prefix = "";
        boolean append = false;
        boolean fullStats = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (++i < args.length) {
                        outputPath = args[i];
                    } else {
                        System.err.println("Missing argument for -o");
                        System.exit(1);
                    }
                    break;
                case "-p":
                    if (++i < args.length) {
                        prefix = args[i];
                    } else {
                        System.err.println("Missing argument for -p");
                        System.exit(1);
                    }
                    break;
                case "-a":
                    append = true;
                    break;
                case "-s":
                    fullStats = false;
                    break;
                case "-f":
                    fullStats = true;
                    break;
                default:
                    inputFiles.add(args[i]);
            }
        }

        // получаем данные из всех файлов в переменную DataFromFiles
        List<String> DataFromFiles = new ArrayList<>();
        FileProcessor fileProcessor = new FileProcessor();
        for(String file: inputFiles) {
            DataFromFiles.addAll(fileProcessor.GetFromFile(file));
        }

        // сортируем данные по соответствующим объектам
        SortedData[] SD;
        Sorter sorter = new Sorter( DataFromFiles.toArray(new String[DataFromFiles.size()]));
        SD = sorter.GetStrIntDbl();

        //запись результатов в файлы
        String[] names = {"strings.txt","integers.txt", "floats.txt"};
        for (int i = 0; i< SD.length; i++){
            fileProcessor.writeFile(outputPath, prefix, names[i], append, SD[i].GetSortedData());
        }
//        fileProcessor.writeFile(outputPath, prefix, "strings.txt", append, SD[0].GetSortedData());
//        fileProcessor.writeFile(outputPath, prefix, "integers.txt", append, SD[1].GetSortedData());
//        fileProcessor.writeFile(outputPath, prefix, "floats.txt", append, SD[2].GetSortedData());


        //вывод статистики
        if (fullStats) {
            for (int i = 0; i< SD.length; i++){
                System.out.println(names[i]);
                System.out.println(SD[i].FullStatistic());
                System.out.println();
            }
        }
        else{
            for (int i = 0; i< SD.length; i++){
                System.out.println(names[i]);
                System.out.println(SD[i].ShortStatistic());
                System.out.println();
            }
        }
    }
}