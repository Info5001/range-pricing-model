/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.Random;

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

  public static Business initialize(String name, int supplierCount, int productPerSupplierCount, int randSuppliers,
      int customerCount) {
    Business business = new Business(name);
    /**
     * TODO
     * 1. Create suppliers
     * 2. Create products
     * 3. Create customers
     * 4. Create orders
     */

    SupplierDirectory supplierDirectory = business.getSupplierDirectory();
    CustomerDirectory customerDirectory = business.getCustomerDirectory();
    PersonDirectory personDirectory = business.getPersonDirectory();

    loadSuppliers(supplierDirectory, supplierCount);
    loadProducts(business, productPerSupplierCount, randSuppliers);
    loadCustomers(customerDirectory, personDirectory, customerCount);

    // loadOrders(masterOrderList, orderCount);

    return business;
  }

  public static void loadSuppliers(SupplierDirectory sd, int count) {
    for (int index = 1; index <= count; index++) {
      sd.newSupplier("Supplier " + index);
    }
  }

  public static void loadProducts(Business b, int count, int randomSupplierCount) {
    SupplierDirectory sd = b.getSupplierDirectory();
    Random r = new Random();
    // pick supplier randomly
    // get the product catalog
    // decide how many products to load
    // load products (prices???)

    for (int supplierIndex = 1; supplierIndex <= randomSupplierCount; supplierIndex++) {
      Supplier randomSupplier = sd.pickRandomSupplier();
      ProductCatalog pd = randomSupplier.getProductCatalog();
      int randomNumberOfProducts = r.nextInt(count);

      for (int index = 1; index <= randomNumberOfProducts; index++) {
        pd.newProduct("Product " + index + " by " + randomSupplier.getName(), 0, 0, 0);
      }

    }
  }

  public static void loadCustomers(CustomerDirectory cd, PersonDirectory pd, int count) {
    for (int index = 1; index <= count; index++) {
      Person p = pd.newPerson("Person " + index);
      cd.newCustomerProfile(p);
    }
  }

}
