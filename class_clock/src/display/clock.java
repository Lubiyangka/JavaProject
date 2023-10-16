package display;

public class clock {
    private display hour;
    private display minute;

    public clock()
    {
        hour=new display(24);
        minute=new display(60);
    }
    public void start()
    {
        while(true) {
            minute.increasea();
            if (minute.getLimit() == 0) {
                hour.increasea();
            }
            System.out.printf("%02d:%02d\n", hour.getLimit(), minute.getLimit());
        }
    }
}
