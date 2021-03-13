package parsers;

import frame.SimpleFrame;
import products.SomeOtherProduct;

import java.util.List;

/**
 * Псевдокласс, якобы для парсинга данных с другого сайта (интернет-магазина)
 * Написан для демонстрации ООП
 */
public class OtherParser implements Parser<SomeOtherProduct> {
    @Override
    public List<SomeOtherProduct> getParsedProductList(SimpleFrame frame) {
        return null;
    }
}
