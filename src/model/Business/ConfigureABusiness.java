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
      int customerCount, int orderCount, int orderItemCount) {
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
    loadOrders(business, orderCount, orderItemCount);

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

        int randomFp = pickRandomNumber(80, 120);
        int randomCp = pickRandomNumber(121, 150);
        int randomTp = pickRandomNumber(90, 140);

        pd.newProduct("Product " + index, randomFp, randomCp, randomTp);
      }

    }
  }

  public static void loadCustomers(CustomerDirectory cd, PersonDirectory pd, int count) {
    for (int index = 1; index <= count; index++) {
      Person p = pd.newPerson("Person " + index);
      cd.newCustomerProfile(p);
    }
  }

  public static void loadOrders(Business b, int orderCount, int orderItemCount) {
    /**
     * TODO
     * 
     * 1. Pick a random customer
     * 2. Create an empty order for this customer
     * 3. Pick random product
     * - 3a Pick a random supplier
     * - 3b Make sure supplier has products
     * - 3c Pick a product
     * 4. Create an Order item
     */

    MasterOrderList mol = b.getMasterOrderList();
    CustomerDirectory cd = b.getCustomerDirectory();
    SupplierDirectory sd = b.getSupplierDirectory();

    for (int orderIndex = 0; orderIndex < orderCount; orderIndex++) {
      // 1. Pick a random customer
      CustomerProfile randomCustomer = cd.pickRandomCustomer();
      // 2. Created empty order
      Order newOrder = mol.newOrder(randomCustomer);
      // 3. Order items...
      int randomOrderItemCount = pickRandomNumber(1, orderItemCount);

      for (int orderItemIndex = 0; orderItemIndex < randomOrderItemCount; orderItemIndex++) {
        Product randomProduct = null;

        while (randomProduct == null) {
          Supplier randomSupplier = sd.pickRandomSupplier();
          ProductCatalog pc = randomSupplier.getProductCatalog();
          if (!pc.isEmpty()) { // ! stands for not(pc.isEmpty())
            randomProduct = pc.pickRandomProduct();
          }
        }

        if (randomProduct != null) {
          int price = pickRandomNumber(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
          int quantity = pickRandomNumber(5, 10);

          newOrder.newOrderItem(randomProduct, price, quantity);
        }
      }
    }
  }

  public static int pickRandomNumber(int lower, int upper) {
    Random r = new Random();
    int randomNumber = r.nextInt(upper - lower) + lower; // the result will be between lower and upper since
                                                         // nextInt(num) generates from 0 to num.
    return randomNumber;
  }

}
