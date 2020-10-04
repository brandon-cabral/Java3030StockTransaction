package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.StockData;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class StockDataTest {

    @Test
    public void stockDataInitTest(){
        StockData stockData = new StockData() {
            @Override
            public String toString() {
                return super.toString();
            }
        };

        assertNotNull(stockData);

    }

}
