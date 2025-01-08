package com.weecover.msparty.domain.model;

/**
 * Interface to be implemented by enums that serve as entity attribute types.
 * @param <T> type of value stored in the database
 *
 */
public interface EnumClass<T> {
    T getId();
}
