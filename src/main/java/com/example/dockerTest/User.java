package com.example.dockerTest;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@Entity @Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "user_user_id_email_unique",
                        columnNames = {"user_id", "email"}
                )
        }
)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "stop_state", insertable = false)
    private String stopState;

    @Column(name = "delete_state", insertable = false)
    private String deleteState;

    @Column(name = "created_date", nullable = false, insertable = false, updatable = false)
    private Date createdDate;

    @Column(name = "updatedDate", nullable = false, insertable = false, updatable = false)
    private Date updatedDate;

    @Column(name = "number_of_report", insertable = false)
    private int report;

    public User(String userId, String password, String name, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    /**
     * Test 진행을 할 때 편하기 위해서 사용하는 것임
     * 사용할 때 주의하기
     */
    public void changePassword(String password){
        this.password = password;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changeEmail(String email){
        this.email = email;
    }

}
