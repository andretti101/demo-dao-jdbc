import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: findById ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: findByDepartment ===");
        Department dep = new Department(1, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("\n=== TEST 3: findAll ===");
        list = sellerDao.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("\n=== TEST 4: insert ===");
        Seller newSeller = new Seller(
                null,
                "Teste",
                "teste@gmail.com",
                new Date(),
                4000.0,
                dep
        );
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: update ===");
        newSeller.setName("Teste Atualizado");
        newSeller.setBaseSalary(5000.0);
        sellerDao.update(newSeller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: delete ===");
        sellerDao.deleteById(newSeller.getId());
        System.out.println("Delete completed");
    }
}