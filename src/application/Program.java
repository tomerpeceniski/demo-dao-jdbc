package application;

import model.entities.Department;
import model.entities.Seller;
import model.dao.SellerDao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        Seller newSeller = new Seller(null, "Gregorio", "Gregorio@gmail.com", LocalDate.now(), 50_000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());
        System.out.println();

        System.out.println("=== TEST 5:  seller update ===");
        seller = sellerDao.findbyId(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");
        System.out.println();

        System.out.println("=== TEST 6:  seller deletion ===");
        System.out.print("Which ID do you want to delete? ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deletion completed. ID deleted: " + id);
        System.out.println();

        sc.close();
    }
}
