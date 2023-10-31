
/**
 * @author John-Six
 * @version 1.0
 * @since 2023.10.23
 */

/*
 * 进程：相对操作系统
 * 线程：相对程序
 * 多线程-->一个程序的多个语句同时执行
 *
 * 区分：并行&并发
 */
public class Main {
    static testThreadA threadA;
    static testThreadB threadB;
    public static void main(String[] args) {
        //实例化
        threadA = new testThreadA();
        threadB = new testThreadB();
        //YS启动！！！
        threadA.start();
        threadB.start();
    }
}

//继承法
class testThreadA extends Thread{
    @Override
    public void run() {
        for(int i = 0; i <= 5; i++){
            System.out.println("this is a test");
            try{
                sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        super.run();
    }
}
class testThreadB extends Thread{
    @Override
    public void run() {
        for(int i = 0; i <= 5; i++){
            System.out.println("hhh");
            try{
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        super.run();
    }
}