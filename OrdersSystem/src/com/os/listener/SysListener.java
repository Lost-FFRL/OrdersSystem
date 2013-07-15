package com.os.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class SysListener implements ServletContextListener
{
    private final static Logger LOG = Logger.getLogger(SysListener.class);
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        LOG.info("System Listener stop");
    }
    
    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        LOG.info("System Listener start");
    }
    
}
