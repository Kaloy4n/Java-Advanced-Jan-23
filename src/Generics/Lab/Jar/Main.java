package Generics.Lab.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();

        jar.add("Kiril");
        jar.add("Miroslava");
        jar.remove();
        jar.remove();
        System.out.println(jar);
    }
}
