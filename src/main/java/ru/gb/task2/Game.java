package ru.gb.task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Game {
    public void writeGameToFile(String fileName) throws IOException {
        byte[] gameElement = {0, 1, 0, 2, 1, 0, 3, 0, 0};
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < 3; i++) {
                byte row = 0;
                for (int j = 0; j < 3; j++)
                    row += gameElement[i * 3 + j] << (j * 2);
                outputStream.write(row);
            }
            outputStream.flush();
        } catch (IOException e) {
            throw new IOException(e.getCause());
        }
        System.out.println("Элемент массива лежит в диапазоне [0, 3]");
        System.out.println(Arrays.toString(gameElement));
        System.out.println("Игра сохранена в файл '" + fileName + "'");
    }


    public void printSizeOfFile(String fileName) {
        File file = new File(fileName);
        if ((file.exists()) && (file.isFile())) {
            System.out.println("Размер файла '" + fileName + "': "  + file.length() + " байт");
        }
    }
}
