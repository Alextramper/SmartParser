package ioservices;

import frame.Messages;
import frame.SimpleFrame;
import products.AliExpressProduct;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Класс для вывода в создаваемый файл информации о товарах
 */
public class AliProductsOutput implements ProductsOutput<AliExpressProduct> {
    @Override
    public void output(List<AliExpressProduct> aliProdList, SimpleFrame frame) {

        File file = new File(System.getProperty("user.dir") + "\\Desktop", "products.csv");
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("Номер||||Описание товара||||Мин. цена со скидкой||||" +
                    "Макс. цена со скидкой||||Мин. цена||||Макс. цена||||Скидка в %||||"
                    + "ID продавца||||ID товара" + "\n");
            for(AliExpressProduct aliProd: aliProdList) {
                fileWriter.write(aliProd.toString() + "\n");
            }
        } catch (IOException e) {
            frame.setMessage(Messages.IO_EXCEPTION);
        }
        frame.setMessage(Messages.SUCCES_FINISH);
    }
}
