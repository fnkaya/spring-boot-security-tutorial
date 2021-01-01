package com.spring.web.validation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User {

    @NotBlank(message = "Name field can not be empty")
    private String name;

    @Min(value = 12, message = "Age can not be less then 12")
    @Max(value = 100, message = "Age can not be more then 100")
    private Integer age;

    @NotBlank(message = "Email field can not be empy")
    @Email(message = "Email must be a well-formed email address")
    private String email;

    @NotBlank(message = "Username field can not be empty")
    private String username;

    @TcKimlikNo
    private String tcNo;

    @PastOrPresent(message = "Date field must be past or present")
    private LocalDate dob;

    @Size(max = 250, message = "Address field must be less then 250 characters")
    private String address;

    @AssertTrue
    @JsonIgnore
    public boolean isUsernameValid(){
        return !username.equalsIgnoreCase("admin");
    }
}
