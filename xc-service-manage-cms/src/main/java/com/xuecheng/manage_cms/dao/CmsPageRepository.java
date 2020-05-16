package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

//MongoRepository<模型， 主键类型>
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
    //自定义方法
    CmsPage findByPageName(String pageName);
}
