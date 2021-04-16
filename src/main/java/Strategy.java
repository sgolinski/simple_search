import java.util.List;
import java.util.Map;

public interface Strategy {

    abstract  void find(String searchWord, List<String> people, Map<String, List<Integer>> invertedIndex);
}
