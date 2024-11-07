package application;

import model.entities.Department;
import model.entities.Seller;
import model.dao.SellerDao;

import java.time.LocalDate;
import java.util.List;

import model.dao.DaoFactory;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1:  seller findById ===");
        Seller seller = sellerDao.findbyId(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("=== TEST 2:  seller findByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller obj : list) {
            System.out.println(obj);            
        }
        System.out.println();

        System.out.println("=== TEST 3:  seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);            
        }
        System.out.println();

        System.out.println("=== TEST 4:  seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", LocalDate.now(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());
        System.out.println();
    }
}
