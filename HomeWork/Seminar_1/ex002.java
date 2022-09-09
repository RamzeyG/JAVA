// вывод вариантов маршрута от числа а к числу b хотя бы одного

public class ex002 {
    
    static int solve(int start, int end, int com1, int com2) {
        int[] ways = new int[end + 1];
        ways[start] = 1;
    
        for (int index = start+1; index <= end; index++) {
    
            if (index % com2 == 0){
                if(index-com1>0) {
                    ways[index] = ways[index - com1] + ways[index / com2];
                }
                else{
                    ways[index] = ways[index / com2];
                }
            } 
            else {
                ways[index] = ways[index - com1];
            }
        }
        
    
        // System.out.println(print(ways));
        String outdata = String.format("Общее количество маршрутов от %d до %d равно: %d", start, end, ways[end]);
        System.out.println(outdata);
        Steps(ways, com1, com2, start, end);
        return ways[end];

    }

    static void Steps(int[] ways, int com1, int com2, int start, int end){
        int R = 0;
        
        String result = String.format(" - это один вариант маршрута от %d до %d:", start, end);
        
        String command1 = String.format(" Step(+%d)", com1);
        String command2 = String.format(" Step(*%d)", com2);
       
        int i = ways.length-1;
        while(i > start & (i-com1>0)){
            if(ways[i] != 0){
                if(i%com2 == 0 & i/com2>start){
                    result = command2 + result;
                    R = 1;
                    i = i/com2;
                }
                else{
                    //System.out.println(i);
                    result = command1 + result;
                    R = 1;
                    i = i - com1; 
                }

            }
            else{
                i= i - com1;
            }
        }


        
        if(R == 0){
            System.out.println("Возможных маршрутов увы не найдено :(");
        }
        else{
            System.out.println(result);
            
        }

    }

    static String print(int[] items){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < items.length; i++){
            sb.append(String.format("(%d)%d", i, items[i]));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        
        solve(12, 144, 1, 2);
        
    }
}
