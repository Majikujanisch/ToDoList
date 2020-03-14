import java.io.*;
import java.nio.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Filemanager {

    public static void createDirectory(String direction){
        try{
            Files.createDirectories(Paths.get(direction));
        }
        catch(IOException e){
            System.out.println("Fehler: IO-Fehler");
        }
    }
    public static void createFile(String filename) {
        try{
            Files.createFile(Paths.get(filename));
        }
        catch(FileAlreadyExistsException e){
            System.out.println("Datei existiert bereits");
        }
        catch(IOException e){
            System.out.println("Fehler: IO-Fehler");
        }
    }
    public static void serializeTask(String filename, Task task){
        // erweiterte Version von try - mit ()-Klammern
        // innerhalb der Klammern werden Instanzen für Ressourcen angegeben, diese müssen unbedingt möglichst rasch
        // wieder freigegeben werden
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(task);
        }
        // hier werden die obigen Ressourcen wieder freigegeben
        // es wird automatisch der finally-Block eingefügt
        catch(IOException e){
            System.out.println("Serialisierung hat nicht funktioniert.");
        }
    }
    public static Task deserializeTask(String filename) {
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            // Rückgabetyp von readObject ist immer die Basisklasse Object
            // diese muss noch in den gewünschen Typ (hier Person) konvertiert werden
            return (Task)ois.readObject();
        }
        catch(IOException e){
            System.out.println("Deserialisierung hat nicht funktioniert.");
        }
        catch(ClassNotFoundException e){
            System.out.println("Klasse Person oder Address existiert nicht.");
        }
        return null;
    }
    public static void serializeTaskS(String filename, List<Task> task){
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            for(Task p : task){
                oos.writeObject(p);
            }
        }
        catch(IOException e){
            System.out.println("Serialisierung hat nicht funktioniert.");
        }
    }
    public static List<Task> deserializeTaskS(String filename){
        List<Task> task = new ArrayList<Task>();
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (List<Task>)ois.readObject();
        }
        catch(IOException e){
            System.out.println("Deserialisierung hat nicht funktioniert.");
        }
        catch(ClassNotFoundException e){
            System.out.println("Klasse Person oder Address existiert nicht.");
        }
        return null;
    }


}
