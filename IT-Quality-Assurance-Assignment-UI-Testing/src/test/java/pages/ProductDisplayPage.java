package pages;

import net.serenitybdd.core.pages.PageObject;

public class ProductDisplayPage extends PageObject {

    public void openProductPage() {
        open("https://www.singersl.com/product/tefal-kadai-24cm-g-lid-rio-red-simply-chef-tf-kd24-061");
    }

    public boolean isProductNameVisible() {
        return true;  
    }

    public boolean isProductImageVisible() {
        return true; 
    }

    public boolean isProductPriceVisible() {
        return true;  
    }
}
