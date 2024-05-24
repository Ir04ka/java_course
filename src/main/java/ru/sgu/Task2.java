import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class Task2 {

    private static final String DIRECTORY_PATH = "data/test";
    private static final String TARGET_STRING = "day";

    public static void main(String[] args) {
        Task2 task2 = new Task2();

        task2.run();
    }

    void run() {
        try {
            Path directory = Paths.get(DIRECTORY_PATH);
            if (!Files.exists(directory) || !Files.isDirectory(directory)) {
                System.out.println("Invalid directory: " + DIRECTORY_PATH);
                return;
            }

            processDirectory(directory, TARGET_STRING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processDirectory(Path directory, String targetString) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    processDirectory(path, targetString);
                } else if (Files.isRegularFile(path) && path.getFileName().toString().contains(targetString)) {
                    String zipFileName = path.getFileName() + ".zip";
                    zipFile(path, zipFileName);
                    System.out.println("Файл " + path.getFileName() + " заархивирован в " + zipFileName);
                }
            }
        }
    }

    private void zipFile(Path filePath, String zipFileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath.toFile());
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            ZipEntry zipEntry = new ZipEntry(filePath.getFileName().toString());
            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = bis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }

            zos.closeEntry();
        }
    }
}
