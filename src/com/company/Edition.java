package com.company;

public class Edition {

    private String title;
    private int cntPages;
    private SizeOfPages size;
    private PaperType paperType;
    private int quantity;
    private final int averageEditionQuantity = 300;

    public Edition(String title, int cntPages, SizeOfPages size, PaperType paperType, int quantity) {
        this.title = title;
        this.cntPages = cntPages;
        this.size = size;
        this.paperType = paperType;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public int getCntPages() {
        return cntPages;
    }

    public SizeOfPages getSize() {
        return size;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAverageEditionQuantity() {
        return averageEditionQuantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCntPages(int cntPages) {
        this.cntPages = cntPages;
    }

    public void setSize(SizeOfPages size) {
        this.size = size;
    }

    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", cntPages=" + cntPages +
                ", size=" + size +
                ", paperType=" + paperType +
                '}';
    }

    public double paperCostsPerEdition(){
        return cntPages * (paperType.getPrice() + size.getPrice());
    }

    public double basicPricePerEdition(){
        double price = 0;
        if(paperType.equals(PaperType.GLOSSY)){
            if(size.equals(SizeOfPages.A1)) {
                price = 0.20 * cntPages;
            }else if(size.equals(SizeOfPages.A2)){
                price = 0.15 * cntPages;
            }else{
                price = 0.10 * cntPages;
            }
        }else if(paperType.equals(PaperType.REGULAR)){
            if(size.equals(SizeOfPages.A1)){
                price = 0.18 * cntPages;
            }else if(size.equals(SizeOfPages.A2)){
                price = 0.15 * cntPages;
            }else{
                price = 0.09 * cntPages;
            }
        }else{
            if(size.equals(SizeOfPages.A1)){
                price = 0.19 * cntPages;
            }else if(size.equals(SizeOfPages.A2)){
                price = 0.16 * cntPages;
            }else{
                price = 0.07 * cntPages;
            }
        }
        return price;
    }

    public double finalPricePerEdition(){
        double basicPrice = basicPricePerEdition();
        if(quantity >= averageEditionQuantity){
            return basicPrice * 0.9;
        }

        return basicPrice;
    }
}
