package org.example.storageSortedData.dataTypes;

import org.example.storageSortedData.SortedData;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberData<T extends Number> extends SortedData {
    protected List<T> values = new ArrayList<>();
    protected double sum = 0;
    protected double min = Double.MAX_VALUE;
    protected double max = Double.MIN_VALUE;

    // Метод для добавления данных
    public void SetSortedData(T value) {
        values.add(value);
        strings.add(value.toString());
        updateStatistics(value);
    }

    // Обновление статистики
    private void updateStatistics(T value) {
        double numericValue = value.doubleValue();
        min = Math.min(numericValue, min);
        max = Math.max(numericValue, max);
        sum += numericValue;
    }

    // Вычисление среднего значения
    protected double getAverage() {
        return !values.isEmpty() ? sum / values.size() : 0;
    }

    public abstract String FullStatistic();

}
