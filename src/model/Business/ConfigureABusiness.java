/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonDirectory;
import model.MarketingManagement.MarketingPersonProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.EmployeeDirectory;
import model.Personnel.EmployeeProfile;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  public static Business initialize(String name, int numberOfSuppliers, int numberOfProducts, int numberOfCustomers) {
    Business business = new Business(name);

    loadSuppliers(business, numberOfSuppliers);
    loadProducts(business, numberOfProducts);
    loadCustomers(business, numberOfCustomers);
    // create suppliers
    // create products
    // create customers
    // create salespersons
    // create orders
    // create order items

    return business;
  }

  public static void loadSuppliers(Business business, int numberOfSuppliers) {
    SupplierDirectory sd = business.getSupplierDirectory();

    for (int index = 1; index <= numberOfSuppliers; index++) {
      sd.newSupplier("Supplier #" + index);
    }
  }

  public static void loadProducts(Business business, int numberOfProducts) {
    SupplierDirectory sd = business.getSupplierDirectory();

    for (int index = 0; index < numberOfProducts; index++) {
      // pick a supplier randomly
      Supplier randomSupplier = sd.getRandomSupplier();
      if (randomSupplier == null) {
        System.out.println("No suppliers found");
        return;
      }
      // get its product catalog
      ProductCatalog pc = randomSupplier.getProductCatalog();
      // add a new product
      pc.newProduct("Product #" + index, 100, 500, 200);
    }

  }

  public static void loadCustomers(Business business, int numberOfCustomers) {
  }

}
