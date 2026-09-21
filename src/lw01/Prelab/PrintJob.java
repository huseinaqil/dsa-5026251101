public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    protected PrintJob(String id, int pages){
        if(pages <= 0){
            throw new IllegalArgumentException("Pages can not be zero or negative");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId(){
        return id;
    }
    
    public int getPages(){
        return pages;
    }
    
    public int calculateCharge(){return 0;};

    public int calculateCharge(int copies){
        if(copies <= 0){
            throw new IllegalArgumentException("Copies can not be zero or negative");
        }
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return  id + " | " + label() + " | " + calculateCharge();
    }
}
