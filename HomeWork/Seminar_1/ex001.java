// Показать набор команд для превращения числа а в число b

public class ex001{

public static void main(String[] args) {
    // вариант без доп переменной
    int a = 1;
    int b = 2;

    a = a + b;
    b = a - b;
    a = a - b;
    System.out.println(a);
    System.out.println(b);
    // вариант с доп переменной
    a = 1;
    b = 2;
    int c = 0;

    c = a;
    a = b;
    b = c;

    System.out.println(a);
    System.out.println(b);
    // как вариант
    a = 1;
    b = 2;
    System.out.format("Значение a = %d", b);
    System.out.println();
    System.out.format("Значение b = %d", a);

}
}