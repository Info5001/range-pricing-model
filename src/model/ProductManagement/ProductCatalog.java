/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    String type;
    ArrayList<Product> products; // list of products initially empty

    public ProductCatalog(String n) {
        type = n;
        products = new ArrayList(); /// create the list of elements otherwise it is null
    }

    // new ProductCatalog(); or new ProductCatalog("Printers");
    public ProductCatalog() {
        type = "unknown";
        products = new ArrayList();
    }

    public Product newProduct(int fp, int cp, int tp) {
        Product p = new Product(fp, cp, tp);
        products.add(p);
        return p;
    }

    public Product newProduct(String n, int fp, int cp, int tp) {
        Product p = new Product(n, fp, cp, tp);
        products.add(p);
        return p;
    }

    public ProductsReport generatProductPerformanceReport() {
        ProductsReport productsreport = new ProductsReport();

        for (Product p : products) {

            ProductSummary ps = new ProductSummary(p);
            productsreport.addProductSummary(ps);
        }
        return productsreport;
    }

    public ArrayList<Product> getProductList() {
        return products;
    }

    public int getTotalSales() {
        int sum = 0;

        for (Product eachProduct : products) {
            sum = sum + eachProduct.getSalesVolume();
        }
        return sum;
    }

    public void printProductCatalogInfo() {
        System.out.println(" - - Product Catalog: ");

        // Product productWithMinPrice = products.get(0);

        // for (Product p : products) {
        // if (p.getFloorPrice() < productWithMinPrice.getFloorPrice()) {
        // productWithMinPrice = p;
        // }
        // }

        // System.out.println("Minimum floor price " +
        // productWithMinPrice.getFloorPrice());

        Collections.sort(products, new ProductComparator());
        System.out.println("Minimum floor price " + products.get(products.size() - 1).getFloorPrice());

        for (int i = 1; i <= products.size(); i++) {
            Product eachProduct = products.get(i - 1);
            System.out.print(i + ". ");
            eachProduct.printProductInfo();
        }
    }

}
