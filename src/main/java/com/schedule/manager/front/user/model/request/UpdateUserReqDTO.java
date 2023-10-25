package com.schedule.manager.front.user.model.request;

import lombok.Data;
import org.hibernate.validator.constraints.Normalized;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateUserReqDTO {
    @NotBlank
    Long id;

    private String loginId;

    private String nickName;

    private String name;

    private String profileURL;

    private boolean deleteYn;

}
