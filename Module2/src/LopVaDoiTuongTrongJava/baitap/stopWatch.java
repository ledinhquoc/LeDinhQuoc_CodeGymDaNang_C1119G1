package LopVaDoiTuongTrongJava.baitap;

public class stopWatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public void start(){
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop(){
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }
    public long getElapsedTime(){
        long elapsed;
        if (running){
                elapsed = (System.currentTimeMillis() - startTime);
        }else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }
    public  long getElapsedTimeSet(){
        long elapsed;
        if (running){
            elapsed = ((System.currentTimeMillis()- startTime)/1000);
        }else {
            elapsed = ((stopTime - startTime)/1000);
        }
        return  elapsed;
    }
}
