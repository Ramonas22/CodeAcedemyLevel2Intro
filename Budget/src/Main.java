import model.Const;
import model.ExpensesNote;
import model.IncomeNote;
import services.Budget;

public class Main {
    public static void main(String[] args) {
        Budget budget = new Budget();
        IncomeNote incomeNote = new IncomeNote(100,"2022", Const.MoneyDirection.BANKACCOUNT,"none", "Job");
        ExpensesNote expensesNote = new ExpensesNote(120,"2022", Const.MoneyDirection.BANKACCOUNT, "None", "Maxima");

        budget.addNote(incomeNote);
        budget.addNote(expensesNote);

        budget.Launcher();
    }
}