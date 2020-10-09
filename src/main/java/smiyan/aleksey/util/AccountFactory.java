package smiyan.aleksey.util;

import com.github.javafaker.Faker;
import smiyan.aleksey.data.Account;

import java.util.Locale;

public class AccountFactory {

    public static Account getRandomAccount(String email) {
        return new Account()
                .setPhone(NameCreator.getName("093", 10))
                .setEmail(email)
                .setPassword(NameCreator.getName("pass", 8))
                .setFullName(new Faker(Locale.US).name().fullName());
    }
}
