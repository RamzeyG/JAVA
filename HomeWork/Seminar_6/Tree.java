// 1. Описать класс для работы с бинарным деревом  
// 1.1 Реализовать три варианта обхода 
// 1.2 Сделать скобочную запись бинарного дерева

public class Tree{
    public Tree(Integer v){
        value = v;
    }

    Integer value;
    Tree left;
    Tree right;




    static void printArray(int[] array){
        
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

    }

    

    public void NewNode(Tree Node){
        if(Node.value < value){
        
            if ( left != null ){
                
                left.NewNode(Node);
            
            }
            else{
                
                left = Node;
            
            }
        }
        else{
            
            if ( right != null ){
                
                right.NewNode(Node);
                
            } 
            else{
                
                right = Node;

            } 
        }
        
        
    }
class Iterr{

    static void NLR(Tree n, String s){
        if(n != null){
            System.out.printf("%s%d\n", s,  n.value);
            if (n.left != null) {
                NLR(n.left, s + "  ");
            }
            if (n.right != null) {
                NLR(n.right, s + "  ");
            }
        }
    }

    static void LNR(Tree n, String s){
        s = " ";
        if(n != null){
            if (n.left != null) {
                LNR(n.left, s);
            }
            System.out.printf("%s%d", s,  n.value);
            if (n.right != null) {
                LNR(n.right, s);
            }
        }
    }

    static void LRN(Tree n, String s){
        s = " ";
        if(n != null){
            if (n.left != null) {
                LRN(n.left, s);
            }
            if (n.right != null) {
                LRN(n.right, s);
            }
            System.out.printf("%s%d", s,  n.value);
        }
    }

    static void BracketNotation(Tree n){
        String lB = "(";
        String rB = ")";
        String s = " ";
        if(n != null){
            System.out.printf("%s%d", s,  n.value);
            if (n.left != null) {
                System.out.printf("%s%s", s, lB);
                BracketNotation(n.left);
            }
            if(n.left == null && n.right != null){
                System.out.printf("%s%s", s, lB);
                // System.out.printf("%s%s", s, "null,");
            }
            if(n.left != null && n.right != null){
                System.out.printf("%s%s", s, ",");

            }
            if (n.right != null) {
                BracketNotation(n.right);
                System.out.printf("%s%s", s, rB);
            }
            
        }

    }

}

 

    public static void main(String[] args) {
        int[] array = new int[] {15, 28, 4, 7, 16, 18, 5, 9, 22, 32};

        Tree Node = new Tree(null);

        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                Node = new Tree(array[i]);
            }
            else{
                Node.NewNode(new Tree(array[i]));
            }
        }

        String space = "";
        System.out.println("\n\nПрямой обход:");
        Iterr.NLR(Node, space);

        System.out.println("\n\nСкобочная запись:");
        Iterr.BracketNotation(Node);

        System.out.println("\n\nЦентрированный обход:");
        Iterr.LNR(Node, space);

        System.out.println("\n\nОбратный обход:");
        Iterr.LRN(Node, space);

    }
}

