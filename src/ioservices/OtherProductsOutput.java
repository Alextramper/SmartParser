package ioservices;

import frame.SimpleFrame;
import products.SomeOtherProduct;

import java.util.List;

/**
 * Псевдокласс для вывода информации о товарах с другого магазина
 * если вдруг захочется расширить программу
 * Написан в целях демонстрации ООП
 */
public class OtherProductsOutput implements ProductsOutput<SomeOtherProduct> {

    @Override
    public void output(List<SomeOtherProduct> productList, SimpleFrame frame) {
        //Код для записи данных товаров с какого-либо другого магазина
    }
}
