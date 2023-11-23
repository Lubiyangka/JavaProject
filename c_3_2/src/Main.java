import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Thread horse1 = new HorseThread("赤兔", 10);
        Thread horse2 = new HorseThread("的卢", 7);

        horse1.start();
        horse2.start();
    }
}

class HorseThread extends Thread {
    private final String name;
    private int progress;

    public HorseThread(String name, int priority) {
        this.name = name;
        this.progress = 0;
        setPriority(priority);
    }

    @Override
    public void run() {
        while (progress < 500) {
            try {
                sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress += new Random().nextInt(5);
            if (progress > 500) {
                progress = 500;
            }
            updateProgressBar();
        }
        System.out.println(name + "到达终点");
    }

    private void updateProgressBar() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < 500; i += 10) {
            if (progress >= i + 10) {
                builder.append('=');
            } else if (progress >= i && progress < i + 10) {
                builder.append('>');
            } else {
                builder.append(' ');
            }
        }
        builder.append(']');
        System.out.print("\r" + name + ": " + builder);
    }
}