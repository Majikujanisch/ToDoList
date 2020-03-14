import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static Filemanager filemanager;
    private static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        char choice;
        String file = "Tasks/filetask.bin";
        List<Task> tasks = new ArrayList<Task>();
        filemanager.createDirectory("Tasks");
        if(!Files.exists(Paths.get(file))){
            filemanager.createFile(file);
        }
        tasks.add(new Task("hi","dkas",2020,1,1));
        do {
            choice = menu();
            switch(choice){
                case 'c':
                    break;
                case 'l':
                    break;
                case'b':
                    System.out.println("Programm wird beendet");
                    filemanager.serializeTaskS(file, tasks);
                    break;
                default:
                    break;
            }

        }while (choice != 'b');

    }
    public static char menu(){
        char choice;
        System.out.println("Aufgabe erstellen.............c");
        System.out.println("List aller offenen Aufgaben...l");
        System.out.println("Beenden.......................b");
        choice = reader.next().toLowerCase().charAt(0);
        return choice;
    }



}
