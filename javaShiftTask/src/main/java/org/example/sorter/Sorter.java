package org.example.sorter;

import org.example.storageSortedData.SortedData;
import org.example.storageSortedData.dataTypes.StringData;
import org.example.storageSortedData.dataTypes.numberDataTypes.DoubleData;
import org.example.storageSortedData.dataTypes.numberDataTypes.IntData;

public class Sorter {
    String[] lines;

    StringData sd = new StringData();
    IntData id = new IntData();
    DoubleData doud = new DoubleData();
    SortedData[] SD = {sd, id, doud};

    public Sorter(String[] lines) {
        this.lines = lines;
        for( String line : lines ) identifyType(line);
    }


    public SortedData[] GetStrIntDbl(){ return SD; };

    // Метод сортировки исходных данных по соответствующим объектам
    private void identifyType(String str) {
        if (str == null || str.trim().isEmpty()) {
            sd.SetSortedData(str);
            return;
        }
        try {
            int value = Integer.parseInt(str.trim());
            id.SetSortedData(value);
            return;
        } catch (NumberFormatException e) {
            //не int проверяем дальше
        }

        try {
            doud.SetSortedData(Double.parseDouble(str.trim()));
            return;
        } catch (NumberFormatException e) {
            //и не double, оставляем String
        }
        sd.SetSortedData(str);
    }
}

