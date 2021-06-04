package nl.belastingdienst.force.generator;

import nl.belastingdienst.force.util.PeekableIterator;

import java.util.function.Supplier;

public class CharacterSupplier implements PeekableIterator<Character> {

    private static final char[] charList = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
//    private static final char[] charList = "ab".toCharArray();ff
    private int index = 0;

    @Override
    public Character peek() {
//        return index < charList.length ? charList[index] : charList[0];
        return charList[index];
    }

    @Override
    public boolean hasNext() {
        return index < charList.length;
    }

    @Override
    public Character next() {
        return charList[index++];
    }

    public void reset() {
        this.index = 0;
    }
}
