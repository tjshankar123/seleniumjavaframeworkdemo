package interviewQA;

public class InstanceLocalVariable {
    public String athleteName;                                      // Instance Variable
    public double athleteSpeed;
    public int athleteAge;

    public InstanceLocalVariable(String name, double speed, int age){ // Local Variable
        this.athleteAge = age;
        this.athleteName = name;
        this.athleteSpeed = speed;
    }
    public InstanceLocalVariable() {
        this.athleteAge = 0;
        this.athleteName = "";
        this.athleteSpeed = 0;
    }
    public void athleteRun(){
        int speed = 100;
        System.out.println("Athlete runs at " + speed + "Km/hr");
    }
    public static void main(String[] args){
        InstanceLocalVariable val = new InstanceLocalVariable();
        val.athleteRun();
    }
}
