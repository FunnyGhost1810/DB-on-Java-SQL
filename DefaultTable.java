package sql.demo.repository;
import sql.demo.StockExchangeDB;
import java.io.Closeable;
import java.sql.*;


public class DefaultTable implements Closeable {
    Connection connection;
    String tableName;
    DefaultTable(String tableName) throws SQLException{
    this.tableName = tableName;
    this.connection = StockExchangeDB.getConnection();
    }

    public void close() {
    try {if(connection !=null && !connection.isClosed())
        connection.close();
    }
    catch (SQLException e){
        System.out.print("Ошибка отключения от SQL сервера");
    }
    }
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection(); // переоткрываем (если оно неактивно) соединение с СУБД
        Statement statement = connection.createStatement();  // Создаем statement для выполнения sql-команд
        statement.execute(sql); // Выполняем statement - sql команду
        statement.close();      // Закрываем statement для фиксации изменений в СУБД
        if (description != null)
            System.out.println(description);
    };
    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql,null);
    };
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = StockExchangeDB.getConnection();
        }
    }
}
