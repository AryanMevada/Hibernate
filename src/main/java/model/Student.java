package model;


import jakarta.persistence.*;


@Entity
@Table(name = "student_info")
public class Student {

    @Id
    @Column(name = "Std_ROLLNO")
    private int rollNo;

    @Column(name = "Std_ENRID", length = 6)
    private String enrollmentId;

    @Column(name = "Std_Name")
    private String name;

    @Column(name = "Std_Course")
    private String course;

    @Column(name = "Std_ContactNo")
    private String contact;
    
    

	public Student(int rollNo, String enrollmentId, String name, String course, String contact) {
		super();
		this.rollNo = rollNo;
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.course = course;
		this.contact = contact;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}


}
