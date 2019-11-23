package com.itheima.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author feng
 * @date:2019/10/23
 * @description
 **/
@Configuration
public class OrderLisener implements ApplicationListener<EmbeddedServletContainerInitializedEvent>{

    private static EmbeddedServletContainerInitializedEvent event;
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        OrderLisener.event = event;
    }

    public static int getPort(){
        return event.getEmbeddedServletContainer().getPort();
    }
}
