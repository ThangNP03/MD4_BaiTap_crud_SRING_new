package ra.model.service;

import java.sql.SQLException;
import java.util.List;

public interface IService <T, E>{
    List<T> findAll() throws SQLException;
    Boolean save(T t) throws SQLException;
    boolean update (T t);
    T findById(E e);
    boolean delete(E e);
}
