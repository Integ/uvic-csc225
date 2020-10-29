public class StudentNode {
    public StudentNode next;
    private Student data;

    public StudentNode(Student data) {
        this.data = data;
    }

    public StudentNode(Student data, StudentNode next) {
        this.data = data;
        this.next = next;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }
}