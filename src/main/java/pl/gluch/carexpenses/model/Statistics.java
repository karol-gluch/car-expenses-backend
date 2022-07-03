package pl.gluch.carexpenses.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Statistics {
    private final Long numberOfExpenses;
    private final BigDecimal sumOfCosts;
    private final Map<String, BigDecimal> sumOfCostsByCategory;
}