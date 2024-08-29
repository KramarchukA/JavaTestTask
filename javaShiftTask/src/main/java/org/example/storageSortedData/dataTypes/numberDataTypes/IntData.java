package org.example.storageSortedData.dataTypes.numberDataTypes;

import org.example.storageSortedData.dataTypes.NumberData;

public class IntData extends NumberData<Integer> {

    // Метод для получения полной статистики
    public String FullStatistic() {
        return String.format(
                """

                        Sum: %d\

                        Minimum element: %d\

                        Maximum element: %d\

                        Average: %.2f""",
                (int) sum, (int) min, (int) max, getAverage()
        );
    }
}