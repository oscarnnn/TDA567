package lab1;
import java.util.*;

public class Set {
    private ArrayList<Integer> a;

    public Set() {
        a = new ArrayList<Integer>();
    }

    public int[] toArray() {
        int[] ia = new int[a.size()];
        for (int i = 0; i < ia.length; i++) {
            ia[i] = a.get(i);
        }
        return ia;
    }

    public void insert(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (x < a.get(i)) {
                a.add(i, x);
                return;
            } else {
                if (a.get(i) == x) {
                    return;
                }
            }
        }
        a.add(x);
    }

    public boolean member(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (x < a.get(i)) {
                return false;
            } else {
                if (a.get(i) == x) {
                    return true;
                }
            }
        }
        return false;
    }

    public void section(Set s) {
        for (int i = 0, j = 0; i < a.size() && j < s.a.size();) {
            if (a.get(i).equals(s.a.get(j))) {
                a.remove(i);
                i++;
                j++;
            } else {
                if (a.get(i) < s.a.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
        }
    }

    public boolean containsArithTriple() {
        if(a.size() < 3){
            return false;
        }
        for (int i = 0; i < a.size()-1; i++) {
                //find if z is in set by using 2y -x as z, because of y-x = z-y
            if (member(2*a.get(i)-a.get(i+1))){
                return true;
            }
        }
        return false;
    }
}

