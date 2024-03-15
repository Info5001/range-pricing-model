/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {
    ArrayList<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new ArrayList();
    }

    public Supplier newSupplier(String n) {
        Supplier supplier = new Supplier(n);
        supplierList.add(supplier);
        return supplier;

    }

    public Supplier findSupplier(String id) {

        for (Supplier supplier : supplierList) {

            if (supplier.getName().equals(id))
                return supplier;
        }
        return null;
    }

    public ArrayList<Supplier> getSuplierList() {
        return supplierList;
    }

    public void printSupplierDirectoryInformation() {
        System.out.println("Supplier Directory:");
        for (Supplier eachSupplier : supplierList) {
            eachSupplier.printSupplierInformation();
        }

    }

    public Supplier getRandomSupplier() {
        if (supplierList.size() == 0)
            return null;

        Random r = new Random();
        int randomSupplierIndex = r.nextInt(supplierList.size());
        Supplier randomSupplier = supplierList.get(randomSupplierIndex);
        return randomSupplier;
    }

}