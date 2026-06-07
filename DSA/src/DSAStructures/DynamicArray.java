package DSAStructures;

public class DynamicArray {
    private int length;
    private int[] innerArr;

    public DynamicArray() {
        this.length = 2;
        this.innerArr = new int[length];
    }

    //O(N + N) = O(N)
    public void add(int value) {
            increaseIfItsNecessary();

        for (int i = 0; i < length; i++) {
            if (innerArr[i] == 0) {
                innerArr[i] = value;
                return;
            }
        }
    }

    //O(N-I) = O(N)
    public void delete(int index) {
        if (index < 0 && index > length - 1)
            return;

        for (int i = index; i < length; i++) {
            if (i + 1 == length) {
                innerArr[i] = 0;
                continue;
            }

            innerArr[i] = innerArr[i + 1];
        }

        reduceArrIfItsNecessary();
    }

    //O(N)
    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print((length - 1 == i) ? innerArr[i] : innerArr[i] + ", ");
        }

        System.out.println();
    }

    //O(N)
    public int search(int value) {
        for (int i = 0; i < length; i++) {
            if (innerArr[i] == value)
                return i;
        }

        return -1;
    }

    //O(N)
    private void increaseIfItsNecessary() {
        if (this.innerArr[length - 1] == 0)
            return;

        this.length *= 2;
        int[] oldArr = innerArr;
        innerArr = new int[length];

        //more efficient - jni native operation, wrote in c/c++
        System.arraycopy(oldArr, 0, innerArr, 0, oldArr.length);
    }

    private void reduceArrIfItsNecessary() {
        int populatedAreas = 0;
        for(int i : innerArr) {
            if(i == 0)
                continue;

            populatedAreas++;
        }

        if(populatedAreas > length / 4)
            return;


        this.length = Math.max(length / 2, 2);
        int[] oldArr = innerArr;
        innerArr = new int[length];

        System.arraycopy(oldArr, 0, innerArr, 0, length);
    }
}
