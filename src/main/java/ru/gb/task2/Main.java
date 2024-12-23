package ru.gb.task2;

//Предположить, что числа в исходном массиве из 9 элементов имеют
// диапазон[0, 3], и представляют собой, например, состояния ячеек
// поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это
// поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
// Такое предположение позволит хранить в одном числе типа int всё
// поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final String SAVED_GAME = "./src/main/java/ru/gb/task2/saved/saved_game.txt";
        Game gameWriter = new Game();
        gameWriter.writeGameToFile(SAVED_GAME);
        gameWriter.printSizeOfFile(SAVED_GAME);
    }
}