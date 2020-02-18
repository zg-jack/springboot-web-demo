package com.xiangxue.jack.mongo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class MongoServiceImpl implements MongoService<User> {
    /*
    * 这个实例是从哪里来的？？
    * */
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(User obj) {
        mongoTemplate.save(obj);
        return "1";
    }

    @Override
    public List<User> findAll() {
        List<User> all = mongoTemplate.findAll(User.class);
        return all;
    }

    @Override
    public User getById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public User getByName(String name) {
        Query query = new Query(Criteria.where("username").is(name));
        return mongoTemplate.findOne(query,User.class);
    }

    /*
    * update xx set() where xx =a
    * */
    @Override
    public String updateE(User user) {
        Query query = new Query(Criteria.where("_id").is(user.getId()));
        Update update = new Update().set("username", user.getUsername()).set("password", user.getPassword());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        return updateResult.toString();
    }

    @Override
    public String deleteE(User user) {
        DeleteResult remove = mongoTemplate.remove(user);
        return remove.toString();
    }

    @Override
    public String deleteById(String id) {
        User user = getById(id);
        String cacheResult = deleteE(user);
        return cacheResult;
    }

    @Override
    public List<User> findLikes(String reg) {
        Pattern pattern = Pattern.compile("^.*" + reg + ".*$" , Pattern.CASE_INSENSITIVE);
        Query query = Query.query(Criteria.where(reg).regex(pattern));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
