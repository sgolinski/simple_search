import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class InputHandler {


    Scanner scanner = new Scanner(System.in);
    List<String> people = new ArrayList<>();
    Map<String, List<Integer>> invertedIndex = new HashMap<>();
    Strategy strategy;


    public void run(File file) {
        ;
        readArgs(file);
        fillInvertedIndex();
        getMenu();
    }


    public void setStrategy(String str) {
        switch (str.toLowerCase()) {
            case "none":
                this.strategy = new FindNone();
                break;
            case "all":
                this.strategy = new FindAll();
                break;
            case "any":
                this.strategy = new FindAny();
                break;
        }
    }


    public void readArgs(File file) {
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                people.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    public void fillInvertedIndex() {
        for (String str : people) {
            String[] words = str.split("\\s+");
            for (String word : words) {
                List<Integer> indexes = new ArrayList<>();
                for (String person : people) {
                    if (person.contains(word) && !invertedIndex.containsKey(word)) {
                        indexes.add(people.indexOf(person));
                    }
                }
                if (!invertedIndex.containsKey(word)) {
                    invertedIndex.put(word.toLowerCase(), indexes);
                }
            }
        }
    }

    public void getMenu() {
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");


            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    this.setStrategy(scanner.next());
                    System.out.println("\nEnter a name or email to search all suitable people.");
                    Scanner sc2 = new Scanner(System.in);
                    find(sc2.nextLine().toLowerCase().trim());
                    break;
                case 2:
                    printAll();
                    break;
                case 0:
                    System.out.println("\nBye!");
                    return;
                default:
                    System.out.println("Incorrect option! Try Again.");
            }

        }
    }

    public void find(String searchWord) {
        strategy.find(searchWord, this.people, this.invertedIndex);
    }

    public void printAll() {
        System.out.println("\n=== List of people ===");
        people.forEach(System.out::println);
    }

}