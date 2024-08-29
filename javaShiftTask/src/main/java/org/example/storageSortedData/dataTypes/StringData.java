package org.example.storageSortedData.dataTypes;

import org.example.storageSortedData.SortedData;

public class StringData extends SortedData {

    private int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private String minStr; private String maxStr;

    // Метод для добавления данных
    public void SetSortedData(String a){
        strings.add(a);
        updateStatistics(a);
    };

    // Обновление статистики
    private void updateStatistics(String a) {
        int len = a.length();
        min = Math.min(len, min); if(min==len)minStr=a;
        max = Math.max(len, max); if(max==len)maxStr=a;
    }
    public String FullStatistic(){
        return "Number of elements: " + String.valueOf(strings.size())
                +"\nMinimum length: " + min + "\nMaximum length: " + max
                +"\nMin string: " + minStr + "\nMax string: " + maxStr;
    };
}

