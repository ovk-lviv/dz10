package org.example;

import java.util.List;

public class Main {
    private static BankApplication ba = new BankApplication();


    static public void main(String[] args) {
        /*
            Викликати метод processWrapper з наступними параметрами:
            id = accountId000, amount 50, currency USD
            id = accountId003, amount 250, currency HRV
            id = accountId001, amount 50, currency EUR
            id = accountId001, amount 50, currency USD
            id = accountId001, amount 200, currency USD
         */
        try {
            processWrapper("accountId001", 100, "USD");
        } catch (WrongAccountException a) {
            System.out.println(a.getMessage());
        } catch (WrongCurrencyException c) {
            System.out.println(c.getMessage());
        } catch (WrongOperationException o) {
            System.out.println(o.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        } finally {
            System.out.println("Thank you for using our service!");
        }
    }

    public static void processWrapper(String s, int i, String s1) throws Exception {
        ba.process(s, i, s1);
        if (s == null) {
            throw new WrongAccountException();
        }
        if (!s1.equals("USD") && !s1.equals("HRV") && !s1.equals("EUR")) {
            throw new WrongCurrencyException();
        }
        if (i < 0) {
            throw new WrongOperationException();
        }

    }}