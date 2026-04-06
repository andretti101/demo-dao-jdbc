import dao.DaoFactory;
import dao.DepartmentDao;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("========== TESTS: DEPARTMENT ==========");

        System.out.println("\n--- TEST 1: Department findById ---");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n--- TEST 2: Department findAll ---");
        List<Department> depList = departmentDao.findAll();
        for (Department d : depList) {
            System.out.println(d);
        }

        System.out.println("\n--- TEST 3: Department insert ---");
        Department newDep = new Department(null, "Books");
        departmentDao.insert(newDep);
        System.out.println("Inserted! New id = " + newDep.getId());

        System.out.println("\n--- TEST 4: Department update ---");
        newDep.setName("Books Updated");
        departmentDao.update(newDep);
        System.out.println("Update completed");

        System.out.println("\n========== TESTS: SELLER ==========");

        System.out.println("\n--- TEST 5: Seller findById ---");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("\n--- TEST 6: Seller findByDepartment ---");
        List<Seller> sellerList = sellerDao.findByDepartment(newDep);
        for (Seller s : sellerList) {
            System.out.println(s);
        }

        System.out.println("\n--- TEST 7: Seller findAll ---");
        sellerList = sellerDao.findAll();
        for (Seller s : sellerList) {
            System.out.println(s);
        }

        System.out.println("\n--- TEST 8: Seller insert ---");
        Seller newSeller = new Seller(
                null,
                "Joao",
                "joao@gmail.com",
                new Date(),
                3500.0,
                newDep
        );
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n--- TEST 9: Seller update ---");
        newSeller.setName("Joao Updated");
        newSeller.setBaseSalary(4500.0);
        sellerDao.update(newSeller);
        System.out.println("Update completed");

        System.out.println("\n--- TEST 10: Seller delete ---");
        sellerDao.deleteById(newSeller.getId());
        System.out.println("Seller delete completed");

        System.out.println("\n========== FINAL TEST ==========");

        System.out.println("\n--- TEST 11: Department delete ---");
        departmentDao.deleteById(newDep.getId());
        System.out.println("Department delete completed");
    }
}