package products;

/**
 * Класс товара с сайта Aliexpress c его параметрами
 */
public class AliExpressProduct extends Product {

    private int id;
    private long productId;
    private long sellerId;

    private String description;
    private String minPrice;
    private String maxPrice;
    private String origMinPrice;
    private String origMaxPrice;
    private String discount;


    public void setId(int id) { this.id = id; }

    public void setProductId(Long productId) { this.productId = productId; }

    public void setSellerId(Long sellerId) { this.sellerId = sellerId; }

    public void setMaxPrice(String maxPrice) { this.maxPrice = maxPrice; }

    public void setOrigMaxPrice(String origMaxPrice) { this.origMaxPrice = origMaxPrice; }

    public void setDescription(String description) { this.description = description; }

    public void setMinPrice(String minPrice) { this.minPrice = minPrice; }

    public void setOrigMinPrice(String origMinPrice) {
        this.origMinPrice = origMinPrice;
    }

    public void setDiscount(String discount) { this.discount = discount; }

    @Override
    public String toString() {
        return String.join("||||", String.valueOf(id), description,
                minPrice, maxPrice, origMinPrice, origMaxPrice, discount,
                String.valueOf(sellerId), String.valueOf(productId));
    }
}
