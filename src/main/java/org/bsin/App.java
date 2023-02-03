package org.bsin;

import org.bsin.userinterface.LoginScreen;
import org.bsin.utils.DatabaseConnector;

public class App
{
    public static void main( String[] args )
    {
        DatabaseConnector.connect();
        new LoginScreen();
    }
}
