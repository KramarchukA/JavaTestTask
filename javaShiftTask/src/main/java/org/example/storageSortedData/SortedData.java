package org.example.storageSortedData;

import java.util.ArrayList;
import java.util.List;

public abstract class SortedData {
    protected List<String> strings = new ArrayList<String>();

    //метод для получения данных
    public String GetSortedData(){
        return String.join("\n", strings);
    };

    // Метод для получения краткой статистики
    public String ShortStatistic(){
        return "Number of elements: " + String.valueOf(strings.size());
    };
    // Метод для получения полной статистики
    public abstract String FullStatistic();

    public String toString() {
        return FullStatistic();
    }
}
