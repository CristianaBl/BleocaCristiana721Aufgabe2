import model.Charakteren;
import model.Produkten;
import repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private final Repository<Charakteren> repoX;
    private final Repository<Produkten> repoY;


    public Controller(Repository<Charakteren> inMemoryRepositoryX, Repository<Produkten> inMemoryRepositoryY) {
        this.repoX = inMemoryRepositoryX;
        this.repoY = inMemoryRepositoryY;
    }

    /**
     * CRUD Operation : get,getall,create,update,delete
     */
    public void viewCharak() {
        StringBuilder output = new StringBuilder("Alle Kunden:\n");
        repoX.getAll().forEach(kunde -> output.append(kunde.toString()).append("\n"));
        System.out.println(output);
    }

    public void viewProduk() {
        StringBuilder output = new StringBuilder("Available students:\n");
        repoY.getAll().forEach(produkt -> output.append(produkt.toString()).append("\n"));
        System.out.println(output);
    }

    public void deleteCha(Scanner scanner) {
        System.out.println("Enter the id of the user you want to delete from the system:");
        Integer id = Integer.parseInt(scanner.nextLine());
        repoX.delete(id);
    }
    public void deletePr(Scanner scanner) {
        System.out.println("Enter the id of the user you want to delete from the system:");
        Integer id = Integer.parseInt(scanner.nextLine());
        repoY.delete(id);
    }
    public void createCh(Scanner scanner) {
        System.out.println("Enter Kunde id:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Kunde name:");
        String name = scanner.nextLine();
        System.out.println("Enter Kunde ort:");
        String ort = scanner.nextLine();
        ArrayList<Produkten> productList = new ArrayList<>();
        Charakteren kunde = new Charakteren(id, name, ort, productList);
        repoX.create(kunde);
        System.out.println("Charak created: " + kunde);
    }

    public void createPro(Scanner scanner) {
        System.out.println("Enter Produkt id:");
        Integer id =Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Produkt name:");
        String name = scanner.nextLine();
        System.out.println("Enter Produkt price:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Produkt Universum:");
        String univ = scanner.nextLine();

        Produkten produkt = new Produkten(id,name, price, univ);
        repoY.create(produkt);
        System.out.println("Produkt created: " + produkt);
    }

    // Metoda pentru obținerea unui Kunde
    public  void getChara(Scanner scanner) {
        System.out.println("Enter the id of the Kunde you want to get:");
        Integer id = Integer.parseInt(scanner.nextLine());
        // Kunde kunde = repoKunde.get(id);
        Charakteren kunde = repoX.get(id);
        if (kunde != null) {
            System.out.println("Kunde found: " + kunde);
        } else {
            System.out.println("Kunde not found with id: " + id);
        }
    }
    // Metoda pentru obținerea unui Produkt
    public void getPro(Scanner scanner) {
        System.out.println("Enter the id of the Produkt you want to get:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Produkten produkt = repoY.get(id);
        if (produkt != null) {
            System.out.println("Produkt found: " + produkt);
        } else {
            System.out.println("Produkt not found with id: " + id);
        }
    }

    // Metoda pentru actualizarea unui
    public void updateCharak(Scanner scanner) {
        System.out.println("Enter the id of the Kunde you want to update:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Charakteren kunde = repoX.get(id);
        if (kunde != null) {

            System.out.println("Enter new name for Kunde:");
            String newName = scanner.nextLine();
            System.out.println("Enter new ort for Kunde:");
            String newOrt = scanner.nextLine();

            kunde.setName(newName);
            kunde.setOrt(newOrt);
            repoX.update(kunde);
            System.out.println("Kunde updated: " + kunde);
        } else {
            System.out.println("Kunde not found with id: " + id);
        }
    }



    // Metoda pentru actualizarea unui Produkt
    public void updateprod(Scanner scanner) {
        System.out.println("Enter the id of the Produkt you want to update:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Produkten produkt = repoY.get(id);
        if (produkt != null) {
            System.out.println("Enter new name for Produkt:");
            String newname = scanner.nextLine();
            System.out.println("Enter new price for Produkt:");
            int newPrice = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new jahreszeit for Produkt:");
            String newJahreszeit = scanner.nextLine();

            //cate vrei sa schimbi
            produkt.setName(newname);
            produkt.setPrice(newPrice);
            produkt.setUniversum(newJahreszeit);


            repoY.update(produkt);
            System.out.println("Produkt updated: " + produkt);
        } else {
            System.out.println("Produkt not found with name: " + id);
        }
    }




}
