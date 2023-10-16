package display;

public class display {
    private int value=0;
    private int limit=0;
    public display(int limit)
    {
        this.limit=limit;
    }
    public void increasea()
    {
        value++;
        if(value==limit){
            value=0;
        }
    }
    public  int getLimit()
    {
        return value;
    }

}
