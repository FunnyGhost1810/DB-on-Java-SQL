package sql.demo.repository;
import java.sql.SQLException;

public class Traiders extends DefaultTable implements OperationsAgainstTable {
    public Traiders () throws SQLException{
        super("traiders");
    }

    @Override
    public void createTable() throws SQLException{
        super.executeSqlStatement ("CREATE TABLE IF NOT EXIST traiders (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "freqPerDay integer NOT NULL," +
                "cash  decimal(13,3) NOT NULL  DEFAULT 1000,"+
                "tradingMethod integer NOT NULL),"+
                "changeProbability INTEGER NOT NULL DEFAULT 50","Создана таблица " + tableName);

    }
    @Override
    public void createForeignKeys() throws SQLException {

    }

    @Override
    public void createExtraConstraints() throws SQLException{
        super.executeSqlStatement(
                " ALTER TABLE traiders ADD CONSTRAINT check_traiders_tradingMethod CHECK(tradingMethod in (1,2,3))",
                "Cоздано ограничение для traiders, поле tradingMethod = 1,2,3");
        super.executeSqlStatement(
                " ALTER TABLE traiders ADD CONSTRAINT check_traiders_changeProbability " +
                        "CHECK(changeProbability <= 100 and changeProbability > 0)",
                "Cоздано ограничение для traiders, поле changeProbability = 1..100");
    }
}
