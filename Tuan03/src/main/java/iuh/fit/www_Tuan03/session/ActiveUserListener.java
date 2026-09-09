package iuh.fit.www_Tuan03.session;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveUserListener implements ServletContextListener, HttpSessionListener {

    private static final String ACTIVE_USERS_ATTRIBUTE = "activeUsersCount";

    private static final AtomicInteger activeSessions = new AtomicInteger(0);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application started!");

        sce.getServletContext().setAttribute(
                ACTIVE_USERS_ATTRIBUTE,
                activeSessions
        );
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application destroyed!");

        sce.getServletContext().removeAttribute(
                ACTIVE_USERS_ATTRIBUTE
        );
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        AtomicInteger activeUsers =
                (AtomicInteger) se.getSession()
                        .getServletContext()
                        .getAttribute(ACTIVE_USERS_ATTRIBUTE);

        if (activeUsers != null) {
            int count = activeUsers.incrementAndGet();

            System.out.println("Session created. Active users: " + count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        AtomicInteger activeUsers =
                (AtomicInteger) se.getSession()
                        .getServletContext()
                        .getAttribute(ACTIVE_USERS_ATTRIBUTE);

        if (activeUsers != null && activeUsers.get() > 0) {
            int count = activeUsers.decrementAndGet();

            System.out.println("Session destroyed. Active users: " + count);
        }
    }
}

