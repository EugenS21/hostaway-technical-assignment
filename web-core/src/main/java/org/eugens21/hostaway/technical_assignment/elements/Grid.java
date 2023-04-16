package org.eugens21.hostaway.technical_assignment.elements;

import java.util.List;

public interface Grid<T> {

    List<T> items();

    void open(T item);

}
