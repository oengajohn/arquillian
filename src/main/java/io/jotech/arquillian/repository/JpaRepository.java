package io.jotech.arquillian.repository;

public interface JpaRepository<T, ID> {
    T save(T t);

    T find(ID id);

    T update(T t);

    boolean delete(T t);

    boolean deleteById(ID id);
}
