package ru.gb.task1;

//Написать функцию, создающую резервную копию всех файлов в
// директории(без поддиректорий) во вновь созданную папку ./backup

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String SOURCE = "./src/main/java/ru/gb/task1/source";
        final String BACKUP = "./src/main/java/ru/gb/task1/backup";

        System.out.println();
        Backup backup = new Backup();
        System.out.println("Директория для бэкапа:");
        backup.printFileslist(SOURCE);
        backup.createBackupCopy(SOURCE, BACKUP);
        System.out.println("Бэкап всех файлов выполен:");
        backup.printFileslist(BACKUP);
    }
}
