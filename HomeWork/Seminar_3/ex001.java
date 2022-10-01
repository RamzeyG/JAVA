
// Написать программу, показывающую последовательность действий для игры “Ханойская башня”


public class ex001 {

    static void func(int number, String result){
        for(int i = 0; i < result.length(); i++){
            if(number%2 == 0){
                if(result.charAt(i)%2 == 0){
                    
                    System.out.printf("Диск %s смещаем влево\n", result.charAt(i));
                }
                else{
                    System.out.printf("Диск %s смещаем вправо\n", result.charAt(i));

                }

            }

		    else{
                if(result.charAt(i)%2 == 0){
                    
                    System.out.printf("Диск %s смещаем вправо\n", result.charAt(i));
                }
                else{
                    System.out.printf("Диск %s смещаем влево\n", result.charAt(i));

                }

            }
        }
    }

    static void func1(int number){
        String result = "1";
        
        for(int i = 2; i<=number; i++){
            String str = Integer.toString(i);
            result = result + str + result;
        }
        System.out.println("Всего ходов: ");
        System.out.println(result.length());
        func(number, result);

    }
    public static void main(String[] args) {
        
        func1(5);
    }
    
    }

