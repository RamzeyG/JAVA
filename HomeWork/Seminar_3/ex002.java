
// Реализовать алгоритм пирамидальной сортировки (HeapSort)

public class ex002 {
    
    static void printArray(int[] array){
        
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

    }

    static void sort(int[] array){
        int len = array.length;

        for(int i = len/2-1; i>=0; i--){
            sort1(array, len, i);
        }

        for(int i = len-1; i >= 0; i--){
            int T = array[0];
            array[0] = array[i];
            array[i] = T;
            sort1(array, i, 0);
        }
    }

    static void sort1(int[] array, int len, int i){

        int max = i;
        int L = 2*i+1;
        int R = 2*i+2;

        if(L<len && array[L]>array[max]){
            max = L;
        }
        if(R<len && array[R]>array[max]){
            max = R;
        }
        if(max != i){
            int t = array[i];
            array[i] = array[max];
            array[max] = t;
            sort1(array, len, max);
        }
        

    }
    
    public static void main(String[] args) {
        
        int[] array = new int[] {15, 28, 4, 7, 16, 18, 5, 9, 22, 32, 16, 4};
        System.out.println("Начальный массив:");
        printArray(array);

        sort(array);
        
        System.out.println("Сортированный массив:");
        printArray(array);
        
    }
}
