package sql.demo.repository;

import java.sql.SQLException;

public class TraiderShareOperations extends DefaultTable implements OperationsAgainstTable {
    public TraiderShareOperations () throws SQLException {
        super("traider_Share_Operations");
    }
    @Override
    public void createTable() throws SQLException{
        super.executeSqlStatement ("CREATE TABLE IF NOT EXIST traider_Share_Operations (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "operation integer NOT NULL," +
                "traider integer NOT NULL," +
                "share_rates integer NOT NULL,"+
                "amount BIGINT NOT NULL)", "Создана таблица " + tableName);

    }
    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(" ALTER TABLE traider_Share_Operations ADD FOREIGN KEY (share_rates) REFERENCES share_rates(id)",
                "Cоздан внешний ключ traider_Share_Operations.share -> shares.id");
    }

    @Override
    public void createExtraConstraints()throws SQLException{

    }
}
