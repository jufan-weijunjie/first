package com.wei.first.controller;

import com.wei.first.res.BaseResponse;
import com.wei.first.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName PhotoController
 * Describe :
 *
 * @Author weijunjie
 * @DATE 22:49 2019/6/30
 **/
@Controller
@RequestMapping("/get/photo/")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping("photoPage")
    public ModelAndView photoPage(){
        ModelAndView mv = new ModelAndView();
        BaseResponse photoTitleList = photoService.getPhotoTitleList(1, 10);
        mv.addObject("photos",photoTitleList.getData());
        mv.setViewName("photoPage");
        return mv;
    }

    @RequestMapping("photoPageS")
    public ModelAndView photoPage(Integer pageIndex,Integer pageSize){
        ModelAndView mv = new ModelAndView();
        BaseResponse photoTitleList = photoService.getPhotoTitleList(pageIndex,pageSize);
        mv.addObject("photos",photoTitleList.getData());
        mv.setViewName("photoPage");
        return mv;
    }

    @ResponseBody
    @RequestMapping("getTitleList")
    public Object getTitleList(Integer pageIndex,Integer pageSize){
        return photoService.getPhotoTitleList(pageIndex,pageSize);
    }

//    @ResponseBody
    @RequestMapping("getPhotoByCode")
    public ModelAndView getTitleList(String photoCode){
        ModelAndView mv = new ModelAndView();
        BaseResponse photoTitleList = photoService.getPhotoListByCode(photoCode);
        mv.addObject("photos",photoTitleList.getData());
        mv.setViewName("onePhotoPage");
        return mv;
    }
}
