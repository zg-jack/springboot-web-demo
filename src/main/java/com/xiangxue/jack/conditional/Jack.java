package com.xiangxue.jack.conditional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Jack implements People {

    private String username;

    @Override
    public String eat() {
        return null;
    }
}
