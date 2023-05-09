import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
import java.io.FileWriter;
// import java.io.IOException;
//import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class program {
    public static void main(String[] args) {

        ex01();
    }

    static void ex01() {
        // Дана json строка [{
        // "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        // {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        // Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
        // Студент Иванов получил 5 по предмету Математика.
        // Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика.
        // Используйте StringBuilder для подготовки ответа
        // Исходная json строка это просто String !!! Для работы используйте методы
        // String, такие как replace, split, substring и т.д. по необходимости
        // Создать метод, который запишет результат работы в файл. Обработайте
        // исключения и запишите ошибки в лог файл.

        String s = "[{'фамилия':'Иванов','оценка':'5','предмет':'Математика'},{'фамилия':'Петрова','оценка':'4','предмет':'Информатика'},{'фамилия':'Краснов','оценка':'5','предмет':'Физика'}]";

        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        String path = "result.txt";

        try (FileWriter fileWriter = new FileWriter(path, false)) {
            s = s.replace("[", "");
            s = s.replace("]", "");
            String[] parts = s.split("},");

            String part1 = parts[0];
            String part2 = parts[1];
            String part3 = parts[2];

            part1 = part1.replace("{", "").replace("}", "").replace("'", "");
            part2 = part2.replace("{", "").replace("}", "").replace("'", "");
            part3 = part3.replace("{", "").replace("}", "").replace("'", "");

            String[] parts_1 = part1.split(",");
            String part1_1 = parts_1[0];
            String part1_2 = parts_1[1];
            String part1_3 = parts_1[2];

            String[] parts_2 = part2.split(",");
            String part2_1 = parts_2[0];
            String part2_2 = parts_2[1];
            String part2_3 = parts_2[2];

            String[] parts_3 = part3.split(",");
            String part3_1 = parts_3[0];
            String part3_2 = parts_3[1];
            String part3_3 = parts_3[2];

            parts = part1_1.split(":");
            part1_1 = parts[1];
            parts = part1_2.split(":");
            part1_2 = parts[1];
            parts = part1_3.split(":");
            part1_3 = parts[1];
            parts = part2_1.split(":");
            part2_1 = parts[1];
            parts = part2_2.split(":");
            part2_2 = parts[1];
            parts = part2_3.split(":");
            part2_3 = parts[1];
            parts = part3_1.split(":");
            part3_1 = parts[1];
            parts = part3_2.split(":");
            part3_2 = parts[1];
            parts = part3_3.split(":");
            part3_3 = parts[1];

            String line1 = "Студент " + part1_1 + " получил " + part1_2 + " по предмету " + part1_3;
            String line2 = "Студент " + part2_1 + " получил " + part2_2 + " по предмету " + part2_3;
            String line3 = "Студент " + part3_1 + " получил " + part3_2 + " по предмету " + part3_3;

            fileWriter.append(line1);
            fileWriter.append("\n");
            fileWriter.append(line2);
            fileWriter.append("\n");
            fileWriter.append(line3);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
        fileHandler.close();

    }

}
