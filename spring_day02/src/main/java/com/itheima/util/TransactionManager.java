package com.itheima.util;

public class TransactionManager {
    private ConnectUtils connectUtils;

    public void setConnectUtils(ConnectUtils connectUtils) {
        this.connectUtils = connectUtils;
    }
    //开启事务
    public void beginTransaction(){
        try {
            connectUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //提交
    public void commit(){
        try {
            connectUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //回滚
    public void rollback(){
        try {
            connectUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //释放
    public void release(){
        try {
            connectUtils.getThreadConnection().close();
            connectUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
