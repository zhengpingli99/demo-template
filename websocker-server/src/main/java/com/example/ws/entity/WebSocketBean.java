package com.example.ws.entity;

import javax.websocket.Session;
import java.util.concurrent.atomic.AtomicInteger;

public class WebSocketBean {
    /**
     * 连接session d对象
     */
    private Session session;

    /**
     * 连接错误次数
     */
    private AtomicInteger erroerLinkCount=new AtomicInteger(0);

    public int getErroerLinkCount(){
        // 线程安全,以原子方式将当前值加1,注意:这里返回的是自增前的值
        return erroerLinkCount.getAndIncrement();
    }

    public void cleanErrorNum(){
        erroerLinkCount=new AtomicInteger(0);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
