package org.bsin.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordChecker {
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
