package com.itheima.util;

import jdk.nashorn.internal.runtime.ECMAException;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectUtils {
    private ThreadLocal<Connection> tl =  new ThreadLocal<Connection>();

    private DataSource datasouce;

    public void setDatasouce(DataSource datasouce) {
        this.datasouce = datasouce;
    }
    public Connection getThreadConnection(){
        try{
            Connection con = tl.get();
            if (con == null){
                con = datasouce.getConnection();
                tl.set(con);
            }
            return con;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void removeConnection(){
        tl.remove();
    }
}
