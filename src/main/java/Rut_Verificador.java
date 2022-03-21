import java.util.Scanner;

public class Rut_Verificador {

    Scanner leer = new Scanner(System.in);
    public void main (String [ ] args) {
        menu();
    }

    private void menu() {
        int[] arreglo= new int[8];
        Llenar_Rut(arreglo);
        mostrar_arr(arreglo);
        inv_arr(arreglo);
        mult_arr(arreglo);
        sumar_arr(arreglo);
    }

    private int sumar_arr(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        } // suma los numeros dentro del arreglo
        int div = sum / 11; // aqui divide la suma anterior
        int mul = div*11; // la division anterior la multiplica
        int res = sum - mul; // resta la suma de los numeros del arreglo con la multiplicacion anterior
        int total = 11 - res; // al resultado anterior se lo restamos a 11
        System.out.println("su digito verificador es: "+ total);
        if(total > 9) {
            System.out.println("si su resultado es 10 su digito es k, si es 11 su digito es 0");
        }
        return sum;
    }

    private int[] mult_arr(int[] array) {
        int mul = 2;
        for (int i = 0; i < array.length; i++) {
            if(mul==8){
                mul=2;
            } // en el if estamos siguiendo la serie que se nos pide
            array[i] *= mul;
            mul++;
        }
        return array;
    }

    private int[] inv_arr(int[] array) {
        int aux;
        for (int i = 0; i < array.length / 2; i++) {
            aux = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = aux;
        }

        return array;
    }

    private void mostrar_arr(int[] array) {

        for(int i=0;i< array.length;i++){
            System.out.print("["+array[i]+"]");
        }
        System.out.println(" ");
    }

    private int[] Llenar_Rut(int[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.println("ingrese el "+(i+1)+" digito de su rut");
            array[i]=leer.nextInt();
        }
        return array;
    }

}

