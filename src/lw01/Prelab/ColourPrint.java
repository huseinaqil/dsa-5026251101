public class ColourPrint extends PrintJob {
    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    @Override
    public int calculateCharge() { 
        if (pages >= 10){
            return ((pages - 10) * 1000 + 15000 + 2000);
        }
        else {
            return pages * 1500;
        }
    }

    @Override
    public String label(){
        return "Colour";
    }

}
