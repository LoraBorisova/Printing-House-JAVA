package com.company;

public class Machine {
    private final int numberOfMachine;
    private int maxPaperCnt;
    private Colour colour;
    private int loadedPaper = 0;

    public Machine(int numberOfMachine, int maxPaperCnt, Colour colour, int loadedPaper) {
        this.numberOfMachine = numberOfMachine;
        this.maxPaperCnt = maxPaperCnt;
        this.colour = colour;
        this.loadedPaper = loadedPaper;
    }

    public Machine(int numberOfMachine, int maxPaperCnt, Colour colour) {
        this.numberOfMachine = numberOfMachine;
        this.maxPaperCnt = maxPaperCnt;
        this.colour = colour;
    }

    public int getMaxPaperCnt() {
        return maxPaperCnt;
    }

    public Colour getColour() {
        return colour;
    }

    public int getLoadedPaper() {
        return loadedPaper;
    }

    public int getNumberOfMachine() {
        return numberOfMachine;
    }

    public void setMaxPaperCnt(int maxPaperCnt) {
        this.maxPaperCnt = maxPaperCnt;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setLoadedPaper(int loadedPaper) {
        this.loadedPaper = loadedPaper;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "numberOfMachine=" + numberOfMachine +
                ", maxPaperCnt=" + maxPaperCnt +
                ", colour=" + colour +
                ", loadedPaper=" + loadedPaper +
                '}';
    }

    public int loadPaper(int cnt){
        if(cnt <= maxPaperCnt) {
            return loadedPaper += cnt;
        }else return loadedPaper;
    }

    public boolean isLoaded(){
        return loadedPaper > 0;
    }

    public synchronized void print(Edition edition) {
         for (int i = 1; i <= edition.getCntPages(); i++) {
             System.out.println("Machine" + getNumberOfMachine() + " '" + edition.getTitle() + "' " + " page " + i);
             if (i == edition.getCntPages()) {
                 System.out.println("'" + edition.getTitle() + "' " + " has been printed.");
             }
         }
    }

    public void printing(Edition edition) throws IllegalArgumentException {
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                if(!isLoaded()){
                    throw new IllegalArgumentException("There is no loaded paper in Machine" + numberOfMachine +
                            ", you can load maximum: " + getMaxPaperCnt());
                }
                print(edition);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }
}

