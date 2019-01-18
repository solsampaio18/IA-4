import java.util.Vector;
import java.util.HashSet;
import java.lang.Math;

class Table{
    private static Object[][] table;

    Table(Object[][] table){
        this.table = table;
    }


    //se entropia = 0 conjunto é puro
    //senão deve-se escolher o menor possível ( o mais afastado do 0)
    public static double calculateEntropy(Vector<Integer> indexList, int col,
                                       HashSet<Object> values){
        for(Object elem : values){ //itero só para chegar ao primeiro elem e retornar logo.
            if(elem instanceof String) {
                return calculateEntropyCategoric(indexList,col,values);
            }
            else{//elem instanceof Interval
                return calculateEntropyNumeric(indexList,col,values);
            }
        }
        return 0; //se o set por alguma razão tiver vazio então = 0
    }

    private static double calculateEntropyNumeric(Vector<Integer> indexList, int col,
                                          HashSet<Object> values) {
        Object[] valueList = new Object[values.size()];//vetor com os intervalos
        int[] quantity = new int[values.size()];//quantidade de elems dentro do intervalo
        int i = 0;
        for(Object value : values){
            valueList[i] = value;
            i++;
        }
        i = 0;
        for(Object value : valueList){
            for(int k=0;k<table.length;k++) {
                Interval aux = (Interval) value;
                if(aux.isInside((double) table[k][col]) && indexList.contains(k)){ //tenho de dar cast e tem de ser um index da lista
                    quantity[i]++;
                }
            }
            i++;
        }
        double result = 0;
        for(i=0;i<quantity.length;i++){
            if(quantity[i] == 0){//para evitar erros com logaritmo
                continue;//equivalente a result += 0
            }
            result += -1*quantity[i]*Math.log(quantity[i])/Math.log(2);
        }
        return result;
    }


        //função auxiliar para calcular entropia para valores categóricos
    private static double calculateEntropyCategoric(Vector<Integer> indexList, int col,
                                          HashSet<Object> values) {
        Object[] valueList = new Object[values.size()];//o HashSet num vetor.
        int[] quantity = new int[values.size()];//quantidade de cada elem do hashset
        int i = 0;
        for(Object value : values){
            valueList[i] = value;
            i++;
        }
        //cálculo das quantidades de cada elemento para um vetor com as quantidades de cada
        //elemento do hashset dado
        i = 0;
        for(Object value : valueList){
            for(int k=0;k<table.length;k++){
                if(table[k][col].equals(value) && indexList.contains(k)){//tem de ser um index da lista
                    quantity[i]++;
                }
            }
            i++;
        }
        //Entropy(Decision) = – p(Yes)*log2p(Yes) – p(No)*log2p(No) -p(OutraCoisa)*log2p(OutraCoisa) ..
        double result = 0;
        for(i=0;i<quantity.length;i++){
            if(quantity[i] == 0){//para evitar erros com logaritmo
                continue;//equivalente a result += 0
            }
            result += -1*quantity[i]*Math.log(quantity[i])/Math.log(2);
        }
        return result;
    }


    public void print(){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[i].length;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}