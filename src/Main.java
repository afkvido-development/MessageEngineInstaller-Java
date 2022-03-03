import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Process process;

        try {

            process = Runtime.getRuntime().exec("git clone https://github.com/afkvido-development/MessageEngine.git", null, new File (System.getenv("HOME")));

            printResults(process);

        } catch (Exception exception) {
            exception.printStackTrace();
        }



    }


    public static void printResults(Process process) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception ignored) {}
    }
}
