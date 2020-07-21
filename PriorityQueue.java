import java.util.*;

class Student {
    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa){
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class PriorityQueueProblem {

    static class PQSort implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2){
            if(s1.getCgpa() == s2.getCgpa()){
                if(s1.getFname().equals(s2.getFname())){
                    return (s1.getToken() < s2.getToken()) ? -1 : 1;
                } else{
                    return s1.getFname().compareTo(s2.getFname());
                }
            }
            else return (s1.getCgpa() > s2.getCgpa()) ? -1 : 1;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        PQSort pqs = new PQSort();
        PriorityQueue<Student> pq = new PriorityQueue<Student>(3, pqs);

        while(totalEvents > 0){

            String event = in.next();
            switch(event){
                case "ENTER":
                    String name = in.next();
                    double cgpa = in.nextDouble();
                    int token = in.nextInt();
                    pq.offer(new Student(token, name, cgpa));
                    break;
                case "SERVED":
                    pq.poll();
            }

            totalEvents--;
        }

        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        }
        else {
            while(!pq.isEmpty()){
                Student st = pq.poll();
                System.out.println(st.getFname());
            }
        }
        in.close();
    }
}
