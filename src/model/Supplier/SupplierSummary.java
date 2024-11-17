package model.Supplier;

import model.ProductManagement.Product;

public class SupplierSummary {
  Supplier supplier;

  // Columns
  int index;
  String supplierName;
  int totalSales;
  Product topProduct;
  int numberOfDiffCustomers;

  public SupplierSummary(Supplier s) {
    supplier = s;
    // Fill out the attributes
    index = 0;
    supplierName = s.getName();
    totalSales = s.getTotalSales();
    topProduct = s.getTopGrossingProduct();
    numberOfDiffCustomers = s.getNumberOfDiffCustomers();
  }

  public void printSummaryRow() {

    // %6s%20s%15s%20s%10s
    System.out.format("%6d%20s%15d%20s%15d", index, supplierName, totalSales, topProduct != null ? topProduct : "n/a",
        numberOfDiffCustomers);
    System.out.println();
  }

  public void setIndexValue(int newIndex) {
    index = newIndex;
  }
}
