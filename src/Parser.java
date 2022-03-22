//package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Parser {

    //TODO: CHANGE ENTRIES TO PARSE FUNCTION ACCORDING TO WHAT'S IN THE TXT FILE
    Set<String> titles = new HashSet<>();

    String chooseParse(String choice, boolean secondaryOption) throws FileNotFoundException {
        return switch (choice) {
            case "t" -> parse("{Temples", secondaryOption);
            case "c" -> parse("{Commandments", secondaryOption);
            case "p" -> parse("{Priesthood", secondaryOption);
            case "s" -> parse("{Plan", secondaryOption);
            case "d" -> parse("{Doctrine", secondaryOption);
            case "g" -> parse("{Godhead", secondaryOption);
            case "j" -> parse("{Jesus", secondaryOption);
            case "a" -> parse("{Atonement", secondaryOption);
            case "df" -> parse("{Faith", secondaryOption);
            case "dr" -> parse("{Repentance", secondaryOption);
            case "db" ->parse("{Baptism", secondaryOption);
            case "dh" ->parse("{Gift", secondaryOption);
            case "de" ->parse("{Endure", secondaryOption);
            case "sp" ->parse("{Premortal", secondaryOption);
            case "sc" ->parse("{Creation", secondaryOption);
            case "sa" ->parse("{Agency", secondaryOption);
            case "sm" ->parse("{Mortal", secondaryOption);
            case "sf" ->parse("{Eternal", secondaryOption);
            case "sd" ->parse("{Death", secondaryOption);
            case "sj" ->parse("{Judgment", secondaryOption);
            case "sk" ->parse("{Kingdoms", secondaryOption);
            case "cca" -> parse("Chastity:", secondaryOption);
            case "cf" -> parse("Fasting:", secondaryOption);
            case "cm" -> parse("Missionary", secondaryOption);
            case "cs" -> parse("Sabbath", secondaryOption);
            case "cco" -> parse("Ten", secondaryOption);
            case "ct" -> parse("Tithing:", secondaryOption);
            case "cw" -> parse("Word", secondaryOption);
            default -> null;
        };
    }

    String parse(String findTopic, boolean secondaryOption) throws FileNotFoundException {
        File file = new File("scriptures.txt");
        Scanner scanner = new Scanner(file);
        initializeTitles();
        String str = null;
        StringBuilder parsedString = new StringBuilder();
        StringBuilder titleString = new StringBuilder();
        boolean keepParsing = false;
        boolean secondQuote = false;
        boolean title = false;

        while (scanner.hasNext()) {

            str = scanner.next();

            if (keepParsing && !title && titles.contains(str)) {
                title = true;
            }

            if (str.equals(findTopic)) {
                keepParsing = true;
                if (secondaryOption) {
                    title = true;
                }
            }

            if (keepParsing) {
                if (!secondaryOption) {
                    if (str.equals("};")) {
                        break;
                    }
                } else {
                    if (str.equals("}")) {
                        break;
                    }
                }

                if (isNumeric(str)) {
                    parsedString.append('\n');
                }
                if (str.contains("\"") && secondQuote) {
           //         System.out.println("secondquote about to be false when str = " + str);
                    parsedString.append(str).append('\n').append('\n');
                    secondQuote = false;
                    continue;
                }
                if (str.equals("}")) {
                    parsedString.append('\n');
                    continue;
                }

                parsedString.append(str).append(" ");

                if (str.contains(":") && title) {
                    parsedString.append('\n');
                    title = false;
                }

            }

            if (keepParsing && str.contains("\"") && !secondQuote) {
          //      System.out.println("secondquote now true");
                secondQuote = true;
            }


        }
        writeToFile(parsedString.toString(), findTopic);

        return parsedString.toString();
    }

    void writeToFile(String stringToWrite, String topicName) {
        int lastIndex = topicName.length() - 1;
        if (topicName.charAt(lastIndex) == ':') {
            topicName = topicName.substring(0, lastIndex);
        }
        File outputFile = new File(topicName.substring(1) + ".txt");
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(outputFile);
            myWriter.write(stringToWrite);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Set<String> getTitles() {
        return titles;
    }

    private void initializeTitles() {
        titles.add("{Temples");
        titles.add("{Commandments");
        titles.add("{Priesthood");
        titles.add("{Plan");
        titles.add("{Doctrine");
        titles.add("{Godhead");
        titles.add("{Jesus");
        titles.add("{Atonement");
        titles.add("Faith:");
        titles.add("Repentance:");
        titles.add("Baptism");
        titles.add("Gift");
        titles.add("Endure");
        titles.add("Premortal");
        titles.add("Creation:");
        titles.add("Agency");
        titles.add("Mortal");
        titles.add("Eternal");
        titles.add("Death");
        titles.add("Judgment");
        titles.add("Kingdoms");
        titles.add("Chastity:");
        titles.add("Fasting:");
        titles.add("Missionary");
        titles.add("Sabbath");
        titles.add("Ten");
        titles.add("Tithing:");
        titles.add("Word");
    }

    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
