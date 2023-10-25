package com.schedule.manager.front.user.model.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateUserReqDTO {

    Long id;

    @NotBlank
    private String loginId;

    @NotBlank
    private String nickName;

    @NotBlank
    private String name;

    private String profileURL;
}
