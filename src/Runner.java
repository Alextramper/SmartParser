import frame.Messages;
import frame.SimpleFrame;
import ioservices.AliProductsOutput;
import ioservices.ProductsOutput;
import parsers.AliExpressParser;
import parsers.Parser;
import products.AliExpressProduct;
import products.Product;
import products.SomeOtherProduct;

import java.util.List;

/**
 * Класс для запуска программы в зависимости от сайта (интернет-магазина)
 */
public class Runner {
    SimpleFrame frame;

    Runner() {
        frame = new SimpleFrame();
    }
    public void runProgram(Product product) {
        if(product instanceof AliExpressProduct) {
            Parser<AliExpressProduct> aliParser = new AliExpressParser();
            ProductsOutput<AliExpressProduct> aliOutput = new AliProductsOutput();
            List<AliExpressProduct> productList = aliParser.getParsedProductList(frame);
            aliOutput.output(productList, frame);
        } else if (product instanceof SomeOtherProduct){
            frame.setMessage(Messages.NOT_FINISHED_FUNCTIONAL);
        }
    }
}
