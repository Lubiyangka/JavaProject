package clock;

import display.NoteBook;
import display.clock;
//import display.*;引用了display包内的所有类

public class Main {
    public static void main(String[] args)
    {
//        clock am=new clock();
//        am.start();
        NoteBook nb=new NoteBook();
        nb.add("hahhh");
        nb.add("anhhh");
        nb.add("jj",1);
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(0));
        System.out.println(nb.getNote(1));
        nb.removeNote(1);
        String[] ar=nb.list();
        for(String s:ar){
            System.out.println(s);
        }
    }
}