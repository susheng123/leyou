package com.leyou.item.controller;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by susheng on 2019/1/8.
 */
@RestController
@RequestMapping("spec")
public class SpecificationController {
    @Autowired
    private SpecificationService specService;

    //根据分类id查询规格组
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") Long cid) {
        return ResponseEntity.ok(specService.queryGroupByCid(cid));
    }

    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParamByGid(@RequestParam(value="gid",required = false) Long gid,
                                                           @RequestParam(value="cid",required = false) Long cid,
                                                           @RequestParam(value="searching",required = false) Boolean searching) {
        return ResponseEntity.ok(specService.queryParamByGid(gid,cid,searching));
    }
}
