package org.example.storageSortedData.dataTypes.numberDataTypes;

import org.example.storageSortedData.dataTypes.NumberData;

public class DoubleData extends NumberData<Double> {

    // Метод для получения полной статистики
    public String FullStatistic() {
        return String.format(
                """

                        Sum: %.2f\

                        Minimum element: %s\

                        Maximum element: %s\

                        Average: %.2f""",
                sum, min, max, getAverage()
        );
    }
}
