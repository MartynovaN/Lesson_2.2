package lesson7;

public class NumberComparator {

    public int compare(int first, int second) {
        if (first < second) {
            return -1;
        }

        if (first > second) {
            return 1;
        }

        return 0;
    }
}