import model.Charakteren;
import model.Produkten;
import repository.InMemoryRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    private final Controller controller;

    public ConsoleApp(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print("""
                    Select an option:
                    
                    1.Get all charakt
                    2.Get all produkten
                    3.Delete charak
                    4.Delete produkten
                    5.Add charakteren
                    6.Add produkten
                    7.Update charakteren
                    8.Update produkten
                    9.Get charakteren
                    10.Get produkten
                   
                    11.filter Nach Region
                    0.Exit
                    """);

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    continueLoop = false;
                    break;
                case "1":
                    controller.viewCharak();
                    break;
                case "2":
                    controller.viewProduk();
                    break;
                case "3":
                    controller.deleteCha(scanner);
                    break;
                case "4":
                    controller.deletePr(scanner);
                    break;
                case "5":
                    controller.createCh(scanner);
                    break;
                case "6":
                    controller.createPro(scanner);
                    break;
                case "7":
                    controller.updateCharak(scanner);
                    break;
                case "8":
                    controller.updateprod(scanner);
                    break;
                case "9":
                    controller.getChara(scanner);
                    break;
                case "10":
                    controller.getPro(scanner);
                    break;
                case "11":
                    controller.filterNachRegion(scanner);
                    break;

                default:
            }
        }
    }

    public static void main(String[] args) {
        Repository<Charakteren> xRepo = createInMemoryXRepository();
        Repository<Produkten> yRepo = createInMemoryYRepository();

        Controller controller = new Controller(xRepo, yRepo);

        ConsoleApp consoleApp = new ConsoleApp(controller);
        consoleApp.start();
    }

    private static Repository<Charakteren> createInMemoryXRepository() {
        Repository<Charakteren> xRepo = new InMemoryRepository<>();
        List<Charakteren> charaktere = new ArrayList<>();
//
//        Charakter c1 = new Charakter(1, "Thor", "Asgard");
//        c1.kaufeProdukt(produkte.get(0)); // Mjolnir
//        c1.kaufeProdukt(produkte.get(5)); // Norn Stones
//        c1.kaufeProdukt(produkte.get(9)); // Darkhold
//
//        Charakter c2 = new Charakter(2, "Black Panther", "Wakanda");
//        c2.kaufeProdukt(produkte.get(1)); // Vibranium-Schild
//        c2.kaufeProdukt(produkte.get(7)); // X-Gene Serum
//
//        Charakter c3 = new Charakter(3, "Iron Man", "Terra");
//        c3.kaufeProdukt(produkte.get(4)); // Arc-Reaktor
//        c3.kaufeProdukt(produkte.get(6)); // Quantum Suit
//        c3.kaufeProdukt(produkte.get(3)); // Web-Shooter
//
//        Charakter c4 = new Charakter(4, "Spider-Man", "Terra");
//        c4.kaufeProdukt(produkte.get(3)); // Web-Shooter
//        c4.kaufeProdukt(produkte.get(8)); // Cosmic Cube
//
//        Charakter c5 = new Charakter(5, "Doctor Strange", "Multiverse");
//        c5.kaufeProdukt(produkte.get(9)); // Darkhold
//        c5.kaufeProdukt(produkte.get(8)); // Cosmic Cube
//        c5.kaufeProdukt(produkte.get(2)); // Infinity Gauntlet

//        charaktere.add(c1);
//        charaktere.add(c2);
//        charaktere.add(c3);
//        charaktere.add(c4);
//        charaktere.add(c5);

        return xRepo;
    }

    private static Repository<Produkten> createInMemoryYRepository() {
        Repository<Produkten> yRepo = new InMemoryRepository<>();

        List<Produkten> produkte = new ArrayList<>();
        produkte.add(new Produkten(1,"Mjolnir", 500, "Asgard"));
        produkte.add(new Produkten(2,"Vibranium-Schild", 700, "Wakanda"));
        produkte.add(new Produkten(3,"Infinity Gauntlet", 10000, "Titan"));
        produkte.add(new Produkten(4,"Web-Shooter", 250, "Terra"));
        produkte.add(new Produkten(5,"Arc-Reaktor", 1500, "Terra"));
//        produkte.add(new Produkten(6,"Norn Stones", 1200.0, "Asgard"));
//        produkte.add(new Produkten(7,"Quantum Suit", 3000.0, "Terra"));
//        produkte.add(new Produkten(8,"X-Gene Serum", 850.0, "X-Mansion"));
//        produkte.add(new Produkten(9,"Cosmic Cube", 9000.0, "Multiverse"));
//        produkte.add(new Produkten(10,"Darkhold", 2000.0, "Multiverse"));

        return yRepo;
    }
}
