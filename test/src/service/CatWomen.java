package service;

public  class CatWomen implements Cat, Person{
    private static final Long id = 18L;
    private String name;
    @Override
    public void print(int x) {
        System.out.println("Cat"+x);
    }

    @Override
    public void print() {
        System.out.println("Person"+this.name);
    }

    @Override
    public Object get() {
        System.out.println(Person.id+Cat.id+id);
        return this;
    }

    public CatWomen(String name) {
        this.name = name;
    }
}
