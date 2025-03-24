package model.ProductManagement;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

  @Override
  public int compare(Product p1, Product p2) {

    return (-1) * Integer.compare(p1.getFloorPrice(), p2.getFloorPrice());

  }

}
