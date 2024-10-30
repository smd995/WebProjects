package spring.di.ui;

import spring.di.Exam;

public class GridExamConsole implements ExamConsole {

    private Exam exam;

    public GridExamConsole(Exam exam) {
        this.exam = exam;
    }


    @Override
    public void print() {
        System.out.printf("격자 출력 : total is %d, avg is %f\n", exam.total(), exam.avg());

    }
}
