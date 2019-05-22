package sql.demo.model;
public class Share extends BaseModel {
    private String name;
    private int changeProbability ;// Вероятность смены курса (в процентах)
    private int delta;  // Максимальная разница (в процентах) на которое может измениться акции от своей стоимости

    public Share(){

    }

    public Share(long id, String name, int changeProbability, int delta) {
        super(id);
        this.name = name;
        this.changeProbability = changeProbability;
        this.delta = delta;
    }

    public String getName(){
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }

    public int getchangeProbability(){
        return changeProbability;

    }
    public void setchangeProbability(int changeProbability) {
        this.changeProbability = changeProbability;
    }
    public int getdelta(){
        return delta;

    }
    public void setdelta(int delta) {
        this.delta = delta;
    }


}


