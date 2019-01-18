import java.util.Scanner;
import java.util.HashSet;
import java.util.Vector;

class Test{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String file;
        System.out.println("ficheiro:");
        file = stdin.next() + ".csv";
        Data info = Data.getData(file);
        Object[][] table = info.getTable();
        Vector<HashSet<Object>> attributeList = info.getFormattedAttributes();
//        for(HashSet<Object> hashSet : attributeList){
//            for(Object elem : hashSet){
//                System.out.print(elem);
//                if(elem instanceof Double) System.out.println("--> Double");
//                else System.out.println("-->String");
//            }
//        }
        Vector<Integer> indexList = new Vector<Integer>();
        indexList.add(1);
        indexList.add(2);
        indexList.add(3);

        Table tabela = new Table(table);
        tabela.print();


        double result = Table.calculateEntropy(indexList,2,attributeList.elementAt(2));
        System.out.println(result);



//        for(HashSet hashset : info.getFormattedAttributes()){
//            for(Object elem : hashset){
//                System.out.print(elem);
//                if(elem instanceof Interval) System.out.print("<<<<<");
//                System.out.println();
//            }
//        }

//        for(int i=0;i<table.length;i++){
//            for(int j=0;j<table[i].length;j++){
//                System.out.print(table[i][j]);
//                if(table[i][j] instanceof Double){
//                    System.out.println("--> Double");
//                }
//                else if(table[i][j] instanceof String){
//                    System.out.println("--> String");
//                }
//            }
//            System.out.println();
//        }
//        String[] nomes = info.getAttributeNames();
//        for(String word : nomes){
//            System.out.print(word + ", ");
//        }
//        System.out.println();
    }
}