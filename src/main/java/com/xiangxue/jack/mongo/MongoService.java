package com.xiangxue.jack.mongo;

import java.util.List;

public interface MongoService<E> {

    public String save(E obj);

    public List<E> findAll();

    public E getById(String id);

    public E getByName(String name);

    public String updateE(E e);

    public String deleteE(E e);

    public String deleteById(String id);

    public List<E> findLikes(String reg);
}
