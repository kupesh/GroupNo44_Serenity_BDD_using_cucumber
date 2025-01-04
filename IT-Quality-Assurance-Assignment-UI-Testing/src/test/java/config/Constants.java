package config;

public class Constants {
    public static final String USERNAME = ConfigLoader.getProperty("username");
    public static final String PASSWORD = ConfigLoader.getProperty("password");

    // API Endpoints
    public static final String BASE_URL = ConfigLoader.getProperty("base.url");
    public static final String HOME_PAGE_ENDPOINT = ConfigLoader.getProperty("home.page.endpoint");
    public static final String PRODUCT_PAGE_ENDPOINT = ConfigLoader.getProperty("product.page.endpoint");
    public static final String CART_PAGE_ENDPOINT = ConfigLoader.getProperty("cart.page.endpoint");
    public static final String[] PRODUCT_ENDPOINT = ConfigLoader.getProperty("product.endpoints").split(",");
    public static final String PRODUCT_DETAILS_ENDPOINT = ConfigLoader.getProperty("product.details.endpoint");
    public static final String LOYALTY_PAGE_ENDPOINT = ConfigLoader.getProperty("loyalty.page.endpoint");
}
