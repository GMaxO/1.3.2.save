import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

    public class GameProgress implements Serializable {
        private static final long serialVersionUID = 1L;

        private final int health;
        private final int weapons;
        private final int lvl;
        private final double distance;

        public GameProgress(int health, int weapons, int lvl, double distance) {
            this.health = health;
            this.weapons = weapons;
            this.lvl = lvl;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "GameProgress{" +
                    "health=" + health +
                    ", weapons=" + weapons +
                    ", lvl=" + lvl +
                    ", distance=" + distance +
                    '}';
        }
        public void saveGame(String way) {
            try (FileOutputStream fos = new FileOutputStream(way);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(fos);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        public void zipFiles(String wayZip, String...list) {
            while (true) {
                try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("zip_output.zip"));// имя архива
                     FileInputStream fis = new FileInputStream("notes.txt")) { // читать файл
                    ZipEntry entry = new ZipEntry("save.txt");         // записывать в файл
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
