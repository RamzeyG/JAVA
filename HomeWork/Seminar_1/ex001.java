// В коде из семинара возникла проблема при условии что + шаг больше чем шаг умножения

// static int solve(int start, int end, int com1, int com2) {
//     int[] ways = new int[end + 1];
//     ways[start] = 1;

//     for (int index = start + com1; index <= end; index++) {

//       if (index % com2 == 0) {
//         ways[index] = ways[index - com1] + ways[index / com2];
//       } else {
//         ways[index] = ways[index - com1];
//       }
//     }
//     System.out.println(print(ways));
//     return ways[end];
//   }

// доработал, приложил, незнаю зачем пусть лежит.

public class ex001{
    static void solve(int start, int end, int com1, int com2) {
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
        
    
        System.out.println(print(ways));
        String outdata = String.format("Общее количество маршрутов от %d до %d равно: %d", start, end, ways[end]);
        System.out.println(outdata);

    }
    
      static String print(int[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
    
          sb.append(String.format("(%d)%d ", i, items[i]));
        }
        return sb.toString();
      }
    
      public static void main(String[] args) {
        solve(2, 7, 3, 2);
      }
    
    }