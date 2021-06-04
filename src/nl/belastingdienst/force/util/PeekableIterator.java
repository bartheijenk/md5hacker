package nl.belastingdienst.force.util;

import java.util.Iterator;

public interface PeekableIterator<T> extends Iterator<T> {
    T peek();
}
//ff