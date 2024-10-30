package org.zerock.spring1.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zerock.spring1.aop.advice.LogAroundAdvice;
import org.zerock.spring1.aop.entity.Exam;
import org.zerock.spring1.aop.entity.NewlecExam;
import org.zerock.spring1.di.NewlecDIConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);

        Exam exam = (Exam) context.getBean("exam");

        System.out.printf("total is %d \n", exam.total());
        System.out.printf("total is %f \n", exam.avg());

    }
}
