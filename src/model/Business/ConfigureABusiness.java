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

  static int PRICE_LOWEST = 100;
  static int PRICE_MID = 150;
  static int PRICE_UPPER = 200;
  static int PRICE_MAX = 250;

  public static Business initialize(String name, int numberOfSuppliers, int productCountLimit, int customerCount) {
    Business business = new Business(name);

    // Adding a product --- supplier side

    SupplierDirectory sd = business.getSupplierDirectory();

    createSuppliers(sd, numberOfSuppliers);

    Supplier skechers = sd.newSupplier("Skechers");

    createProducts(sd, productCountLimit);

    ProductCatalog skechersCatalog = skechers.getProductCatalog();

    Product laceCupSneaker = skechersCatalog.newProduct("Skechers Men's New Wave Bungee Lace Cup Sneaker", 50, 50, 50);
    Product flyAthleticSneaker = skechersCatalog
        .newProduct("Skechers Little & Big Girls Coastline Flutter Fly Athletic Sneaker", 60, 60, 60);

    // Adding order/order item --- customer side

    PersonDirectory pd = business.getPersonDirectory();
    Person janePersonProfile = pd.newPerson("Jane");

    CustomerDirectory cd = business.getCustomerDirectory();
    CustomerProfile customerJane = cd.newCustomerProfile(janePersonProfile);

    createCustomers(cd, pd, customerCount);

    MasterOrderList mol = business.getMasterOrderList();

    Order janesFirstOrder = mol.newOrder(customerJane);

    OrderItem shoesJaneBought = janesFirstOrder.newOrderItem(flyAthleticSneaker, 57, 1);
    OrderItem anotherPairJaneBought = janesFirstOrder.newOrderItem(laceCupSneaker, 50, 1);

    Order janesSecondOrder = mol.newOrder(customerJane);

    janesSecondOrder.newOrderItem(flyAthleticSneaker, 67, 1);
    janesSecondOrder.newOrderItem(laceCupSneaker, 59, 2);

    // Check how things are looking from different perspectives

    // System.out.println("Let's check the sales volume for Fly Athletic Sneakers");
    // System.out.println("Sales volume for Fly Athletic Sneakers - " +
    // flyAthleticSneaker.getSalesVolume());
    // System.out.println("-");
    // System.out.println("Now let's check the sales volume for Lace Cup Sneaker");
    // System.out.println("Sales volume for Lace Cup Sneaker - " +
    // laceCupSneaker.getSalesVolume());

    // System.out.println("Skechers sold " + skechers.getSuppliersTotalSales() + "$
    // of sneakers in total.");

    // customerJane.printCustomerOrders();

    return business;
  }

  public static void createSuppliers(SupplierDirectory supplierDirectory, int supplierCount) {
    if (supplierDirectory == null) {
      System.out.println("Error: The provided supplier directory instance was null.");
      return;
    }

    if (supplierCount <= 0) {
      System.out.println("Error: Please provide a positive number to create suppliers.");
      return;
    }

    for (int i = 0; i < supplierCount; i++) {
      supplierDirectory.newSupplier("Supplier" + (i + 1));
    }
  }

  public static void createProducts(SupplierDirectory supplierDirectory, int productLimit) {
    if (supplierDirectory == null) {
      System.out.println("Error: The provided supplier directory instance was null.");
      return;
    }

    if (productLimit <= 0) {
      System.out.println("Error: Please provide a positive number to create products.");
      return;
    }

    Random r = new Random();

    for (Supplier s : supplierDirectory.getSuplierList()) {
      ProductCatalog pd = s.getProductCatalog();
      int randomCount = r.nextInt(productLimit);

      for (int i = 0; i < randomCount; i++) {
        int fp = randomInRange(PRICE_LOWEST, PRICE_MID);
        int cp = randomInRange(PRICE_MID, PRICE_UPPER);
        int tp = randomInRange(PRICE_UPPER, PRICE_MAX);

        pd.newProduct("Product " + i, fp, cp, tp);
      }

    }

  };

  public static void createCustomers(CustomerDirectory customerDirectory, PersonDirectory personDirectory,
      int customerCount) {

    if (customerDirectory == null || personDirectory == null) {
      System.out.println("Error: The provided customer directory or person directory instances were null.");
      return;
    }

    if (customerCount <= 0) {
      System.out.println("Error: Please provide a positive number to create customers.");
      return;
    }

    for (int i = 0; i < customerCount; i++) {
      Person newPersonProfile = personDirectory.newPerson("Person #" + (i + 1));
      customerDirectory.newCustomerProfile(newPersonProfile);
    }
  };

  public static void createOrders() {
  };

  public static int randomInRange(int lower, int upper) {
    // Example: random number from 5 to 15 = 5 + random number from 0 + 10;
    Random r = new Random();
    return lower + r.nextInt(upper - lower);
  }

}
