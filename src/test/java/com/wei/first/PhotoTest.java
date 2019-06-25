package com.wei.first;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wei.first.bean.GetPhoto;
import com.wei.first.utils.HttpsUtil;
import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 */
public class PhotoTest extends FirstApplicationTests {

//    1708
//    https://api.tuwan.com/apps/Welfare/detail?type=image&dpr=3&id=1708
//    1554
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
    public void addPhotoTest(){
        ArrayList<GetPhoto> getPhotos = new ArrayList<>();
            GetPhoto getPhoto = new GetPhoto();
            getPhoto.setClearUrl("aaaa");
            getPhoto.setNarrowUrl("bbbb");
            getPhoto.setPhotoIndex(1);
            getPhoto.setPhotoName("测试文件");
            getPhoto.setTotal(3);
            getPhoto.setStatus("1");
        Field[] fields = getPhoto.getClass().getDeclaredFields();
        for (Field field:fields){
            String name = field.getName();
            System.out.println(name);
            AnnotatedType annotatedType = field.getAnnotatedType();
//            field.get();
        }




    }
}
