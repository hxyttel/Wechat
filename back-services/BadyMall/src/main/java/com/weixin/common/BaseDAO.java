package com.weixin.common;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<PK extends Serializable,T>{
    abstract int saveModel(T model);
    abstract int updateModel(T model);
    abstract int deleteModel(T model);
    abstract List<T> listModel();
    abstract T getModel(Integer PK);
}
