package sql.demo.repository;
import java.sql.SQLException;

public class Shares extends DefaultTable implements OperationsAgainstTable {
    public Shares () throws SQLException{
            super("shares");
    }

    @Override
    public void createTable() throws SQLException{
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS shares(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "changeProbability INTEGER NOT NULL DEFAULT 10,"+
                "delta INTEGER NOT NULL DEFAULT 15)", "Создана таблица " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException{
    }
    @Override
    public void createExtraConstraints() throws SQLException {
        super.executeSqlStatement(
                " ALTER TABLE shares ADD CONSTRAINT check_shares_delta CHECK(delta <= 100 and delta > 0)",
                "Cоздано ограничение для shares, поле delta = [1,100]");
        super.executeSqlStatement(
                " ALTER TABLE shares ADD CONSTRAINT check_shares_changeProbability " +
                        "CHECK(changeProbability <= 100 and changeProbability > 0)",
                "Cоздано ограничение для shares, поле changeProbability = 1..100");

    }
}
