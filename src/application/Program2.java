package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 : INSERTING DEPARTMENT ===");
        Department dep = new Department(null, "Security");
        departmentDao.insert(dep);
        System.out.println("Insertion completed successfully. ID = " + dep.getId());
        System.out.println();

        System.out.println("=== TEST 2 : UPDATING DEPARTMENT ===");
        dep = new Department(1, "Programming");
        departmentDao.update(dep);
        System.out.println("Updating completed successfully. ID = " + dep.getId() + ", Name = " + dep.getName());
        System.out.println();

        System.out.println("=== TEST 2 : DELETION DEPARTMENT ===");
        System.out.print("Insert ID of the department to be deleted: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletion completed successfully. ID = " + id);
        System.out.println();

        System.out.println("=== TEST 3 : FINDING BY ID DEPARTMENT ===");
        id = 4;
        dep = departmentDao.findbyId(id);
        System.out.printf("Data from ID " + id + ": %n" + dep);
        System.out.println();

        System.out.println("=== TEST 4 : FINDING ALL IN DEPARTMENT ===");
        List<Department> list= departmentDao.findAll();
        System.out.println("Data from all departments: ");
        for(Department department : list) {
            System.out.println(department);
        }
        System.out.println();

        sc.close();
    }
}
