import entities.Department;
import entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department dp =  new Department(1, "Tools");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, dp);

        System.out.println(seller);
    }
}