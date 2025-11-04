package methods;

public class Methods {
    static void even(int i){
        if(i % 2 == 0){
            System.out.printf("Zahl %d ist gerade", i);
        } else{
            System.out.printf("Zahl %d ist ungerade", i);
        }
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 20;
        even(a);
    }
}
