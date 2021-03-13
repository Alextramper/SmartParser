package parsers;

import frame.SimpleFrame;

import java.util.List;

/**
 * Интерфейс для парсинга данных с разных источников
 * @param <T> тип данных "товар"
 */
public interface Parser<T>{

    List<T> getParsedProductList(SimpleFrame frame);
}
