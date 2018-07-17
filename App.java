package com.revature.bankApp;

import java.io.IOException;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException, IOException
    {
    	// Connect to bankApp database
    	ConnectDB.setup();
    	// Display menu
        Menu m = new Menu();
        // Exception in thread "main" java.lang.NullPointerException
        m.displayMenu();
    }
}
