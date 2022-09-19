package com.example.demo.pojo;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

@Builder
public class UserPojo extends PersonPojo{
    private int id;
    private String name;
    private String phone;
    private int age;
    private Integer ageZ;

    public static void main(String[] args) {
        UserPojo user = UserPojo.builder().id(1).name("wang").build();
        System.out.println(user);

        UserPojo wang = new UserPojo()
                .setId(111)
                .setName("wang");


    }

}
