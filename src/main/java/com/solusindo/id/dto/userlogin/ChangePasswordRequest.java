package com.solusindo.id.dto.userlogin;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 6568765635475785675L;

    private String username;
    private String oldpassword;
    private String newpassword;
}
