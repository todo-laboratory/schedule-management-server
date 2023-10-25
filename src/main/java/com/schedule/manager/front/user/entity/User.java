package com.schedule.manager.front.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "TB_USER")
@Data
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @NotNull
    @Column(name = "LOGIN_ID")
    private String loginId;

    @NotNull
    @Column(name = "NICK_NAME")
    private String nickName;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "PROFILE_URL")
    private String profileURL;

    @Column
    private boolean deleteYn;





}