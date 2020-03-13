import java.io.IOException;
import java.nio.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Filemanager {
    public static void CreateFile(String filename) {
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

}
