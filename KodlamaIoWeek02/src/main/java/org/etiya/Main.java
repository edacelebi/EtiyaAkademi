package org.etiya;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Delonghi Kahve Makinesi", 7500, 7, "bilmemne.jpg", 3);
        Product product2 = new Product("Smeg Kahve Makinesi", 6500, 8, "bilmemne2.jpg", 4);
        Product product3 = new Product("Kitchen Aid Kahve Makinesi", 5500, 9, "bilmemne3.jpg", 5);


        Product[] products = {product1, product2, product3};

        for (Product product : products) {
            System.out.println(product.getName());
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setPhone("5464527896");
        individualCustomer.setCustomerNumber("12345");
        individualCustomer.setFirstName("Engin");
        individualCustomer.setLastName("Demiroğ");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setCompanyName("Kodlama.io");
        corporateCustomer.setPhone("5486588978");
        corporateCustomer.setTaxName("111111111");
        corporateCustomer.setCustomerNumber("54321");

        Customer[] customers = {individualCustomer, corporateCustomer};

    }
}