import java.util.Arrays;
import java.util.Random;

public class Program {
    /* 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
       2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
       3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE
          сохранить в массив m1
       4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i
          и сохранить в массив m2
       Пункты реализовать в методе main
       *Пункты реализовать в разных методах
        int i = new Random().nextInt(k); //это кидалка случайных чисел!)
     */

    public static void main(String[] args) {
        int i = randomNumber();
        System.out.println("Случайное целое число: " + i);

        int n = highBit(i);
        System.out.println("Номер старшего бита числа: " + n);

        int[] m1 = new int[1];
        m1 = arrayMultiple1(m1, i, n);
        System.out.println("массив м1: ");
        System.out.println(Arrays.toString(m1));

        int[] m2 = new int[1];
        m2 = arrayMultiple2(m2, i, n);
        System.out.println("массив м2: ");
        System.out.println(Arrays.toString(m2));

    }
    static int randomNumber(){
        return new Random().nextInt(0,2001);
    }
    static int highBit(int num){
        System.out.println("Представление числа "+ num+ " в бинарном виде: " + Integer.toBinaryString(num));
        return Integer.toBinaryString(num).length();
    }

    static boolean noResidue(int divisible, int divider){
        return divisible % divider == 0;
    }

    static boolean Residue(int divisible, int divider){
        return divisible % divider != 0;
    }
    static int[] newArray(int[] oldArray, int newItem){
        int[] newArr = new int[oldArray.length+1];
        System.arraycopy(oldArray, 0, newArr, 0,oldArray.length);
        newArr[newArr.length-1] = newItem;
        return newArr;
    }
    static int[] arrayMultiple1(int[] arr, int numStar, int numDiv){
        int index = 0;
        for (int j = numStar; j < Short.MAX_VALUE; j++) {
            boolean bool = noResidue(j, numDiv);
            if (bool){
                if (index == 0){
                    arr[index] = j;
                }else {
                   arr = newArray(arr, j);
                }
                index++;
            }
        }
        return arr;
    }

    static int[] arrayMultiple2(int[] arr, int numStop, int numDiv){
        int index = 0;
        for (int j = Short.MIN_VALUE; j < numStop+1; j++) {
            boolean bool = Residue(j, numDiv);
            if (bool){
                if (index == 0){
                    arr[index] = j;
                }else {
                    arr = newArray(arr, j);
                }
                index++;
            }
        }
        return arr;
    }
}
