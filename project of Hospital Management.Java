import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

class Patient extends Person {
    int patientId;
    String illness;

    public Patient(int patientId, String name, int age, String gender, String illness) {
        super(name, age, gender);
        this.patientId = patientId;
        this.illness = illness;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Illness: " + illness);
    }
}

class Doctor extends Person {
    int doctorId;
    String specialization;

    public Doctor(int doctorId, String name, int age, String gender, String specialization) {
        super(name, age, gender);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    public void display() {
        System.out.println("Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization);
    }
}

class Appointment {
    int appointmentId;
    int patientId;
    int doctorId;

    public Appointment(int appointmentId, int patientId, int doctorId) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public void display() {
        System.out.println("Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor ID: " + doctorId);
    }
}

public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int patientIdCounter = 1, doctorIdCounter = 1, appointmentIdCounter = 1;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> bookAppointment();
                case 4 -> viewPatients();
                case 5 -> viewDoctors();
                case 6 -> viewAppointments();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    public static void addPatient() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter illness: ");
        String illness = sc.nextLine();

        Patient p = new Patient(patientIdCounter++, name, age, gender, illness);
        patients.add(p);
        System.out.println("Patient added successfully.");
    }

    public static void addDoctor() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter specialization: ");
        String spec = sc.nextLine();

        Doctor d = new Doctor(doctorIdCounter++, name, age, gender, spec);
        doctors.add(d);
        System.out.println("Doctor added successfully.");
    }

    public static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();

        Appointment a = new Appointment(appointmentIdCounter++, pid, did);
        appointments.add(a);
        System.out.println("Appointment booked successfully.");
    }

    public static void viewPatients() {
        System.out.println("\n--- List of Patients ---");
        for (Patient p : patients) {
            p.display();
        }
    }

    public static void viewDoctors() {
        System.out.println("\n--- List of Doctors ---");
        for (Doctor d : doctors) {
            d.display();
        }
    }

    public static void viewAppointments() {
        System.out.println("\n--- List of Appointments ---");
        for (Appointment a : appointments) a.display();
    }
}