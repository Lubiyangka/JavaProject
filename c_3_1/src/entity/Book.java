package entity;


import java.util.Date;

/*
设计一个简单的图书管理系统，该系统使用集合保存图书信息，包括书名、作者、出版社、刊号、出版日期、页数和摘要，
并能够实现图书的插入、删除、查找功能。插入、删除时要显示操作是否正确与否的提示信息；查找时按关键字值进行查找，并显示查找结果。
 */
public class Book {
    private String name;
    private String author;
    private String press;
    private String ISSN;
    private String date;
    private Integer page;
    private String Abstract;

    public Book(String name, String author, String press, String ISSN, String date, Integer page, String anAbstract) {
        this.name = name;
        this.author = author;
        this.press = press;
        this.ISSN = ISSN;
        this.date = date;
        this.page = page;
        Abstract = anAbstract;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", ISSN='" + ISSN + '\'' +
                ", date=" + date +
                ", page=" + page +
                ", Abstract='" + Abstract + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }
}
