package gr.manolis.steli.markets;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class ApiController {

    @GetMapping("/")
    public Stock requestStockData() {

        Stock stock = new Stock();
        
        String apiHost = "apidojo-yahoo-finance-v1.p.rapidapi.com";
        String apiKey = "e786518fa5mshb3523f0c5b920ccp1cef98jsnde6590e82b86";
        
        String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-summary";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpGet request = new HttpGet(url + "?symbol=AMRN");
            request.addHeader("x-rapidapi-host", apiHost);
            request.addHeader("x-rapidapi-key", apiKey);
            
            try(CloseableHttpResponse response = httpClient.execute(request)) {

                // Get HttpResponse Status
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);

                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode rootNode = mapper.readTree(result);

                    stock.setStockData(getStockData(rootNode));
                    stock.setStockStatistics(getStockStatistics(rootNode));
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return stock;
    }

    private StockData getStockData(JsonNode rootNode) {
        StockData stockData = new StockData();
        stockData.setName(
            rootNode.get("price")
                    .get("longName")
            .asText()
        );
        stockData.setPrice(
            rootNode.get("price")
                    .get("regularMarketPrice")
                    .get("raw")
            .asDouble());
        stockData.setCurrency(
                rootNode.get("price")
                        .get("currency")
                .asText()
        );
        stockData.setSymbol(
                rootNode.get("price")
                        .get("symbol")
                .asText()
        );
        
        return stockData;
    }
    
    private StockStatistics getStockStatistics(JsonNode rootNode) {
        StockStatistics stockStatistics = new StockStatistics();
        stockStatistics.setBeta(
                rootNode.get("defaultKeyStatistics")
                        .get("beta")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setEnterpriseToEBITDA(
                rootNode.get("defaultKeyStatistics")
                        .get("enterpriseToEbitda")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setEnterpriseToRevenue(
                rootNode.get("defaultKeyStatistics")
                        .get("enterpriseToRevenue")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setBookValue(
                rootNode.get("defaultKeyStatistics")
                        .get("bookValue")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setForwardEPS(
                rootNode.get("defaultKeyStatistics")
                        .get("forwardEps")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setPeg(
                rootNode.get("defaultKeyStatistics")
                        .get("pegRatio")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setForwardPE(
                rootNode.get("defaultKeyStatistics")
                        .get("forwardPE")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setProfitMargin(
                rootNode.get("defaultKeyStatistics")
                        .get("profitMargins")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setPriceToBook(
                rootNode.get("defaultKeyStatistics")
                        .get("priceToBook")
                        .get("raw")
                .asDouble()
        );
        stockStatistics.setTrailingEPS(
                rootNode.get("defaultKeyStatistics")
                        .get("trailingEps")
                        .get("raw")
                .asDouble()
        );

        return stockStatistics;
    }

}
