package models;
import lombok.*;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Contacts {
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String description;

}
