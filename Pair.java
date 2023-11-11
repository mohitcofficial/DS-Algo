import java.util.*;

class Pair implements Comparable<Pair> {

    int first, second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.first != o.first) {
            return this.first - o.first;
        } else {
            return this.second - o.second;
        }
    }
}