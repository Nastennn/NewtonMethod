package cli;

import java.util.Scanner;

public class ReaderCLI {
    Scanner in;

    public ReaderCLI(Scanner in) {
        this.in = in;
    }

    int readInt(){
        try{
            return Integer.parseInt(in.next().split(" ")[0].replace(",", "."));
        } catch (Exception e){
            System.out.println("Возникла ошибка при вводе числа. Введите число ещё раз, пожалуйста.");
            return readInt();
        }
    }

boolean isAnswerIsYes(){
    Scanner scanner = new Scanner(System.in);
    String answer = scanner.next();
    if (answer.equals("д")){
        return true;
    }else {
        return false;
    }
}

    double readDouble(){
        try{
            return Double.parseDouble(in.next().split(" ")[0].replace(",", "."));
        } catch (Exception e){
            System.out.println("Возникла ошибка при вводе числа. Введите число ещё раз, пожалуйста.");
            return readDouble();
        }
    }
}
