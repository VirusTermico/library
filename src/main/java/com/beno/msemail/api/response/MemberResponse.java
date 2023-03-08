package com.beno.msemail.api.response;

import lombok.Data;

@Data
public class MemberResponse {
    private Integer id;
    String name;
    String email;
    String mobile;

}
