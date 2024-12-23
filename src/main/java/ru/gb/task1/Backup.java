package ru.gb.task1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Backup {
    public  void createBackupCopy(String sourceDir, String backupDir) throws IOException {
        Path sourcePath = Paths.get(sourceDir);
        Path backupPath = Paths.get(backupDir);
        if (!Files.exists(backupPath)) {
            Files.createDirectories(backupPath);
            System.out.println("Directory './backup' successfully created!");
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    Files.copy(file, backupPath.resolve(file.getFileName()), REPLACE_EXISTING);
                }
            }
        }
    }

    public void printFileslist(String path) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }
    }
}
