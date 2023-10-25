package com.schedule.manager.front.group.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.schedule.manager.front.user.entity.User;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "TB_GROUP")
@Data
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private Long id;
    @NotNull
    private boolean managerYn;
    @NotNull
    private String groupName;
    private String groupDescription;
    @OneToMany
    private List<User> users;
    private LocalDateTime groupEndTime;
    private boolean deleteYn;
}
