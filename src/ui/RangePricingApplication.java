/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.Business.Business;
import model.Business.ConfigureABusiness;

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

    int supplierCount = 100;
    int productCount = 500;
    int customerCount = 10;

    Business business = ConfigureABusiness.initialize("Wayfair", supplierCount, productCount, customerCount);

    business.printBusinessInformation();

  }

}
