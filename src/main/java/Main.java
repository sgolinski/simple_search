import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("--data")) {
            File file = new File(args[1]);
            InputHandler inputHandler = new InputHandler();
            inputHandler.run(file);
        }
    }

}

