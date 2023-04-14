package org.eugens21.hostaway.technical_assignment.elements;

public interface Input<T> {

    void input(T value);

    void invalidInput(String value);

    T value();

}
