package org.zerock.todolist.todo.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Log4j2
@WebListener
public class TodoList1AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("---------init----------------------------");
        log.info("---------init----------------------------");
        log.info("---------init----------------------------");

        ServletContext context = sce.getServletContext();

        context.setAttribute("appName", "TodoList1");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("---------destroy---------------------------");
        log.info("---------destroy---------------------------");
        log.info("---------destroy---------------------------");
    }
}
