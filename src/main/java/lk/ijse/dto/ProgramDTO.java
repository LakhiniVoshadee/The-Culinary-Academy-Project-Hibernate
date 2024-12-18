package lk.ijse.dto;


import lk.ijse.entity.Program;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDTO {
    private String id;
    private String name;
    private String seats;
    private String duration;
    private String fee;

    public Program toEntity() {
        Program program = new Program();
        program.setId(this.id);
        program.setName(this.name);
        program.setSeats(this.seats);
        program.setDuration(this.duration);
        program.setFee(this.fee);
        return program;
    }
}
