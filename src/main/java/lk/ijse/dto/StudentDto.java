package lk.ijse.dto;


import lk.ijse.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private String email;


    public Student toEntity(){
        Student student = new Student();
        student.setStudentId(this.studentId);
        student.setName(this.name);
        student.setAddress(this.address);
        student.setContact(this.contact);
        student.setEmail(this.email);
        return student;
    }
}
