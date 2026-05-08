package studenttree;

public class BinarySearchTree {
  BSTNode root;
  int counter;

    public BinarySearchTree() {
        root = null;
        counter = 0;
    }
    
    boolean isEmpty(){
        return root == null;
    }
    
    int size(){
        return counter;
    }
     
    void clear(){
        root = null;
        counter = 0;
    }
    
    private BSTNode insertByGPA(BSTNode root, Student s) {
        if (root == null)
           return new BSTNode(s);

        if (s.studentGPA > root.info.studentGPA) {
            root.left = insertByGPA(root.left, s);
        }
        else {
            root.right = insertByGPA(root.right, s);
        }
        return root;
    }
    
    void insertStudent(Student s) {
        if (s.studentID <= 0) {
            System.out.println("INVALID ID");
            return;
        }

        if (s.studentGPA < 0 || s.studentGPA > 4) {
            System.out.println("INVALID GPA");
            return;
        }
        
        if(searchByID(root, s.studentID) != null) {
           System.out.println("DUPLICATE ID");
           return;
        }
        
        root = insertByGPA(root, s);
        counter++;
    }

    private BSTNode searchByID(BSTNode root, int id) {
        if(root == null) 
           return null;

        if(root.info.studentID == id) {
           return root;
        }
        
        BSTNode left = searchByID(root.left, id);
        if (left != null)
            return left;
        
        return searchByID(root.right, id);
    }
    
    void searchStudent(int id) {
        if (id <= 0) {
            System.out.println("INVALID ID");
            return;
        }
        
        BSTNode p = searchByID(root, id);
        if (p == null) {
            System.out.println("STUDENT NOT FOUND");
        }
        else {
            System.out.println(p.info);
        }
    }
    
    private BSTNode removeByID(BSTNode root, int id) {
        if (root == null)
            return null;

        if (root.info.studentID == id) {
            if (root.left == null){
               return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            
            BSTNode minNode = root.right;
            while (minNode.left != null)
               minNode = minNode.left;

            root.info = minNode.info;
            root.right = removeByID(root.right, minNode.info.studentID);
            
            return root;
        }

        root.left = removeByID(root.left, id);
        root.right = removeByID(root.right, id);

        return root;
    }
    
    void removeStudent(int id) {
        if (id <= 0) {
            System.out.println("INVALID ID");
            return;
        }
        
        if (searchByID(root, id) == null) {
            System.out.println("STUDENT NOT FOUND");
            return;
        }
        
        root = removeByID(root, id);
        counter--;
        System.out.println("STUDENT REMOVED");
    }
    
    
    int top10Count = 0;

    private void top10GPA(BSTNode root) {
        if (root == null || top10Count == 10)
            return;

        top10GPA(root.left);
        
        if (top10Count < 10) {
            System.out.println(root.info);
            top10Count++;
        }
        top10GPA(root.right);
    }
    
    void TOP10() {
        if (isEmpty()) {
            System.out.println("TREE IS EMPTY");
            return;
        }
        top10Count = 0;
        System.out.println("TOP 10 STUDENTS SORTED BY GPA: ");
        top10GPA(root);
    }
    
    
    Student[] top5std = new Student[5];
    
    private void insertTop5(Student s) { 
        for (int i = 0; i < 5; i++) {
            if (top5std[i] == null || s.studentID > top5std[i].studentID) {
                for (int j = 4; j > i; j--) {
                    top5std[j] = top5std[j - 1];
                }
                top5std[i] = s;
                break;
            }
        }
    }
    
    private void findTop5(BSTNode root) {
        if (root == null)
            return;
        
        insertTop5(root.info);
        
        findTop5(root.left);
        findTop5(root.right);
    }
    
    void TOP5() {
        if (isEmpty()) {
            System.out.println("TREE IS EMPTY");
            return;
        }
        for (int i = 0; i < 5; i++) {
            top5std[i] = null;
        }

        findTop5(root);
        System.out.println("TOP 5 STUDENTS SORTED BY ID:");

        for (int i = 0; i < 5; i++) {
            if (top5std[i] != null) {
               System.out.println(top5std[i]);
            }
        }      
    }

    
    boolean found;
    
    private void printLessThan2(BSTNode root) {
        if (root == null)
            return;

        printLessThan2(root.left);

        if (root.info.studentGPA < 2) {
            System.out.println(root.info);
            found = true;  
        }
         printLessThan2(root.right);
    }

    void lessThan2GPA() {
        if (isEmpty()) {
            System.out.println("TREE IS EMPTY");
            return;
        }

        System.out.println("STUDENTS HAVING GPA LESS THAN 2: ");
        found = false;  
        printLessThan2(root);

        if (!found) {
            System.out.println("NO STUDENTS HAVE GPA LESS THAN 2");
        }
    }
    
    private void inOrder(BSTNode root) {
        if (root == null) 
            return;

        inOrder(root.left);
        System.out.println(root.info);
        inOrder(root.right);
    }

    void display() {

        if (isEmpty()) {
            System.out.println("TREE IS EMPTY");
            return;
        }
        
        System.out.println("STUDENTS TREE: ");
        inOrder(root);
    }
    
}
