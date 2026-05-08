package studentsystem;

public class SingleLinkedList {
    Node head, tail;
    int counter;

    public SingleLinkedList() {
        head = tail = null;
        counter = 0;
    }
    
    boolean isEmpty(){
        return head == null;
    }
    
    void clear(){
        head = tail = null;
        counter = 0;
    }
    
    Node firstP(){
        return head;
    }
    
    Node lastP(){
        return tail;
    }
    
    int size(){
        return counter;
    }
    
    Node prev(Node p){
        if(isEmpty() || p == null || p == head){
           return null;
        }
        Node q = head;
        while(q.next != p){
            q = q.next;
        }
        return q;
    }
    
    Node indexOf(int id){
        Node q = head;
        while(q != null){
            if(q.info.studentID == id){
                return q;
            }
            q = q.next;
        }
        return null;
    }
    
    void insertAtFirst(Student s){
        head = new Node (s, head);
        if(tail == null){
            tail = head;
        }
        counter++;
    }
    
    void insertAtEnd(Student s){
        if(tail == null){;
           tail = new Node(s, null);
           head = tail;
        }
        else{
            tail.next = new Node(s, null);
            tail = tail.next;
        }
        counter++;
    }
    
    void insertStudent (Student s){
        if(s.studentGPA < 0 || s.studentGPA > 4){
           System.out.println("INVALID GPA");
           return;
        }
        if(s.studentID <= 0){
           System.out.println("INVALID ID");
           return;
        }
        if(indexOf(s.studentID) != null){
            System.out.println("DUPLICATE ID NOT ALLOWED");
            return;
        }
        if(isEmpty()){
            insertAtFirst(s);
        }
        else if(s.studentGPA >= head.info.studentGPA){
            insertAtFirst(s);
        }
        else if(s.studentGPA <= tail.info.studentGPA){
            insertAtEnd(s);
        }
        else{
            Node q = head;
           
            while(q.next != null && q.next.info.studentGPA > s.studentGPA){
                q = q.next;
            }
            q.next = new Node(s, q.next);
            counter++;
        }
    }
    
    void searchStudent(int id){
        if(id <= 0){
           System.out.println("INVALID ID");
           return;
        }
        Node p = indexOf(id);
        if(p == null){
            System.out.println("STUDENT NOT FOUND");
            return;
        }
        System.out.println(p.info);
    }
    
    void removeFromFirst(){
        if(isEmpty()){
            System.out.println("ERROR");
            return;
        }
        else if(head == tail) {
            clear();
        }
        else{
            head = head.next;
            counter--;
        }
    }
    
    void removeFromEnd(){
        if(isEmpty()) {
            System.out.println("ERROR");
        } 
        else if(head == tail) {
            clear();
        } 
        else {
            Node q = prev(tail);
            q.next = null;
            tail = q;
            counter--;
        }
    }
    
    void removeStudent(int id){
        if(id <= 0){
            System.out.println("INVALID ID");
            return;
        }
        if(isEmpty()){
            System.out.println("LIST IS EMPTY");
            return;
        }
        Node p = head;
        Node prev = null;
        
        while(p != null && p.info.studentID != id){
            prev = p;
            p = p.next;
        }
        
        if(p == null){
           System.out.println("STUDENT NOT FOUND");
           return;
        }

        if(p == head){
           removeFromFirst();
        }
        else if(p == tail){
           removeFromEnd();
        }
        else{
            prev.next = p.next;
            counter--;
        }
        
        System.out.println("STUDENT REMOVED");
    }
    
    void TOP10(){
        if(isEmpty()){
           System.out.println("LIST IS EMPTY");
           return;
        }
        
        Node q = head;
        int count = 0;
        
        System.out.println("TOP 10 STUDENTS SORTED BY GPA: ");
        while(q != null && count < 10){
            System.out.println(q.info);
            q = q.next;
            count++;
        } 
    }
    
    void TOP5() {

        if (isEmpty()) {
            System.out.println("LIST IS EMPTY");
            return;
        }
        Node sortedHead = null;
        Node current = head;

        while (current != null) {
            Node n = new Node(current.info, null);
            if(sortedHead == null || n.info.studentID >= sortedHead.info.studentID){
                n.next = sortedHead;
                sortedHead = n;
        }
        else {
            Node q = sortedHead;
            while (q.next != null && q.next.info.studentID > n.info.studentID) {
                q = q.next;
            }
            n.next = q.next;
            q.next = n;
        }
        current = current.next;
        }

        System.out.println("TOP 5 STUDENTS SORTED BY ID: ");
        Node p = sortedHead;
        int count = 0;

        while(p != null && count < 5) {
            System.out.println(p.info);
            p = p.next;
            count++;
        }
    }
   
    void lessThan2GPA(){
        if (isEmpty()) {
            System.out.println("LIST IS EMPTY");
            return;
        }
        Node q = head;
        System.out.println("STUDENTS WHOSE GPA IS LESS THAN 2: ");
        
        while(q != null){
            if(q.info.studentGPA < 2){
                System.out.println(q.info);
            }
            q = q.next;
        }
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("LIST IS EMPTY");
            return;
        }
        
        Node q = head;
        System.out.println("STUDENTS LIST: ");
        
        while (q != null){
            System.out.println(q.info);
            q = q.next;
        }
    }
 
}
