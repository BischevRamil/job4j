package io.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Ramil Bischev
 * @since 2019-12-11
 * Программа Консольный чат. Пользователь вводит слово-фразу, программа берет случайную фразу из текстового файла и
 * выводит в ответ. Программа замолкает если пользователь вводит слово «стоп», при этом он может продолжать отправлять
 * сообщения в чат. Если пользователь вводит слово «продолжить», программа снова начинает отвечать.
 * При вводе слова «закончить» программа прекращает работу. Запись диалога включая,
 * слова-команды стоп/продолжить/закончить записать в текстовый лог.
 */
public class ConsoleChat {

    final String STOP = "stop";
    final String CONTINUE = "continue";
    final String END = "end";
    private final int WORDS_LENGHT = 10;
    private final int WORDS_ENTITY = 100;
    private String inputFile;
    private String outputFile;
    private List<String> wordsList;
    private List<String> logList;
    private final Scanner scanner;

    public ConsoleChat(String input, String output) {
        this.inputFile = input;
        this.outputFile = output;
        this.scanner = new Scanner(System.in);
        this.generateWords();
        wordsList = new ArrayList<>();
        logList = new ArrayList<>();
    }

    private void run() {
        try (BufferedReader read = new BufferedReader(new FileReader(System.getProperty("java.io.tmpdir") + this.inputFile))) {
            this.wordsList = read.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean endChat = false;
        Boolean continueChat = true;
        do {
            String inputString;
            String outString;
            try {
                inputString = scanner.nextLine();
                this.logList.add(inputString);
                if (inputString.equals(this.END)) {
                    endChat = true;
                    break;
                }
                if (inputString.equals(this.STOP)) {
                    continueChat = false;
                    continue;
                }
                if (inputString.equals(this.CONTINUE)) {
                    continueChat = true;
                }
                if (!inputString.isEmpty() && continueChat) {
                    outString = this.wordsList.get(new Random().nextInt(this.wordsList.size()));
                    System.out.println(outString);
                    this.logList.add(outString);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!endChat);
        this.writeLog();
    }

    private void writeLog() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(System.getProperty("java.io.tmpdir") + this.outputFile))) {
            for (String string : this.logList) {
                out.println(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateWords() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder simpleWord = new StringBuilder();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(System.getProperty("java.io.tmpdir") + this.inputFile)))) {
            for (int entity = 1; entity <= WORDS_ENTITY; entity++) {
                simpleWord.setLength(0);
                for (int i = 0; i < WORDS_LENGHT; i++) {
                    simpleWord.append(s.charAt(new Random().nextInt(s.length())));
                }
                bufferedWriter.write(simpleWord.toString());
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("/input.txt", "/output.log");
        consoleChat.run();
    }
}
