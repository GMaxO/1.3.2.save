import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress gameProgress = new GameProgress(95,95,95,95);
        GameProgress gameProgress2 = new GameProgress(100,100,100,100);
        GameProgress gameProgress3 = new GameProgress(105,105,105,105);
        gameProgress.saveGame("D://Games/savegames");
        gameProgress2.saveGame("D://Games/savegames");
        gameProgress3.saveGame("D://Games/savegames");
        gameProgress.zipFiles("D://Games/savegames/zip.zip","D://Games/savegames/save2.dat", "D://Games/savegames/save2.dat", "D://Games/savegames/save3.dat");
    }
}

