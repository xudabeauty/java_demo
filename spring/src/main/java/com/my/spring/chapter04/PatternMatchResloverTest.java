package com.my.spring.chapter04;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PatternMatchResloverTest {
    @Test
    public void getResources() throws IOException {
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        Resource res[]=resolver.getResources("classpath:com/my/spring/*.xml");
        assertNotNull(res);
        for(Resource resource:res) {
            System.out.println(resource.getDescription());
            
        }
        
        
    }

}
