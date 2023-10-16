package service;

import entity.Book;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static Scanner in = new Scanner(System.in);
    static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {

        boolean tag = true;
        System.out.println("欢迎使用图书管理系统");
        while (tag) {
            System.out.println("<------------>");
            System.out.println("1.新增图书");
            System.out.println("2.删除图书");
            System.out.println("3.查询图书");
            System.out.println("0.退出图书管理系统");
            int op = in.nextInt();
            switch (op) {
                case 1 -> insert();
                case 2 -> {
                    String name = in.next();
                    remove(name);
                }
                case 3 -> {
                    boolean SortTag = true;
                    while (SortTag) {
                        System.out.println(">---选择查询方式---<");
                        System.out.println("1.模糊查询（依据书名或作者）");
                        System.out.println("2.ISSN查询");
                        System.out.println("3.查询所有");
                        System.out.println("0.退出查询");
                        int o = in.nextInt();
                        switch (o) {
                            case 1 -> show(in.next());
                            case 2 -> show(in.next("ISSN-\\d{4}-\\d{4}"));
                            case 3 -> show();
                            case 0 -> SortTag = false;
                            default -> System.out.println("输入错误请重试");
                        }
                    }
                }
                case 0 -> {
                    System.out.println("感谢您的使用,bye");
                    tag = false;
                }
                default -> System.out.println("输入错误请重新选择");
            }
        }
    }

    public static void insert() {
        while (true) {
            String name = in.next();
            String author = in.next();
            String press = in.next();
            String ISSN = in.next();
            String date = in.next();
            Integer page = in.nextInt();
            String Abstract = in.next();
            if (!(name.isEmpty() || author.isEmpty() || press.isEmpty() || ISSN.isEmpty() || date.isEmpty() || Abstract.isEmpty())) {
                boolean found = false;
                for (Book book : bookList) {
                    if (book.getName().equals(name)) {
                        found = true;
                        System.out.println(name + "该书已存在:" + book);
                        break;
                    }
                }
                if (!found) {
                    bookList.add(new Book(name, author, press, ISSN, date, page, Abstract));
                    break;
                }
            } else {
                System.out.println("输入错误");
            }
        }
    }

    public static void remove(String name) {
        boolean found = false;
        for (Book book : bookList) {
            if (book.getName().equals(name)) {
                bookList.remove(book);
                found = true;
                System.out.println("删除成功" + book);
                break;
            }
        }
        if (!found) {
            System.out.println("查无此书");
        }
    }

    public static void show(String temp) {
        List<Book> books = bookList.stream()
                .filter(book -> (book.getName().contains(temp) || book.getAuthor().contains(temp)) || book.getISSN().equals(temp))
                .toList();
        System.out.println("查询结果如下:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void show() {
        for (Book b : bookList) {
            System.out.println(b);
        }
    }
}
