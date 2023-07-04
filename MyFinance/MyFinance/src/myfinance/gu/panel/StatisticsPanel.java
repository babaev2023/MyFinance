
package myfinance.gu.panel;

import javax.swing.JPanel;
import myfinance.gu.Chart;
import myfinance.gu.MainFrame;
import myfinance.model.Statistics;
import myfinance.saveload.SaveData;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class StatisticsPanel extends RightPanel{
    
    public static final int TYPE_INCOME = 0;
    public static final int TYPE_EXP = 1;
    private int type = TYPE_INCOME;

    public StatisticsPanel(MainFrame frame) {
        super(frame, null, "STATISTICS", Style.ICON_PANEL_STATISTICS,
            new JPanel[]{
                new FilterPanel(frame),
                new StatisticsTypePanel(frame, "CHART_INCOME"),
                new Chart(Statistics.getDataForChartOnIncomeArticles(), "CHART_INCOME", SaveData.getInstance().getBaseCurrency().getCode()).getPanel()
            }); //Период, .. , График
    }
    
    public void nextType() {
        type++;
        if (type > TYPE_EXP) type = TYPE_INCOME;
    }
    
    @Override
    public void refresh() {
        Chart chart = null;
        String title = null;
        if (type == TYPE_INCOME) {
            title = "CHART_INCOME";
            chart =  new Chart(Statistics.getDataForChartOnIncomeArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        else if (type == TYPE_EXP) {
            title = "CHART_EXP";
            chart =  new Chart(Statistics.getDataForChartOnExpArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        setPanels(new JPanel[]{
                new FilterPanel(frame),
                new StatisticsTypePanel(frame, title),
                chart.getPanel()
            });
        super.refresh();
    }
    
}
