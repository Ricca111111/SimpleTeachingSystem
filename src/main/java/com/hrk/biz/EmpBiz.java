package com.hrk.biz;

import com.hrk.entity.Emp;
import com.hrk.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpBiz {
    @Autowired

    private EmpMapper mapper;

    public List<Emp> getEmpList(){
        return mapper.selectEmps();
    }
    public Emp getEmpById(int id){
        return mapper.selectEmpById(id);
    }

    public boolean addEmp(Emp emp){

        return mapper.insertEmp(emp)>0;
    }
    public boolean removeEmp(int id){
        return mapper.deleteEmpById(id)>0;
    }

    public void setMapper(EmpMapper mapper) {
        this.mapper = mapper;
    }



}
