package ru.mail.polis.homework.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файлов и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     * 2 балла
     */
    public static int removeWithFile(String path) {
        File currentDirectory = new File(path);

        if (currentDirectory.isFile() || currentDirectory.listFiles() == null) {
            return deleteWithFile(currentDirectory, 0);
        }

        int count = 0;
        for (File file : currentDirectory.listFiles()) {
            count += removeWithFile(file.toString());
        }

        return deleteWithFile(currentDirectory, count);
    }

    private static int deleteWithFile(File file, int count) {
        if (file.delete()) {
            count++;
        }
        return count;
    }

    /**
     * С использованием Path
     * 2 балла
     */
    public static int removeWithPath(String path) throws IOException {
        Path dir = Paths.get(path);
        if (Files.notExists(dir)) {
            return 0;
        }
        int count = 0;
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir)) {
                for (Path entry : entries) {
                    count += removeWithPath(entry.toString());
                }
            }
        }
        Files.delete(dir);
        return count + 1;
    }
}