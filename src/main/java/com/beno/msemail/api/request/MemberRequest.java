package com.beno.msemail.api.request;

import lombok.Data;

@Data
public class MemberRequest {
    String name;
    String email;
    String mobile;
}
