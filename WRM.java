    // NO NEED THIS SUBMIT THIS CLASS
public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {

    
    Patient newPatient = new Patient(id, name, age, bloodgroup, null, null);

    
    Patient last = dh.prev;

    
    last.next = newPatient;
    newPatient.prev = last;

    
    newPatient.next = dh;
    dh.prev = newPatient;

    System.out.println("A new patient is registered successfully");
}

    public void servePatient() {
        // To do

        if(dh.next == dh){
            System.out.println("No patient to serve");
            return;
        }
        Patient first = dh.next;
        dh.next = first.next;
        first.next.prev = dh;
        System.out.println("Serving Patient "+first.name);
    }

    public void showAllPatient() {
        // To Do

        if(dh.next == dh){
            System.out.println("No one");
            return;
        }
        Patient temp = dh.next;
        System.out.println("The patient List: ");
        while(temp != dh){
            System.out.print("iD: "+temp.id+ "Name: "+temp.name+ "Age: "+temp.age+ "Blood: "+temp.bloodGroup);
            temp = temp.next;
        }
    }

    public Boolean canDoctorGoHome() {
    if (dh.next == dh) {
        System.out.println("No patient, so the doctor can go home");
        return true;
    } else {
        System.out.println("Patients are waiting");
        return false;
    }
}

    public void cancelAll() {
        // To Do

        dh.next = dh;
        dh.prev = dh;
        System.out.println("all Cancelled");
    }


    public void reverseLine() {

    if (dh.next == dh) {
        System.out.println("No patients to reverse.");
        return;
    }

    Patient current = dh.next;
    
    while (current != dh) {

        Patient temp = current.next;
        current.next = current.prev;
        current.prev = temp;

        current = temp;

        if (current == dh) {
            break;
        }
    }

    System.out.println("Line reversed successfully.");
}
    }


