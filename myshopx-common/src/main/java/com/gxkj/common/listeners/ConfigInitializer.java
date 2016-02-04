package com.gxkj.common.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gxkj.common.utils.SystemGlobals;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigInitializer implements ServletContextListener {

    protected final  Logger logger = LoggerFactory.getLogger(getClass());

    public void contextDestroyed(ServletContextEvent event) {


    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String configFile = context.getInitParameter("SystemGlobalsProperties");
        if (StringUtils.isNotBlank(configFile)) {
            configFile = configFile.trim();
            logger.info(configFile);
            SystemGlobals.loadConfig(configFile);
        }
    }

}
