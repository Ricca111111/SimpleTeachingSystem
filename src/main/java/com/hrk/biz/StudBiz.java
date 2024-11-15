package com.hrk.biz;

import com.hrk.entity.Stud;
import com.hrk.mapper.StudMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class StudBiz {
    @Autowired
    private StudMapper mapper;

    public List<Stud> getStudList(){
        return mapper.selectStuds();
    }

    public Stud getStudBySequence(Integer sequence){
        return mapper.selectStudBySequence(sequence);
    }

    public boolean addStud(Stud stud){

        return mapper.insertStud(stud)>0;
    }

    public boolean removeStud(Integer sequence){
        return mapper.deleteStudBySequence(sequence)>0;
    }

    public void setMapper(StudMapper mapper) {
        this.mapper = mapper;
    }

    public boolean updateStud(Stud stud) {
        return mapper.updateStud(stud)>0;
    }
    public List<Stud> searchStuds(String searchType, String keyword) {
        if ("sequence".equals(searchType)) {
            try {
                Integer sequence = Integer.parseInt(keyword);
                return Collections.singletonList(getStudBySequence(sequence));
            } catch (NumberFormatException e) {
                return Collections.emptyList();
            }
        } else {
            return mapper.searchStuds(searchType, keyword);
        }
    }
}
