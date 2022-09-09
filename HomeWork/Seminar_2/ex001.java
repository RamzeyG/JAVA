package HomeWork.Seminar_2;

public class ex001 {
    static void number(int x){
        int result = x*(x+1)/2; 
        String OutData = String.format("%d треугольное число равно %d", x, result);
        System.out.println(OutData);
    }


    public static void main(String[] args){
        number(1);
        number(2);
        number(3);
        number(4);
    }
}
