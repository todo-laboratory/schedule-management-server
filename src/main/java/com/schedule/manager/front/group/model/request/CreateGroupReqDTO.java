package com.schedule.manager.front.group.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CreateGroupReqDTO {
    private Long id;
    @NotBlank
    private boolean managerYn;
    @NotBlank
    private String groupName;
    private String groupDescription;
    private List<Long> userIdList;
    private LocalDateTime groupEndTime;
    private boolean deleteYn;
}
