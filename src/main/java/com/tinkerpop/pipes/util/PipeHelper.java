package com.tinkerpop.pipes.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * PipeHelper provides a collection of static methods that are useful when dealing with Pipes.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PipeHelper {

    /**
     * Drain an iterator into a collection. Useful for storing the results of a Pipe into a collection.
     *
     * @param iterator   the iterator to drain
     * @param collection the collection to fill
     * @param <T>        the object type of the iterator
     */
    public static <T> void fillCollection(final Iterator<T> iterator, final Collection<T> collection) {
        while (iterator.hasNext()) {
            collection.add(iterator.next());
        }
    }

    /**
     * Count the number of objects in an iterator. Realize that this will exhaust the iterator.
     *
     * @param iterator the iterator to count
     * @param <T>      the type of the iterator
     * @return the number of objects in the iterator
     */
    public static <T> long counter(final Iterator<T> iterator) {
        long counter = 0;
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }
        return counter;
    }

    /**
     * Checks if the contents of the two iterators are equal and of the same length.
     * Equality is determined using == operator on the interal objects.
     *
     * @param ittyA An iterator
     * @param ittyB An iterator
     * @return Returns true if the two iterators contain the same objects and are of the same length
     */
    public static boolean areEqual(final Iterator ittyA, final Iterator ittyB) {
        if (ittyA.hasNext() != ittyB.hasNext())
            return false;

        while (ittyA.hasNext()) {
            if (!ittyB.hasNext())
                return false;
            if (ittyA.next() != ittyB.next())
                return false;
        }
        return true;
    }
}