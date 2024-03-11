package interviewQA;

public class PassByValueAndReference {
    int num;
    PassByValueAndReference(int x){
        num = x;
    }
    PassByValueAndReference(){
        num = 0;
    }
}

class Driver {
    public static void main(String[] args)
    {
        //create a reference
        PassByValueAndReference ibTestObj = new PassByValueAndReference(20);
        //Pass the reference to updateObject Method
        updateObject(ibTestObj);
        //After the updateObject is executed, check for the value of num in the object.
        System.out.println(ibTestObj.num);
    }
    public static void updateObject(PassByValueAndReference ibObj)
    {
        // Point the object to new reference
        ibObj = new PassByValueAndReference();
        // Update the value
        ibObj.num = 50;
    }

}

