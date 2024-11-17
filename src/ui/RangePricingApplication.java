/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.Supplier.SupplierDirectory;
import model.Supplier.SuppliersReport;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    Business wayFair = ConfigureABusiness.initialize("WayFair", 5, 20, 5, 200, 500, 10);

    // wayFair.printBusinessInformation();

    SupplierDirectory sd = wayFair.getSupplierDirectory();

    SuppliersReport demoReport = sd.generateSuppliersReport();
    demoReport.printReport();

  }

}
