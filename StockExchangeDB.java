package sql.demo;
import org.h2.tools.DeleteDbFiles;
import java.sql.*;
import sql.demo.repository.*;

public class StockExchangeDB {

    public static final String DB_DIR = "d:/Projects/Trying SQLDemo/db";
    public static final String DB_FILE = "stockExchange";
    public static final String DB_URL = "jdbc:h2:/" + DB_DIR + "/" + DB_FILE;
    public static final String DB_Driver = "org.h2.Driver";

    Traiders traiders;
    ShareRates shareRates;
    Shares shares;
    TraiderShareOperations traiderShareOperations;

    // Connection with DB
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    //Инициализация
    public StockExchangeDB(boolean renew) throws SQLException, ClassNotFoundException {
        if (renew)
            DeleteDbFiles.execute(DB_DIR, DB_FILE, false);
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        traiders = new Traiders();
        shares = new Shares();
        shareRates = new ShareRates();
        traiderShareOperations = new TraiderShareOperations();

    }
    // Инициализация по умолчанию, без удаления файла БД
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        this(false);
    }


        public void createTablesAndForeignKeys() throws SQLException {
            shares.createTable();
            shareRates.createTable();
            traiders.createTable();
            traiderShareOperations.createTable();
            // Создание ограничений на поля таблиц
            traiders.createExtraConstraints();
            shares.createExtraConstraints();
            // Создание внешних ключей (связи между таблицами)
            shareRates.createForeignKeys();
            traiderShareOperations.createForeignKeys();
        }


        public static void main(String[] args) {
            try{
                StockExchangeDB stockExchangeDB = new StockExchangeDB(true);
                stockExchangeDB.createTablesAndForeignKeys();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ошибка SQL !");
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC драйвер для СУБД не найден!");
            }
        }
    }


