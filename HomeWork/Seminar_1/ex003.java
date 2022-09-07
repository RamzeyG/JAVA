//решение с рекурсией
public class ex003 {

    static void recursion(int index, int[] ways, int com1, int com2, int start, int end){
        
        if(index <= end){
            if(index%com2 == 0){
                ways[index] = ways[index/com2] + ways[index-com1];
            }
            else{
                ways[index] = ways[index-com1];
            }
            index++;
            recursion(index, ways, com1, com2, start, end);
        }        
        
    }
    
    static int soleve(int start, int end, int com1, int com2){
        int[] ways = new int[end + 1];
        ways[start] = 1;
        int index = start + com1;
        recursion(index, ways, com1, com2, start, end);
       

        System.out.println(print(ways));
        return ways[end];

    }

    static String print(int[] items){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < items.length; i++){
            sb.append(String.format("(%d)%d", i, items[i]));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(soleve(2, 54, 2, 4));
    }
}
