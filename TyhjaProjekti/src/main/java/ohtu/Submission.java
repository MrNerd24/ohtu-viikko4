package ohtu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Submission {

    private String student_number;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        return "viikko " + getWeek() + ": tehtyjä tehtäviä yhteensä: " + getExercises() + " (maksimi " + getMaxExercises()+ "), aikaa kului " + getHours() + " tuntia, tehdyt tehtävät: " + getExercisesString();
    }

    public int getExercises() {
        return getExercisesString().split(" ").length;
    }

    public String getExercisesString() {
        Class<?> thisClass = Submission.class;
        String exercises = "";
        for (int i = 1; i <= 21; i++) {
            Method m = null;
            try {
                m = thisClass.getDeclaredMethod("isA" + i, new Class<?>[0]);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                if ((Boolean) m.invoke(this)) {
                    exercises += i + " ";
                }

            } catch (IllegalAccessException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exercises;
    }

    public int getMaxExercises() {
        Class<?> courseClass = Course.class;
        Method m = null;
        try {
            m = courseClass.getDeclaredMethod("getWeek" + getWeek(), new Class<?>[0]);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            return (int) m.invoke(Main.course);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean isA1() {
        return a1;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    public boolean isA2() {
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public boolean isA3() {
        return a3;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public boolean isA4() {
        return a4;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public boolean isA5() {
        return a5;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public boolean isA6() {
        return a6;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public boolean isA7() {
        return a7;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public boolean isA8() {
        return a8;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public boolean isA9() {
        return a9;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public boolean isA10() {
        return a10;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }

    public boolean isA11() {
        return a11;
    }

    public void setA11(boolean a11) {
        this.a11 = a11;
    }

    public boolean isA12() {
        return a12;
    }

    public void setA12(boolean a12) {
        this.a12 = a12;
    }

    public boolean isA13() {
        return a13;
    }

    public void setA13(boolean a13) {
        this.a13 = a13;
    }

    public boolean isA14() {
        return a14;
    }

    public void setA14(boolean a14) {
        this.a14 = a14;
    }

    public boolean isA15() {
        return a15;
    }

    public void setA15(boolean a15) {
        this.a15 = a15;
    }

    public boolean isA16() {
        return a16;
    }

    public void setA16(boolean a16) {
        this.a16 = a16;
    }

    public boolean isA17() {
        return a17;
    }

    public void setA17(boolean a17) {
        this.a17 = a17;
    }

    public boolean isA18() {
        return a18;
    }

    public void setA18(boolean a18) {
        this.a18 = a18;
    }

    public boolean isA19() {
        return a19;
    }

    public void setA19(boolean a19) {
        this.a19 = a19;
    }

    public boolean isA20() {
        return a20;
    }

    public void setA20(boolean a20) {
        this.a20 = a20;
    }

    public boolean isA21() {
        return a21;
    }

    public void setA21(boolean a21) {
        this.a21 = a21;
    }

}
