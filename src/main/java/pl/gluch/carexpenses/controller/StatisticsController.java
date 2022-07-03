package pl.gluch.carexpenses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gluch.carexpenses.model.Statistics;
import pl.gluch.carexpenses.service.StatisticsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/statistics")
@CrossOrigin(origins = "http://localhost:4200")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public Statistics getStatistics() {
        return statisticsService.getStatistics();
    }
}