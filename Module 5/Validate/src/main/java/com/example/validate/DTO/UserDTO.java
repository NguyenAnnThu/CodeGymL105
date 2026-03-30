package com.example.validate.DTO;

import jakarta.validation.constraints.*;

public class UserDTO {
    private int id;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min=5, max = 45 , message = "Tên phải có từ 5 đến 45 ký tự")
    private String firstName;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min=5, max = 45 , message = "Tên phải có từ 5 đến 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^\\+?\\d{10,12}$", message = "So dien thoai khong hop le")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi tối thiểu là 18")
    @Max(value = 100, message = "Tuổi tối đa là 100")
    private int age;

    @NotBlank(message = "Khong duoc de trong")
    @Email(message = "Khong hop le")
    private String gmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
