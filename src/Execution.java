import products.AliExpressProduct;
import products.Product;

public class Execution {
    public static void main(String[] args) {
        Product aliExpressProduct = new AliExpressProduct();
        Runner runner = new Runner();
        runner.runProgram(aliExpressProduct);

        }

    }
