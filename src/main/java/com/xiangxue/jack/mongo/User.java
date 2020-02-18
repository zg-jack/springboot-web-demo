package com.xiangxue.jack.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/*
* BSON
*
* {
*   id:xxx
*   username:xx,
*   password:xx
*
* }
* */
@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field
    private String username;

    @Field
    private String password;
}
