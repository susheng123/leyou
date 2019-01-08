package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by susheng on 2019/1/8.
 */
@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper groupMapper;
    @Autowired
    private SpecParamMapper paramMapper;


    public List<SpecGroup> queryGroupByCid(Long cid) {
        SpecGroup group = new SpecGroup();
        group.setCid(cid);
        List<SpecGroup> list = groupMapper.select(group);
        if (CollectionUtils.isEmpty(list)) {
            throw new RuntimeException();
        }
        return list;
    }

    public List<SpecParam> queryParamByGid(Long gid) {
        SpecParam param = new SpecParam();
        param.setGroupId(gid);
        List<SpecParam> list = paramMapper.select(param);
        if (CollectionUtils.isEmpty(list)) {
            throw new RuntimeException();
        }
        return list;
    }
}