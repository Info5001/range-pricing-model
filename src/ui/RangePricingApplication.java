/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Collections;

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

    // After the next line we expect `walmart` to be fully populated
    Business walmart = ConfigureABusiness.initialize("Walmart", 50, 200, 50);

    walmart.printBusinessInformation();

    // ArrayList<String> names = new ArrayList<String>();

    // names.add("James");
    // names.add("Archil");
    // names.add("Nick");
    // names.add("George");

    // Collections.sort(names);

    // for (String n : names) {
    // System.out.println(n);
    // }

  }

}
