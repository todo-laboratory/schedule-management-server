package com.schedule.manager.front.group.model.request;

import com.schedule.manager.front.user.entity.User;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UpdateGroupReqDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private boolean managerYn;
    @NotBlank
    private String groupName;
    private String groupDescription;
    private List<Long> users;
    private LocalDateTime groupEndTime;
    private boolean deleteYn;
}
