
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program{
    public static Filemanager filemanager;
    private static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        char choice, choicecreate;
        String header, text;
        int year, month, day, hour, minute;
        String file = "Tasks/filetask.bin";
        List<Task> tasks = new ArrayList<Task>();
        List<Task> TasksfromFile;
        filemanager.createDirectory("Tasks");
        if(!Files.exists(Paths.get(file))){
            filemanager.createFile(file);
        }
        filemanager.serializeTaskS(file, tasks);
        do {
            choice = menu();

            switch(choice){
                case 'c':
                    choicecreate = createMenu();
                    switch(choicecreate){
                        case 'm':
                            System.out.println("Fach:");
                            header = reader.next();
                            System.out.println("Aufgabe:");
                            text = reader.next();
                            System.out.println("Bis[Jahr|Monat|Tag]:");
                            year = reader.nextInt();
                            month = reader.nextInt();
                            day = reader.nextInt();
                            System.out.println("Bis[Stunde(bis 23)|minute]:");
                            hour = reader.nextInt();
                            minute = reader.nextInt();
                            tasks.add(new Task(header,text,year,month,day,hour,minute));
                            break;
                        case 'o':
                            System.out.println("Fach:");
                            header = reader.next();
                            System.out.println("Aufgabe:");
                            text = reader.next();
                            System.out.println("Bis[Jahr|Monat|Tag]:");
                            year = reader.nextInt();
                            month = reader.nextInt();
                            day = reader.nextInt();
                            tasks.add(new Task(header,text,year,month,day));
                            break;
                        default:
                            System.out.println("Falscher Buchstabe");
                            break;
                    }
                    break;
                case 'l':
                    TasksfromFile = filemanager.deserializeTaskS(file);
                    System.out.println(TasksfromFile);
                    choicecreate = listMenu();
                    switch(choicecreate){
                        case 'a':
                            break;
                        case 'l':
                            tasks.remove(1);
                            break;
                    }


                    break;
                case'b':
                    System.out.println("Programm wird beendet");
                    filemanager.serializeTaskS(file, tasks);

                    break;
                default:
                    System.out.println("Falscher Buchstabe");
                    break;
            }

        }while (choice != 'b');

    }
    public static char menu(){
        char choice;
        System.out.println("Aufgabe erstellen.............c");
        System.out.println("Liste aller offenen Aufgaben...l");
        System.out.println("Beenden.......................b");
        choice = reader.next().toLowerCase().charAt(0);
        return choice;
    }
    public static char createMenu(){
        char choice;
        System.out.println("Aufgabe erstellen ohne zeitliches Ende.............m");
        System.out.println("Aufgabe erstellen mit zeitliches Ende..............o");
        choice = reader.next().toLowerCase().charAt(0);
        return choice;
    }

    public static char listMenu(){
        char choice;
        System.out.println("Aufgabe bearbeiten...a");
        System.out.println("Aufgabe löschen......l");
        choice = reader.next().toLowerCase().charAt(0);
        return choice;
    }
}
