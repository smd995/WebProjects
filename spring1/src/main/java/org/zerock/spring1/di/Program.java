package org.zerock.spring1.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zerock.spring1.di.ui.ExamConsole;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

//        Exam exam = new NewlecExam();
//        Exam exam = new NewlecExam(10,10,10,10);
//        ExamConsole console = new InlineExamConsole(exam); // DI
//        ExamConsole console = new GridExamConsole(exam);
//        console.setExam(exam);

//        ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);

//        Exam exam = context.getBean(Exam.class);
//        System.out.println(exam.toString());

        ExamConsole console = (ExamConsole) context.getBean("console");
//        ExamConsole console = context.getBean(ExamConsole.class);
        console.print();

//        List<Exam> exams = new ArrayList<>();
//        List<Exam> exams = (List<Exam>) context.getBean("exams");
//        exams.add(new NewlecExam(1,1,1,1));
//
//        for(Exam e : exams)
//            System.out.println(e);

    }
}
