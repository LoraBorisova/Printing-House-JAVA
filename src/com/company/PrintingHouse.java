package com.company;

import jdk.nio.mapmode.ExtendedMapMode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintingHouse {

    private List<Edition> editionList;
    private List<Employee> employeeList;
    private List<Machine> machineList;
    private final double averageIncome = 4000; //Stoinost za prihodi, neobhodimi za uvelicheniq
    private final double managerBonus = 1.2; // 20% bonus for managers

    public PrintingHouse(List<Edition> editionList, List<Employee> employeeList, List<Machine> machineList) {
        this.editionList = editionList;
        this.employeeList = employeeList;
        this.machineList = machineList;
    }

    public PrintingHouse() {
        this.editionList = new ArrayList<>();
        this.employeeList = new ArrayList<>();
        this.machineList = new ArrayList<>();
    }

    public List<Edition> getEditionList() {
        return editionList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public double getAverageIncome() {
        return averageIncome;
    }

    public void setEditionList(List<Edition> editionList) {
        this.editionList = editionList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "PrintingHouse{" +
                "editionList=" + editionList +
                ", employeeList=" + employeeList +
                '}';
    }

    public void addEdition(Edition edition){
        editionList.add(edition);
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void addMachine(Machine machine){
        machineList.add(machine);
    }

    public double paperCosts(){
        double costs = 0;
        for(Edition edition : editionList){
            costs += edition.getQuantity() * edition.paperCostsPerEdition();
        }
        return costs;
    }

    public double salaryCost(){
        double income = editionsIncome();
        double costs = 0;
        for (Employee employee : employeeList){
            if(employee.getType() == EmployeeType.MANAGER && income >= averageIncome)
            {
                costs += employee.getSalary() * managerBonus;
            }
            else
            {
                costs += employee.getSalary();
            }
        }
        return costs;
    }

    public double allCosts(){
        return paperCosts() + salaryCost();
    }

    public double editionsIncome(){
        double income = 0;
        for(Edition edition : editionList){
            income += edition.finalPricePerEdition() * edition.getQuantity();
        }
        return income;
    }

    public double income(){
        return editionsIncome() - allCosts();
    }

    public void writEditionAndIncomeToFile(String filename) {

        try (FileWriter fileWriter = new FileWriter(filename)) {
            for(Edition edition : editionList) {
                fileWriter.write( "Title: " + edition.getTitle() + ", pages: "
                        + edition.getCntPages() + ", size of pages: " + edition.getSize() +
                        ", type of paper: " + edition.getPaperType() + ", quantity: " + edition.getQuantity() + "; "
                + System.lineSeparator());

            }
            fileWriter.write("Final income: " + income() + ", income from editions: " + editionsIncome() +
                    ", costs: " + allCosts() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
