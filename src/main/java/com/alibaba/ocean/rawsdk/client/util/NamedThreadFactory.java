// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   NamedThreadFactory.java

package com.alibaba.ocean.rawsdk.client.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
    implements ThreadFactory
{

    static final AtomicInteger poolNumber = new AtomicInteger(1);
    final AtomicInteger threadNumber;
    final ThreadGroup group;
    final String namePrefix;
    final boolean isDaemon;

    public NamedThreadFactory()
    {
        this("timor.pool");
    }

    public NamedThreadFactory(String name)
    {
        this(name, false);
    }

    public NamedThreadFactory(String preffix, boolean daemon)
    {
        threadNumber = new AtomicInteger(1);
        SecurityManager s = System.getSecurityManager();
        group = s == null ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
        namePrefix = (new StringBuilder()).append(preffix).append("-").append(poolNumber.getAndIncrement()).append("-thread-").toString();
        isDaemon = daemon;
    }

    public Thread newThread(Runnable r)
    {
        Thread t = new Thread(group, r, (new StringBuilder()).append(namePrefix).append(threadNumber.getAndIncrement()).toString(), 0L);
        t.setDaemon(isDaemon);
        if(t.getPriority() != 5)
            t.setPriority(5);
        return t;
    }

}
