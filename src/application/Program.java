package application;

import model.entities.Department;
import model.entities.Seller;
import model.dao.SellerDao;

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
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
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
    }
}
