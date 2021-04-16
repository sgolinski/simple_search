import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class FindNone implements Strategy {

    public void find(String searchWord, List<String> people, Map<String, List<Integer>> invertedIndex) {
        String[] splitedSearchWord = searchWord.split(" ");

        List<String> result = new ArrayList<>();

        for (String per : people) {
            boolean found = false;
            for (String search : splitedSearchWord) {
                if (per.toLowerCase().contains(search.toLowerCase())) {
                    found = true;
                }
            }
            if (!found) {
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
