package sql.demo.repository;
import java.sql.SQLException;
public interface OperationsAgainstTable {
    void createTable() throws SQLException; //талица
    void createForeignKeys() throws SQLException; //ключи  связи таблицы
    void createExtraConstraints() throws SQLException; // ограничения
}
