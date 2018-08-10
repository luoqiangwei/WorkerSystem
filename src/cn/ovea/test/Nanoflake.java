package cn.ovea.test;

import org.junit.jupiter.api.Test;

public class Nanoflake {
    private long initialTime = 1878547820027449L;
    private long workerID;
    private long workerIDBit = 11L;
    private long timeBit = 52L;

    private long getNanoTime(){
        return System.nanoTime();
    }

    private long getNanoflake(long workerID){
        this.workerID = workerID;
        long temp = 0;
        temp |= getNanoTime() - initialTime;
        workerID = workerID << timeBit;
        temp |= workerID;
        return temp;
    }

    @Test
    public void fun1(){
        for (int i = 0; i < 100; i++)
            //System.out.println(Long.toHexString(getNanoflake(1)));
            System.out.println(getNanoflake(1));
    }
}
