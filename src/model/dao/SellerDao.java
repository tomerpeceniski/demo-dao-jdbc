package model.dao;

import model.entities.Seller;
import model.entities.Department;

import java.util.List;

public interface SellerDao {
    void insert(Seller obj);

    void update(Seller obj);

    void deleteById(Integer id);

    Seller findbyId(Integer id);

    List<Seller> findAll();

    List<Seller> findByDepartment(Department department);
}
