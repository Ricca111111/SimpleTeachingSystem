package com.hrk.biz;

import com.hrk.entity.Noti;
import com.hrk.mapper.NotiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class NotiBiz {
    @Autowired
    private NotiMapper mapper;

    public List<Noti> getNotiList(){
        return mapper.selectNotis();
    }

    public Noti getNotiById(Integer id){
        return mapper.selectNotiById(id);
    }

    public boolean addNoti(Noti noti){

        return mapper.insertNoti(noti)>0;
    }

    public boolean removeNoti(Integer id){
        return mapper.deleteNotiById(id)>0;
    }

    public void setMapper(NotiMapper mapper) {
        this.mapper = mapper;
    }

    public boolean updateNoti(Noti noti) {
        return mapper.updateNoti(noti) > 0;
    }

    public List<Noti> searchNotis(String searchType, String keyword) {
        if ("id".equals(searchType)) {
            try {
                Integer id = Integer.parseInt(keyword);
                return Collections.singletonList(getNotiById(id));
            } catch (NumberFormatException e) {
                return Collections.emptyList();
            }
        } else {
            return mapper.searchNotis(searchType, keyword);
        }
    }
}