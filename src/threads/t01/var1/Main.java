package threads.t01.var1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Account acc1 = new Account("acc1", 1000);
        Account acc2 = new Account("acc2", 1000);

        List<Account> accounts = new ArrayList<>();
        accounts.add(acc1);
        accounts.add(acc2);

        Path path = Paths.get("resources\\threads\\t01\\operations");
        BufferedReader reader = Files.newBufferedReader(path);

        Operation op1 = new Operation(accounts, reader);
        Operation op2 = new Operation(accounts, reader);
        Operation op3 = new Operation(accounts, reader);

        op1.start();
        op2.start();
        op3.start();

        op1.join();
        op2.join();
        op3.join();

        for (Account a : accounts)
            System.out.println(a.getBalance());
    }
}
