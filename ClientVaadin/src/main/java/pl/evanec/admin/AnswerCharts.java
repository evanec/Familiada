package pl.evanec.admin;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import pl.evanec.QuestionTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AnswerCharts extends VerticalLayout {
    List<QuestionTO> questions = null;
    Select<QuestionTO> labelSelect = new Select<>();
    HorizontalLayout charts = new HorizontalLayout();


    public AnswerCharts(List<QuestionTO> questions, AdminPresenter presenter) {
        this.questions = questions;
        charts.setWidth("1000px");
        labelSelect.setItems(questions);
        labelSelect.setLabel("Select question");
        labelSelect.addValueChangeListener((value) -> {
            charts.removeAll();
            ApexCharts one = addChart(value.getValue());
            ApexCharts two = ApexSucksCharts(value.getValue());
            charts.add(one);
            charts.add(two);
        });
        labelSelect.setValue(questions.get(0));
        add(labelSelect);
        add(charts);
    }

    public static <T> Collector<T, ?, Double> counting() {
        return Collectors.summingDouble((e) -> {
            return 1L;
        });
    }

    private ApexCharts addChart(QuestionTO question) {
        Map<String, Double> counts = question.getAnswers().stream().filter(e -> !e.isQuestionSucks()).collect(Collectors.groupingBy(e -> e.getAnswerStandardized(), counting()));
        ApexCharts pieChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get().withType(Type.pie).withWidth("450").withHeight("450").build())
                .withLabels(counts.keySet().toArray(new String[counts.keySet().size()]))
                .withSeries(counts.values().toArray(Double[]::new))
                .build();
        return pieChart;
    }

    private ApexCharts ApexSucksCharts(QuestionTO question) {
        Double sumOfSucks = question.getAnswers().stream().filter(e -> e.isQuestionSucks()).count() + 0.0;
        Double sumOfOther = question.getAnswers().size() - sumOfSucks;

        ApexCharts pieChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get().withType(Type.pie).withWidth("500").withHeight("500").build())
                .withLabels("Proper answers", "Sucks")
                .withSeries(sumOfOther, sumOfSucks)
                .build();
        return pieChart;
    }
}
