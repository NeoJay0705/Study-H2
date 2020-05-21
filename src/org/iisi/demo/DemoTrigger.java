package org.iisi.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.api.Trigger;

/**
 * DemoTrigger
 */
public class DemoTrigger implements Trigger {

    @Override
    public void close() throws SQLException {
        // TODO Auto-generated method stub
        System.out.println("Connection is closed.");
    }
    @Override
    public void fire(Connection arg0, Object[] arg1, Object[] arg2) throws SQLException {
        // TODO Auto-generated method stub
        System.out.println("Trigger it.");
    }
    @Override
    public void init(Connection arg0, String arg1, String arg2, String arg3, boolean arg4, int arg5)
            throws SQLException {
        // TODO Auto-generated method stub
        System.out.println("Connect DB and Initialize the Trigger. " + arg1 + "/" + arg2 + "/" + arg3 + "/" + arg4 + "/" + arg5);
    }
    @Override
    public void remove() throws SQLException {
        // TODO Auto-generated method stub
        System.out.println("Trigger is dropped");
    }


}