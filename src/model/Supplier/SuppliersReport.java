package model.Supplier;

import java.util.ArrayList;
import java.util.Collections;

import model.ProductManagement.Product;

public class SuppliersReport {
  ArrayList<SupplierSummary> summaryList; // these are actual rows of the table

  public SuppliersReport() {
    summaryList = new ArrayList<SupplierSummary>();
  }

  public void addSupplier(Supplier s) {
    SupplierSummary newSummary = new SupplierSummary(s);
    summaryList.add(newSummary);

    sortByTopSales();
  }

  public void printReport() {
    // index - supplierName - totalSales - topProduct - numberOfDiffCustomers;
    /**
     * Print the headers
     */
    System.out.println();
    System.out.format("%6s%20s%15s%20s%15s", "Index", "Supplier Name", "Total Sales", "Top Product", "No. of Cust.",
        "\n");
    System.out.println();
    /**
     * Print the rows
     */
    for (SupplierSummary eachSummary : summaryList) {
      eachSummary.printSummaryRow();
    }
    System.out.println();
  }

  public void sortByTopSales() {
    summaryList.sort((SupplierSummary s1, SupplierSummary s2) -> s2.totalSales - s1.totalSales);

    for (SupplierSummary eachSummary : summaryList) {
      int newIndex = summaryList.indexOf(eachSummary);
      eachSummary.setIndexValue(newIndex + 1);
    }
  }

}
