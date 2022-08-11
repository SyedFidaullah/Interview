package com.example.interviewproject;

public class ProductsModelClass {
    int imgProduct;
    String productName;
    String productPrice;

    public ProductsModelClass(int imgProduct, String productName, String productPrice) {
        this.imgProduct = imgProduct;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(int imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
