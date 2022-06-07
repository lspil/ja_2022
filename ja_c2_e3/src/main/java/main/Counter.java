package main;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int i;

    public void increment() {
        try {
            lock.writeLock().lock();
            i++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int get() {    // R 1000 / W 1
        try {
            lock.readLock().lock();
            return i;
        } finally {
            lock.readLock().unlock();
        }
    }

}
