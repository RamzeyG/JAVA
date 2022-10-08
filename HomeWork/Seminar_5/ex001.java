
// Написать программу, показывающую последовательность действий для игры “Ханойская башня”


public class ex001 {


    // выводим массив
    static void printArray(int[][] array){
        System.out.println();

        for(int i =0;i<array.length; i++){
            for(int j =0;j<array[i].length; j++){

                System.out.printf("%2d ", array[i][j]);
            }
            System.out.println();
        }
    }
    
    // распространение волны
    static void Wave(int[][] array, int count, int fx, int fy){
        while(array[fx][fy] == -1){
            for(int i = 1; i < array.length-1; i++){
                for(int j = 1; j < array.length-1; j++){
                    if(array[i][j] == count){
    
                        if(array[i-1][j] != 0 && array[i-1][j] == 1 || array[i-1][j] == -1){
                            
                            array[i-1][j] = count+1;    
                        }
                        if(array[i][j+1] != 0 && array[i][j+1] == 1  || array[i][j+1] == -1){
                    
                            array[i][j+1] = count+1;
                        }
                        if(array[i+1][j] != 0 && array[i+1][j] == 1 || array[i+1][j] == -1){
                    
                            array[i+1][j] = count+1;
                        }
                        if(array[i][j-1] != 0 && array[i][j-1] == 1 || array[i][j-1] == -1){
                            
                            array[i][j-1] = count+1;   
                            
                        }
                    }
                }
            }
            
            count = count + 1;
        }
        
    }
    

    // создаем стартовое поле
    static void StartArray(int[][] array){

        
        for(int i =0;i<array.length; i++){
            for(int j =0;j<array.length; j++){
                array[i][j] = 1;
            }
        }

        for(int i = 0;i<array.length;i++){
            array[i][0] = 0;
            array[i][array.length-1] = 0;
        }

        for(int i = 0;i<array.length;i++){
            array[0][i] = 0;
            array[array.length-1][i] = 0;
        }

    }


    // показываем маршрут
    static void ShowWay(int[][] array, int sx, int sy, int fx, int fy){
        int count = array[fx][fy];
        
        int ix = fx;
        int iy = fy;

        int[][] way = new int[array.length][array.length];
        StartArray(way);
        Walls(way);
        
        int count1 = 0;

        while(array[ix][iy] != array[sx][sy]){
            for(int i = 1; i < array.length-1; i++){
                for(int j = 1; j < array.length-1; j++){
                    if(array[i][j] == count){

                        if(array[ix+1][iy] !=0 && array[ix+1][iy] == count-1){
                            way[ix][iy] = count;
                            ix = ix+1;
                            
    
                        }
                        if(array[ix-1][iy] !=0 && array[ix-1][iy] == count-1){
                            way[ix][iy] = count;
                            ix = ix-1;
                            
                            
                        }
                        if(array[ix][iy+1] !=0 && array[ix][iy+1] == count-1){
                            way[ix][iy] = count;
                            iy = iy+1;
                            
                            
                        }
                        if(array[ix][iy-1] !=0 && array[ix][iy-1] == count-1){
                            way[ix][iy] = count;
                            iy = iy-1;
                            
                            
                        }
                    }
                }
            }
            --count;
            count1++;
        }
        way[sx][sy] = array[sx][sy];
        System.out.println("\nПройденный путь: ");
        printArray(way);


    }

    static void Walls(int[][] array){
        for(int i =1; i < 9; i++){
            
            array[2][i+1] = 0;
            array[6][i+4] = 0;
            array[10][i] = 0;
            array[i][13] = 0;
            array[i+1][5] = 0;
        }
        array[9][5] = 1;
    }

    
    public static void main(String[] args) {
    // задаем размер поля, точку входа sx-sy, точку выхода fx-fy
        int sizeArray = 15;
        int sx = sizeArray - 2;
        int sy = 1;
        int fx = 1;
        int fy = sizeArray - 2;
        int StartCount = 2;
        int FinishCount = -1;



        int[][] StartArray = new int[sizeArray][sizeArray];

        StartArray(StartArray);
       
        Walls(StartArray);

        
        System.out.println("Стартовое поле: ");
        StartArray[sx][sy] = StartCount;
        StartArray[fx][fy] = FinishCount;
        printArray(StartArray);
               
        
        Wave(StartArray, StartCount, fx, fy);
        
        System.out.println("Распространение волны: ");
        printArray(StartArray);

            
        ShowWay(StartArray, sx, sy, fx, fy);
    }
    
}

