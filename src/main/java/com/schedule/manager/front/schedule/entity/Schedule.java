package com.schedule.manager.front.schedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.schedule.manager.front.group.entity.Group;
import com.schedule.manager.front.user.entity.User;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "TB_SCHEDULE")
@Data
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @NotNull
    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column
    private boolean deleteYn;

    @Column
    @OneToMany
    private List<Group> groupList;

    @Column
    @OneToMany
    private List<User> userList;

    @Column
    private String content;

    @Column
    private String title;

    @Column
    private int location_lat;

    @Column
    private int location_lng;

    @Column
    private LocalDateTime schedule_start_time;

    @Column
    private LocalDateTime schedule_end_tile;

    @Column
    private LocalDateTime alarm_time; // 여러개일수도? 회의 필요

}
