//package main;

import java.util.HashSet;
import java.util.Set;

public class Menu {
    Set<String> options = new HashSet<>();
    Set<String> subOptions = new HashSet<>();

    public Set<String> getOptions() {
        return options;
    }

    public Set<String> getSubOptions() {
        return subOptions;
    }

    String printMenu() {
       String menu = null;
       menu = "To view scriptures associated with a topic, press the letter shown in brackets to the right of the topic name.\n\n";
       menu += "\t\t\tMENU\n\n";
       menu += "\t[m] -- MENU\n";
       menu += "\t[e] -- EXIT\n\n";
       menu += "\t[a] -- Atonement of Jesus Christ\n";
       menu += "\t[j] -- Jesus Christ\n";
       menu += "\t[g] -- Godhead\n";
       menu += "\t[s] -- Plan of Salvation\n";
       menu += "\t[d] -- Doctrine of Christ\n";
       menu += "\t[p] -- Priesthood\n";
       menu += "\t[c] -- Commandments\n";
       menu += "\t[t] -- Temples and Family History\n";

       return menu;
   }

   String printDoctrineChrist() {
       String subMenu = null;
       subMenu += "\nThere are multiple topics associated with that topic. Choose one of the following options to see a specific topic: \n";
       subMenu += "\t[d] -- Doctrine of Christ (general)\n";
       subMenu += "\t\t[df] -- Faith\n";
       subMenu += "\t\t[dr] -- Repentance\n";
       subMenu += "\t\t[db] -- Baptism\n";
       subMenu += "\t\t[dh] -- Gift of the Holy Ghost\n";
       subMenu += "\t\t[de] -- Endure to the end\n";

       return subMenu;
   }
   String printPlan() {
       String subMenu = null;
       subMenu += "\nThere are multiple topics associated with that topic. Choose one of the following options to see a specific topic: \n";
       subMenu += "\t[s] -- Plan of Salvation\n";
       subMenu += "\t\t[sp] -- Premortal Existence\n";
       subMenu += "\t\t[sc] -- The Creation\n";
       subMenu += "\t\t[sa] -- Agency and the Fall of Adam and Eve\n";
       subMenu += "\t\t[sm] -- Mortal Existence\n";
       subMenu += "\t\t[sf] -- Eternal Families\n";
       subMenu += "\t\t[a] -- Atonement of Jesus Christ\n";
       subMenu += "\t\t[sd] -- Death and the Spirit World\n";
       subMenu += "\t\t[sj] -- Judgment\n";
       subMenu += "\t\t[sk] -- Kingdoms of Glory\n";

       return subMenu;
   }
   String printCommandments() {
       String subMenu = null;
       subMenu += "\nThere are multiple topics associated with that topic. Choose one of the following options to see a specific topic: \n";
       subMenu += "\t[c] -- Commandments\n";
       subMenu += "\t\t[cca] -- Law of Chastity\n";
       subMenu += "\t\t[cf] -- Law of the Fast\n";
       subMenu += "\t\t[cm] -- Missionary Work\n";
       subMenu += "\t\t[cs] -- Sabbath Day Observance\n";
       subMenu += "\t\t[cco] -- Ten Commandments\n";
       subMenu += "\t\t[ct] -- Law of Tithing\n";
       subMenu += "\t\t[cw] -- Word of Wisdom\n";

       return subMenu;
   }
    void initializeOptions() {
        options.add("t");
        options.add("c");
        options.add("p");
        options.add("d");
        options.add("g");
        options.add("j");
        options.add("a");
    }
    void initializeSubOptions() {
        subOptions.add("d");
        subOptions.add("df");
        subOptions.add("dr");
        subOptions.add("db");
        subOptions.add("dh");
        subOptions.add("de");

        subOptions.add("s");
        subOptions.add("sp");
        subOptions.add("sc");
        subOptions.add("sa");
        subOptions.add("sm");
        subOptions.add("sf");
        subOptions.add("sd");
        subOptions.add("sj");
        subOptions.add("sk");

        subOptions.add("c");
        subOptions.add("cca");
        subOptions.add("cf");
        subOptions.add("cm");
        subOptions.add("cs");
        subOptions.add("cco");
        subOptions.add("ct");
        subOptions.add("cw");
    }

}
