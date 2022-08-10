package model;


public class ExpensesNote extends Note{
    private String categoryIndex;

    public ExpensesNote(double sum, String date, Const.MoneyDirection direction, String additionalInfo, String categoryIndex) {
        super(sum, date, direction, additionalInfo);
        this.categoryIndex = categoryIndex;
    }

    public String getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(String categoryIndex) {
        this.categoryIndex = categoryIndex;
    }
    @Override
    public String toString(){
        return ("Note ID [" + getId() +"], Date "+ getDate()+ ", category index: " + getCategoryIndex()+ ", direction: "+getDirection()+
                ", sum: "+ getSum() +", \nadditional info: "+getAdditionalInfo() );
    }
}
