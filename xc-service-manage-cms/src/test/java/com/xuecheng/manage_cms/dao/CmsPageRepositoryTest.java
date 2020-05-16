package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

//测试类
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll() {
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindPage() {
        int page = 0;//页码从0开始
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    @Test//修改
    public void testUpdate() {
        //jdk1.8新特性，相当于容器对象，作用是避免空指针异常
        Optional<CmsPage> optional = cmsPageRepository.findById("5abefd525b05aa293098fca6");
        //想要调用时，必须先调用isPresent，可以标准化地判断是否为空
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("ccc");
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }
    }

    @Test
    public void testFindByPageName() {
        CmsPage cmsPage = cmsPageRepository.findByPageName("index.html");
        System.out.println(cmsPage);
    }

}
