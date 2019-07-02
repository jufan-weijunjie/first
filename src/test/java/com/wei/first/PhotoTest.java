package com.wei.first;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wei.first.bean.GetPhoto;
import com.wei.first.mapper.GetPhotoMapper;
import com.wei.first.service.PhotoService;
import com.wei.first.utils.HttpsUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
public class PhotoTest extends FirstApplicationTests {

//    1708
//    https://api.tuwan.com/apps/Welfare/detail?type=image&dpr=3&id=1708
//    1554

    @Autowired
    PhotoService photoService;
    @Test
    public void getPhotos(){

        for(int i = 1554; i<=1708;i++) {
            String s = HttpsUtil.doGet("https://api.tuwan.com/apps/Welfare/detail?type=image&dpr=3&id=" + i);
            String substring = s.substring(1, s.length() - 1);
            JSONObject jsonObject;
            try {
                jsonObject = JSONObject.parseObject(substring);

                JSONArray data = jsonObject.getJSONArray("data");
                int z= 1;
                for (Object obj:data){
                    GetPhoto getPhoto = new GetPhoto();
                    getPhoto.setPhotoCode(i+"");
                    getPhoto.setPhotoIndex(z);
                    getPhoto.setPhotoName(jsonObject.getString("title"));
                    JSONObject jso = JSONObject.parseObject(obj.toString());
                    getPhoto.setStatus("1");
                    getPhoto.setClearUrl(jso.getString("pic"));
                    getPhoto.setTotal(3);
                    getPhoto.setNarrowUrl(jso.getString("thumb"));
                    getPhotoMapper.insert(getPhoto);
                    z++;
                }
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

        }
    }

    @Test
    public void addPhotoTest() throws Exception{

//        ArrayList<GetPhoto> getPhotos = new ArrayList<>();
            /*GetPhoto getPhoto = new GetPhoto();
            getPhoto.setId(5);
            getPhoto.setStatus("1");
        GetPhoto getPhoto1 = getPhotoMapper.selectByEntity(getPhoto);
        System.out.println(JSONObject.toJSONString(getPhoto1));*/
//        basePageService.
    }

    @Test
    public void addTest(){
        /*ArrayList<GetPhoto> getPhotos = new ArrayList<>();
        GetPhoto getPhoto = new GetPhoto();
        getPhotos.add(getPhoto);
        getPhoto.setId(2);
        System.out.println(JSONObject.toJSONString(getPhotos));*/
    }
}
