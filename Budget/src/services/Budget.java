package services;

import model.Const;
import model.ExpensesNote;
import model.IncomeNote;
import model.Note;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Budget {
    private final ArrayList<IncomeNote> incomeNotes = new ArrayList<>();
    private final ArrayList<ExpensesNote> expensesNotes = new ArrayList<>();

    public void Launcher() {
        Scanner scanner = new Scanner(System.in);

        int temp = 0;
        do{
            printMenuOptions();
            try {
                temp = scanner.nextInt();
                scanner.nextLine();
                switch (temp) {
                    case 1 -> {
                        //To be coded add income note
                        todo();
                    }
                    case 2 -> {
                        //To be coded add expense note
                        todo();
                    }
                    case 3 -> {
                        System.out.println("Enter ID of note to be deleted");
                        removeNote(scanner.nextInt());
                    }
                    case 4 -> {
                        System.out.println("Enter note ID to be edited");
                        configureNote(scanner.nextInt());
                    }
                    case 5 -> {
                        printAll();
                    }
                    case 6 -> {
                        System.out.println(balance());
                    }
                    case 7 -> {
                        //add save to file
                        todo();
                    }
                    case 8 -> {
                        //add load from file
                        todo();
                    }
                };
            } catch (Exception e) {
                System.out.println("Entered wrong command, try again");
                temp = 0;
            }
        }while (temp!=9);
    }
    private void todo(){
        System.out.println("Work in progress");
    }

    private void printMenuOptions() {
        System.out.println("""
                [1] Enter new Income note
                [2] Enter new Expenses note
                [3] Remove note from the list
                [4] Edit note from the list
                [5] Print all notes
                [6] Print balance
                [7] Save to file
                [8] Load from file
                [9] Exit
                """);
    }

    public void printAll() {
        System.out.println("\nIncome notes: ");
        for (IncomeNote note : incomeNotes
        ) {
            System.out.println(note.toString());
        }
        System.out.println("\nExpenses notes: ");
        for (ExpensesNote note : expensesNotes
        ) {
            System.out.println(note.toString());
        }
    }

    public void addNote(Note note) {
        if (note instanceof ExpensesNote) {
            expensesNotes.add((ExpensesNote) note);
        } else if (note instanceof IncomeNote) {
            incomeNotes.add((IncomeNote) note);
        } else {
            System.out.println("Note is not declared to be income or expenses");
        }
    }

    public void configureNote(int id) {
        Scanner scanner = new Scanner(System.in);
        int temp;

        IncomeNote incNote = incomeNotes.stream()
                .filter(fun -> fun.equals(id))
                .findFirst()
                .orElse(null);
        ExpensesNote expNote = expensesNotes.stream()
                .filter(fun -> fun.equals(id))
                .findFirst()
                .orElse(null);
        try {
            if (incNote != null && config(incNote)) {
                System.out.println("Category index info: \n[1]Edit, [2] Next");
                temp = scanner.nextInt();
                scanner.nextLine();
                if (temp == 1) {
                    System.out.println("Enter new category index info ");
                    incNote.setCategoryIndex(scanner.nextLine());
                }
            } else if (expNote != null && config(expNote)) {
                System.out.println("Category index info: \n[1]Edit, [2] Next");

                temp = scanner.nextInt();
                scanner.nextLine();

                if (temp == 1) {
                    System.out.println("Enter new category index info ");
                    expNote.setCategoryIndex(scanner.nextLine());
                }
            } else {
                System.out.println("Id not found");
            }
        } catch (Exception e) {
            System.out.println("Entered wrong symbol, rest of configuration will be skipped");
        }
    }

    private boolean config(Note note) {
        Scanner scanner = new Scanner(System.in);
        int temp;
        System.out.println("Sum: " + note.getSum() + "\n[1]Edit, [2] Next");
        temp = scanner.nextInt();
        scanner.nextLine();
        if (temp == 1) {
            System.out.println("Enter new sum");
            note.setSum(scanner.nextDouble());
        }
        System.out.println("Date: " + note.getDate() + "\n[1]Edit, [2] Next");
        temp = scanner.nextInt();
        scanner.nextLine();
        if (temp == 1) {
            System.out.println("Enter new Date");
            note.setDate(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        System.out.println("Money direction: \n[1]Edit, [2] Next");
        temp = scanner.nextInt();
        scanner.nextLine();
        if (temp == 1) {
            System.out.println("Choose the way \n[1]Bank, [2]other");
            temp = scanner.nextInt();
            scanner.nextLine();
            if (temp == 1) {
                note.setDirection(Const.MoneyDirection.BANKACCOUNT);
            } else {
                note.setDirection(Const.MoneyDirection.OTHER);
            }
        }
        System.out.println("Additional info: \n[1]Edit, [2] Next");
        temp = scanner.nextInt();
        scanner.nextLine();
        if (temp == 1) {
            System.out.println("Enter new additional info");
            note.setAdditionalInfo(scanner.nextLine());
        }
        return true;
    }


    public void removeNote(int id) {
        incomeNotes.removeIf(value -> value.equals(id));
        expensesNotes.removeIf(value -> value.equals(id));
    }

    public double balance() {
        return incomeNotes.stream().mapToDouble(IncomeNote::getSum).sum()
                - expensesNotes.stream().mapToDouble(ExpensesNote::getSum).sum();
    }

    public ArrayList<IncomeNote> getIncomeNotes() {
        return incomeNotes;
    }

    public ArrayList<ExpensesNote> getExpensesNotes() {
        return expensesNotes;
    }

}
