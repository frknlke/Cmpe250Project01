
import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int duration;
    private double minRating;
    private boolean isSettled;
    private House residence;

    public House getResidence() {
        return residence;
    }

    public void setResidence(House residence) {
        this.residence = residence;
    }

    public Student(int id, String name, int duration, double minRating) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.minRating = minRating;
        isSettled = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getMinRating() {
        return minRating;
    }

    public void setMinRating(double minRating) {
        this.minRating = minRating;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public void setSettled (boolean settled ) {
        isSettled = settled ;
    }

    public static void durationCorrector(ArrayList<Student> list){
        for(Student temp : list){
            temp.duration--;
            if(temp.duration <= 0){
                temp.duration=0;

            }
        }
    }


    @Override
    public int compareTo(Student o) {
        if(this.id > o.getId()){
            return 1;
        }else if(this.id < o.getId()){
            return -1;
        }else{
            return 0;
        }
    }
}

