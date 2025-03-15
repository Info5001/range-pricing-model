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

  public static Business initialize() {
    Business business = new Business("Walmart");

    // Adding a product --- supplier side 

    SupplierDirectory sd = business.getSupplierDirectory();

    Supplier skechers = sd.newSupplier("Skechers");

    ProductCatalog skechersCatalog = skechers.getProductCatalog();

    Product laceCupSneaker = skechersCatalog.newProduct("Skechers Men's New Wave Bungee Lace Cup Sneaker", 50, 50, 50);
    Product flyAthleticSneaker = skechersCatalog.newProduct("Skechers Little & Big Girls Coastline Flutter Fly Athletic Sneaker", 60, 60, 60);
    
    // Adding order/order item --- customer side

    PersonDirectory pd = business.getPersonDirectory();
    Person janePersonProfile = pd.newPerson("Jane");

    CustomerDirectory cd = business.getCustomerDirectory();
    CustomerProfile customerJane = cd.newCustomerProfile(janePersonProfile);

    MasterOrderList mol = business.getMasterOrderList();

    Order janesFirstOrder = mol.newOrder(customerJane);

    OrderItem shoesJaneBought = janesFirstOrder.newOrderItem(flyAthleticSneaker, 57, 1);
    OrderItem anotherPairJaneBought = janesFirstOrder.newOrderItem(laceCupSneaker, 50, 1);

    Order janesSecondOrder = mol.newOrder(customerJane);

    janesSecondOrder.newOrderItem(flyAthleticSneaker, 67, 1);
    janesSecondOrder.newOrderItem(laceCupSneaker, 59, 2);

    // Check how things are looking from different perspectives

    System.out.println("Let's check the sales volume for Fly Athletic Sneakers");
    System.out.println("Sales volume for Fly Athletic Sneakers - " + flyAthleticSneaker.getSalesVolume());
    System.out.println("-");
    System.out.println("Now let's check the sales volume for Lace Cup Sneaker");
    System.out.println("Sales volume for Lace Cup Sneaker - " + laceCupSneaker.getSalesVolume());
    

    System.out.println("Skechers sold " + skechers.getSuppliersTotalSales() + "$ of sneakers in total.");
    
    customerJane.printCustomerOrders();

    return business;
  }
}
