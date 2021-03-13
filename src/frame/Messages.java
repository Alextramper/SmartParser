package frame;

/**
 * Сообщения для вывода в окно
 */
public class Messages {

    public static final String MALFORMED_EXCEPTION = "Не удалось подключится к серверу";

    public static final String IO_EXCEPTION = "Произошла ошибка ввода вывода";

    public static final String PARSE_FAILED = "Не удалось спарсить ответ с URL, неверный формат JSON";

    public static final String NOT_FINISHED_FUNCTIONAL = "Парсинг для данного типа магазина еще в разработке";

    public static final String SUCCES_FINISH = "Готово. Файл \"products.csv\" находится в "+ System.getProperty("user.dir");

}
