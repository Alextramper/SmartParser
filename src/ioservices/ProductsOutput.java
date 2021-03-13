package ioservices;

import frame.SimpleFrame;

import java.util.List;

/**
 *Интерфейс для вывода информации о товарах в файл
 * @param <T> тип данных "товар"
 */
public interface ProductsOutput<T> {
    void output(List<T> productList, SimpleFrame frame);
}
