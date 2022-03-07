

import java.util.ArrayList;

public class House implements Comparable<House> {
    private int id;
    private int duration;
    private double rating;
    private boolean isAllocated;
    private Student tenant;

    public Student getTenant() {
        return tenant;
    }

    public void setTenant(Student tenant) {
        this.tenant = tenant;
    }

    public House(int id, int duration, double rating) {
        this.id = id;
        this.duration = duration;
        this.rating = rating;
        if(duration > 0){
            this.isAllocated=true;
        }else{
            this.isAllocated = false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        this.isAllocated=true;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAllocated() {
        if(this.duration <= 0){
            this.isAllocated=false;
            this.setTenant(null);
            this.duration=0;
        }
        return isAllocated;
    }

    public void setAllocated(boolean allocated) {
        isAllocated = allocated;
    }

    public static void durationCorrector(ArrayList<House> list){
        for(House temp : list){
            temp.duration--;
            if(temp.duration <= 0){
                temp.duration=0;
                temp.isAllocated=false;
                temp.tenant=null;
            }
        }
    }


    @Override
    public int compareTo(House o) {
        if(this.id > o.getId()){
            return 1;
        }else if(this.id < o.getId()){
            return -1;
        }else{
            return 0;
        }
    }
}
