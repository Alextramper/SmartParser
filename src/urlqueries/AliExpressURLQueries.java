package urlqueries;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для получения списка запросов на товары в Aliexpress
 */
public class AliExpressURLQueries {

    /**
     * defQuery - запрос по умолчанию, взят из DevTools браузера. Товары на сайте отображаются
     * при прокрутке страницы, там задействован JavaScript. Поскольку до другого способа я не додумался,
     * пришлось обработать defQuery, то есть поменять значение параметра limit на 25,
     * делить данный запрос на 4 запроса с разными значениями параметра offset,
     * И далее этот список уйдет на обработку и парсинг данных
     * @return список запросов
     */
    public static List<String> getQueryList() {
        String defQuery = "https://gpsfront.aliexpress.com/getRecommendingResults.do?" +
                "widget_id=5547572&platform=pc&limit=25&offset=0&phase=1&productIds2Top=&postback=1";

        List<String> queryList = new ArrayList<>();
        int pSize = 0;
        String firstPiece = defQuery.substring(0, defQuery.lastIndexOf(pSize + "&phase"));
        String secondPiece = defQuery.substring(defQuery.indexOf("&phase"));

        for (int i = 0; i < 4; i++) {
            String query = String.join(String.valueOf(pSize), firstPiece, secondPiece);
            queryList.add(query);
            pSize = pSize + 25;
        }
        return queryList;
    }
}
