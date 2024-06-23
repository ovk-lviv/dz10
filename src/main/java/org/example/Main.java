package org.example;

import java.util.List;

public class Main {
    public static BankApplication ba = new BankApplication();

    static public void main(String[] args) {
        /*
            Викликати метод processWrapper з наступними параметрами:
            id = accountId000, amount 50, currency USD
            id = accountId003, amount 250, currency HRV
            id = accountId001, amount 50, currency EUR
            id = accountId001, amount 50, currency USD
            id = accountId001, amount 200, currency USD
         */
        // Some changes
        try {

            processWrapper("001", 200, "USD");
        } catch (WrongAccountException wae) {
            System.out.println("Wrong account!");
        } catch (WrongOperationException woe) {
            System.out.println("Insufficient funds!");;
        } catch (WrongCurrencyException wce) {
            System.out.println("Wrong currency");
        }
        catch (Exception e){
            System.out.println("An error occurred. Please try again");
        }finally {
            System.out.println("Thank you for using our service!");
        }

    }

    public static void processWrapper(String s, int i, String s1) throws Exception {
//який буде викликати метод process об’єкту BankApplication.
        ba.process(s, i, s1);
        if (s == null) {
            throw new WrongAccountException();
        }
        if (i < 0) {
            throw new WrongOperationException();
        }

        if (!s1.equals("EUR") && !s1.equals("USD") && !s1.equals("HRV")) {
            throw new WrongCurrencyException();
        }


    }
}