/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;

import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;

/**
 *
 * @author kal bugrara
 */
public class Supplier {
    String name;
    ProductCatalog productcatalog;
    ProductsReport productsreport;

    public Supplier(String n) {
        name = n;
        productcatalog = new ProductCatalog("software");
    }

    public ProductsReport prepareProductsReport() {

        productsreport = productcatalog.generatProductPerformanceReport();
        return productsreport;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {

        if (productsreport == null)
            productsreport = prepareProductsReport();
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getTotalSales() {
        int total = 0;
        for (Product eachProduct : productcatalog.getProductList()) {
            total += eachProduct.getSalesVolume();
        }
        return total;

    }

    public Product getTopGrossingProduct() {
        return productcatalog.getTopGrossingProduct();
    }

    public int getNumberOfDiffCustomers() {
        return productcatalog.getNumberOfDiffCustomers();
    }

    public String getName() {
        return name;
    }

    public ProductCatalog getProductCatalog() {
        return productcatalog;
    }
    // add supplier product ..

    // update supplier product ...
    @Override
    public String toString() {
        return name;

    }

    public void printSupplierInfo() {
        System.out.println("Supplier name: " + name);
        productcatalog.printCatalogShortInfo();
        productcatalog.generateAndPrintProductReport();

    }
}
