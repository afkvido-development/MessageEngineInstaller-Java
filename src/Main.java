import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public final static String fail = "URLreader failed";

    public final static String Version = "0.1.0";



    public static void main (String[] args) {


        System.out.println("MessageEngine Installer\n");

        Scanner wait = new Scanner(System.in);


        String latestVersion = check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/versions/latest/InstallerJava.yml").replace("\n", "");


        if (latestVersion.equals(fail)) {
            System.out.println("Cannot connect to the MessageEngine API.\nMake sure you have actual internet.\nOr, you might just have an old version. Download a new version here: https://github.com/afkvido-development/MessageEngineInstaller-Java/releases/latest");
            wait.nextLine();
            System.exit(0);
        } if (!latestVersion.equals(Version)) {
            System.out.println("You're on an old version of MessageEngine Installer.\nDownload a new version here: https://github.com/afkvido-development/MessageEngineInstaller-Java/releases/latest");
            wait.nextLine();
            System.exit(0);
        } else {
            System.out.println("Version check: Latest!");
        }









        String name = System.getProperty("os.name");
        System.out.println("OS: " + name);


        if (name.equals("Mac OS X")) {
            MacOS();
        } else {
            System.out.println("\nYour operating System, [" + name + "], is not supported.");
            System.out.print("This might be caused by an old version of this installer. \nYou can check for a newer version here: ");
            System.out.println("https://github.com/afkvido-development/MessageEngineInstaller-Java/releases/latest");
            System.out.print("If you're already on the latest version, please file a bug report here: ");
            System.out.println("https://github.com/afkvido-development/MessageEngineInstaller-Java/issues\n");
            System.exit(0);
        }




    }


    public static void MacOS () {


        // Mac OS X

        Process process;


        File f = new File(System.getenv("HOME") + "/MessageEngine");
        makeDirectory(f);


        System.out.println("Cloning the License (MPL-2.0)...");
        try {

            process = Runtime.getRuntime().exec("git clone https://github.com/MessageEngine/LICENSE.git", null, new File (System.getenv("HOME") + "/MessageEngine"));

            printResults(process);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Cloned the License (MPL-2.0).");


        System.out.println("Cloning the MessageEngine repository...");
        try {

            process = Runtime.getRuntime().exec("git clone https://github.com/afkvido-development/MessageEngine.git", null, new File (System.getenv("HOME") + "/MessageEngine/repositories"));

            printResults(process);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Cloned the MessageEngine repository.");






        System.out.println("Cloning the MessageEngine-JARs repository...");
        try {

            process = Runtime.getRuntime().exec("git clone https://github.com/afkvido-development/MessageEngine-JARs.git", null, new File (System.getenv("HOME") + "/MessageEngine/repositories"));

            printResults(process);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Cloned the MessageEngine-JARs repository.");





        System.out.println("Done!\n\n");
        System.exit(0);

    }

    public static void Windows () {


        // Windows

        Process process;


        File f = new File(System.getenv("HOME") + "\\MessageEngine");
        makeDirectory(f);


        System.out.println("Cloning the License (MPL-2.0)...");
        try {

            process = Runtime.getRuntime().exec("git clone https://github.com/MessageEngine/LICENSE.git", null, new File (System.getenv("HOME") + "\\MessageEngine"));

            printResults(process);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Cloned the License (MPL-2.0).");


        System.out.println("Cloning the MessageEngine repository...");
        try {

            process = Runtime.getRuntime().exec("git clone https://github.com/afkvido-development/MessageEngine.git", null, new File (System.getenv("HOME") + "\\MessageEngine\\repositories"));

            printResults(process);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Cloned the MessageEngine repository.");






        System.out.println("Cloning the MessageEngine-JARs repository...");
        try {

            process = Runtime.getRuntime().exec("git clone https://github.com/afkvido-development/MessageEngine-JARs.git", null, new File (System.getenv("HOME") + "\\MessageEngine\\repositories"));

            printResults(process);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Cloned the MessageEngine-JARs repository.");





        System.out.println("Done!\n\n");
        System.exit(0);

    }


    /** Print results of process */
    public static void printResults (Process process) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception ignored) {}
    }


    /** Create Directory */
    public static void makeDirectory (File f) {




        //Creating the directory
        boolean b = f.mkdir();
        if(b){
            System.out.println("Made the (home)/MessageEngine directory");
        }else{
            System.out.println("Could not make the the (home)/MessageEngine directory, it might already exist.");
        }


        //Creating a File object
        File file = new File(System.getenv("HOME") + "/MessageEngine/repositories");


        //Creating the directory
        boolean bool = file.mkdir();
        if (bool) {
            System.out.println("Made the (home)/MessageEngine/repositories directory");
        } else {
            System.out.println("Could not make the the (home)/MessageEngine/repositories directory, it might already exist.");
        }


    }


    /** Read a url */
    static String check (String url) {
        String r = fail;
        try {
            r = read(url);
        } catch (Exception ignored) {}
        return r;

    }

    /** Read a url but it throws an exception */
    static String read (String url) throws Exception {

        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        StringBuilder r = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            r.append(inputLine).append("\n");

        in.close();
        return r.toString();
    }


}
