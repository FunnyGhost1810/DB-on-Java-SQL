package sql.demo.model;
import java.math.BigDecimal;

public class Traider extends BaseModel {
    // продаем все акции и закупаем макс самых дешевых
    public static final int METHOD_SELL_ALL_BUY_CHEAP = 1;
    // продаем самые дорогие и покупаем самые дешевые
    public static final int METHOD_SELL_ALL_BUY_CHEAPO_SELL_EXPENSIVE_BUY_CHEAP = 2;
    // продаем и покупаем все случайно выбранного наименования
    public static final int METHOD_SELL_ALL_BUY_CHEAP_SELL_RANDOM_BUY_RANDOM = 3;
    private String name;
    private int freqPerDay;     // частота покупки в день
    private BigDecimal cash;    // количество денег
    private int trademethod;    // один из трех методов трейда

    public Traider(){

    }
    public Traider(long id, String name, int freqPerDay, BigDecimal cash, int trademethod){
        super(id);
        this.name = name;
        this.freqPerDay = freqPerDay;
        this.cash = cash;
        this.trademethod = trademethod;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getFreqPerDay(){
        return freqPerDay;
    }
    public void setFreqPerDay(int freqPerDay){
        this.freqPerDay = freqPerDay;
    }

    public BigDecimal getCash(){
        return cash;
    }
    public void setCash(BigDecimal cash){
        this.cash = cash;
    }

    public int getTrademethod(){
        return trademethod;
    }
    public void setTrademethod(int trademethod){
        this.trademethod = trademethod;
    }
}