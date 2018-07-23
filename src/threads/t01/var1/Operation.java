package threads.t01.var1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation extends Thread {
    private volatile List<Account> accounts;
    private volatile BufferedReader reader;

    public Operation(List<Account> accounts, BufferedReader reader) {
        this.accounts = accounts;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            doOperation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doOperation() throws IOException {
        String s;
        Pattern pattern = Pattern.compile("(acc\\d+) (acc\\d+) (\\d+)");

        while ((s = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                transferMoney(getAccountById(matcher.group(1)),
                        getAccountById(matcher.group(2)),
                        Integer.parseInt(matcher.group(3)));

            }
        }
    }

    private void transferMoney(Account from, Account to, int sum) {  //Защита от дэдлока(сравнение по id)
        if (from.getId().compareTo(to.getId()) < 0) {
            synchronized (from) {
                synchronized (to) {
                    doTransfer(from, to, sum);
                }
            }
        }
        else {
            synchronized (to) {
                synchronized (from) {
                    doTransfer(from, to, sum);
                }
            }
        }
    }

    private void doTransfer(Account from, Account to, int sum) {
        from.withdraw(sum);
        to.deposit(sum);
    }

    private Account getAccountById(String accountName) {
        for (Account a : accounts)
            if (a.getId().equals(accountName))
                return a;
        return null;
    }
}
