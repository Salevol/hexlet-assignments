package exercise;

import java.util.ArrayList;
import java.util.List;

class ReversedSequence implements CharSequence {

    private String str;

    ReversedSequence (String str) {
        this.str = new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return this.str.length();
    }

    @Override
    public char charAt(int i) {
        return this.str.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return this.str.subSequence(i, i1);
    }

    @Override
    public String toString() {
        return this.str;
    }
}
