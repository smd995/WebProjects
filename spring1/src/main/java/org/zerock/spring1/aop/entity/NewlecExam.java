package org.zerock.spring1.aop.entity;

public class NewlecExam implements Exam {

    private int kor;
    private int eng;
    private int math;
    private int com;

    public NewlecExam() {}

    public NewlecExam(int kor, int eng, int math, int com) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.com = com;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setCom(int com) {
        this.com = com;
    }

    @Override
    public int total() {
//        long start = System.currentTimeMillis();

        int result = kor + eng + math + com;

        if (kor > 100) {
            throw new IllegalArgumentException("유효하지 않은 국어점수");
        }

//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        long end = System.currentTimeMillis();
//
//        String message = (end - start) + "ms";
//
//        System.out.println(message);

        return result;
    }

    @Override
    public float avg() {

        float result = total()/4.0f;

        return result;
    }

}
