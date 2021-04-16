import java.util.*;

public class FindAll implements Strategy {


    @Override
    public void find(String searchWord, List<String> people, Map<String, List<Integer>> invertedIndex) {
        String[] splitedSearchWord = searchWord.split(" ");

        List<String> result = new ArrayList<>();

        for (String per : people) {

            if (per.toLowerCase().contains(searchWord.toLowerCase())) {
                result.add(per);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            for (String person : result) {
                System.out.println(person);
            }
        }
    }
}
