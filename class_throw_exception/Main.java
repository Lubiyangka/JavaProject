public class Main {
    public static void throwSome() throws Exception{
        int i = 0;
        String[] str = {"Curry", "James", "John", "Niko", "Simple"};
        while(i<6){
            System.out.println(str[i]);
            i++;
        }
    }

    public static void throwException(){
        int i = 0;
        String[] str = {"Curry", "James", "John", "Niko", "Simple"};
        while(i<6){
            try{
                System.out.print(str[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("\nResetting Index Value");
            }catch (Exception e){
                System.out.println(e.toString());
            }finally {
                System.out.print("-->");
            }
            i++;
        }
    }
    public static void main(String[] args){
        throwException();
        System.out.println("\n\n");
        try{
            throwSome();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
