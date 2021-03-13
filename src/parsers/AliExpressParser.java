package parsers;

import frame.Messages;
import frame.SimpleFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import products.AliExpressProduct;
import urlqueries.AliExpressURLQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс для парсинга данных о товарах на Aliexpress
 */
public class AliExpressParser implements Parser<AliExpressProduct> {

    /**
     * Метод запрашивающий ответ с сервера и выполняющий парсинг товаров из полученного ответа
     * @param frame объект окна SimpleFrame для вывода в окно
     * сообщения о ходе выполнения программы
     * @return список объектов товаров с Aliexpress последующей его передачи на вывод
     */
    @Override
    public List<AliExpressProduct> getParsedProductList(SimpleFrame frame) {

        List<String> urlQueryList = AliExpressURLQueries.getQueryList();
        List<AliExpressProduct> aliProductsList = new ArrayList<>();
        int productId = 1;


        for (String queryUrl : urlQueryList) {
            HttpURLConnection connection = null;
            StringBuffer strBuff = new StringBuffer();
            try {
                URL urlObj = new URL(queryUrl);
                connection = (HttpURLConnection) urlObj.openConnection();
                connection.setConnectTimeout(5000);

                try (BufferedReader buffReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {

                    String inputLine;
                    while ((inputLine = buffReader.readLine()) != null) {
                        strBuff.append(inputLine);
                    }
                } catch (IOException readExc) {
                    frame.setMessage(Messages.IO_EXCEPTION);
                }
            } catch (MalformedURLException e) {
                frame.setMessage(Messages.MALFORMED_EXCEPTION);
            } catch (IOException e) {
                //
            }
            connection.disconnect();
            String resp = strBuff.toString();
            JSONParser jsonParser = new JSONParser();
            Object object = null;

            try {
                object = jsonParser.parse(resp);
            } catch (ParseException exc) {
                frame.setMessage(Messages.PARSE_FAILED);
            }

            JSONObject jObjects = (JSONObject) object;
            JSONArray jArray = (JSONArray) jObjects.get("results");

            Iterator iterator = jArray.iterator();

            while (iterator.hasNext()) {
                JSONObject jsonEachObject = (JSONObject) iterator.next();
                AliExpressProduct aliProduct = new AliExpressProduct();

                aliProduct.setId(productId);
                aliProduct.setDescription((String) jsonEachObject.get("productTitle"));
                aliProduct.setMinPrice((String)jsonEachObject.get("minPrice"));
                aliProduct.setMaxPrice((String)jsonEachObject.get("maxPrice"));
                aliProduct.setOrigMinPrice((String) jsonEachObject.get("oriMinPrice"));
                aliProduct.setOrigMaxPrice((String)jsonEachObject.get("oriMaxPrice"));
                aliProduct.setDiscount((String) jsonEachObject.get("discount"));
                aliProduct.setSellerId((Long)jsonEachObject.get("sellerId"));
                aliProduct.setProductId((Long)jsonEachObject.get("productId"));

                aliProductsList.add(aliProduct);
                productId++;
            }
        }
        return aliProductsList;
    }
}
