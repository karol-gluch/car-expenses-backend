package pl.gluch.carexpenses.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gluch.carexpenses.exception.EmptyStatisticsException;
import pl.gluch.carexpenses.model.Statistics;
import pl.gluch.carexpenses.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final ExpenseRepository expenseRepository;

    public Statistics getStatistics() {
        Long numberOfExpenses = expenseRepository.getNumberOfExpenses();
        if(numberOfExpenses > 0) {
            BigDecimal sumOfCosts = expenseRepository.getSumOfCosts();
            List<Object[]> costsAndCategories = expenseRepository.getSumOfCostsByCategory();
            Map<String, BigDecimal> sumOfCostsByCategory = getCostsAndCategoriesMap(costsAndCategories);
            return new Statistics(numberOfExpenses, sumOfCosts, sumOfCostsByCategory);
        } else {
            throw new EmptyStatisticsException("Empty expenses");
        }
    }

    private Map<String, BigDecimal> getCostsAndCategoriesMap(List<Object[]> costsAndCategories) {
        Map<String, BigDecimal> costsAndCategoriesMap = new HashMap<>();
        for(Object[] value : costsAndCategories) {
            costsAndCategoriesMap.put((String) value[0], (BigDecimal) value[1]);
        }
        return costsAndCategoriesMap;
    }
}