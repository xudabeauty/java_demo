package com.my.mybatis.mapper;

import com.my.mybatis.bean.Employee;

public interface EmployeeMapper {
    
    public Employee selectEmployee(Integer id);

}
