package lk.ijse.dto;


import lk.ijse.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String email;

   /* public StudentDto(String studentId,String studentname){
        this.id=studentId;
        this.name=studentname;

    }*/


    public Student toEntity(){
        Student student = new Student();
        student.setId(this.id);
        student.setName(this.name);
        student.setAddress(this.address);
        student.setContact(this.contact);
        student.setEmail(this.email);
        return student;
    }
}
