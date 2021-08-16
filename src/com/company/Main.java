package com.company;

import com.sun.java.accessibility.util.EventID;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> readFile(String inputFilename) {
        List<String> infoList = new ArrayList<>();
        try (FileReader fis = new FileReader(new File(inputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                infoList.add(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infoList;
    }

    public static void main(String[] args) {

        File filesDirectory = new File("files");

        Edition edition = new Edition("The Grapes of Wrath", 479, SizeOfPages.A3, PaperType.GLOSSY, 250);

        Edition edition1 = new Edition("A Farewell to Arms",293, SizeOfPages.A4, PaperType.REGULAR,100);

        Edition edition2 = new Edition("East of Eden",601,SizeOfPages.A5,PaperType.NEWSPAPER,300);

        Employee employee = new Employee(EmployeeType.MANAGER);
        Employee employee1 = new Employee(EmployeeType.OPERATOR);

        PrintingHouse printingHouse = new PrintingHouse();

        printingHouse.addEdition(edition);
        printingHouse.addEdition(edition1);
        printingHouse.addEdition(edition2);

        printingHouse.addEmployee(employee);
        printingHouse.addEmployee(employee1);
        System.out.println("Paper costs: " + printingHouse.paperCosts());
        System.out.println("Salary costs:" + printingHouse.salaryCost());
        System.out.println("All costs: " + printingHouse.allCosts());
        System.out.println("Income from editions: " + printingHouse.editionsIncome());
        System.out.println("Income from editions - costs: " + printingHouse.income());

        Machine machine1 = new Machine(1, 600,Colour.BLACK);
        machine1.loadPaper(480);
        Machine machine2 = new Machine(2,350,Colour.COLOURED);
        machine2.loadPaper(300);
        Machine machine3 = new Machine(3,800,Colour.BLACK);
        machine3.loadPaper(650);

        printingHouse.addMachine(machine1);
        printingHouse.addMachine(machine2);
        printingHouse.addMachine(machine3);

        String fileName = "files/Info.txt";
        printingHouse.writEditionAndIncomeToFile(fileName);

        System.out.println("FILE: ");

        List<String> infoRead = new ArrayList<>(readFile(fileName));
        System.out.println(infoRead);

        machine1.printing(edition);
        machine2.printing(edition1);
        machine3.printing(edition2);

    }

}
