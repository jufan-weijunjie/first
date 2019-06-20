package com.wei.first;

import com.alibaba.fastjson.JSONObject;
import com.wei.first.bean.GetPhoto;
import com.wei.first.mapper.GetPhotoMapper;
import com.wei.first.service.SysUserService;
import com.wei.first.utils.Base64Utils;
import com.wei.first.utils.HttpsUtil;
import com.wei.first.utils.JwtUtils;
import com.wei.first.utils.RSAUtils;
import io.jsonwebtoken.Claims;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.wei.first.mapper")
public class FirstApplicationTests {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    GetPhotoMapper getPhotoMapper;

    /**
     * 下载附件信息
     */
    @Test
    public void contextLoads() {
        try {
            File file = new File("D:\\100925File\\01.xls");
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int a = sheet.getLastRowNum();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            for(int i = 1;i<=a;i++){
                XSSFRow row = sheet.getRow(i);
//                String packName = sf.format(row.getCell(0).getDateCellValue());
                String fileName = row.getCell(1).getStringCellValue()+row.getCell(0).getStringCellValue();;
                String url = row.getCell(2).getStringCellValue();
                String path = "D:/100925File/"+fileName+".jpeg";
                HttpsUtil.downloadFile(url,path);
            }
            in.close();
        }catch (Exception e){

            e.printStackTrace();
        }

//        HttpsUtil.downloadFile("http://jufan-contract.oss-cn-hangzhou.aliyuncs.com/SC_200000002/2282bf16-cd31-41c5-b8d1-68242700276f.pdf","D:/taianFile/123/456.pdf");

    }

    @Test
    public void addUser() {
//        ArrayList<String> strings = new ArrayList<>();
//        List<String> strings = Arrays.asList("12", "23", "34", "56", "45", "67", "89", "78", "91");
//        List<List<String>> lists = UseListUtils.divisionList(strings, 2);
//        lists.stream().forEach(s-> System.out.println(JSONObject.toJSONString(s)));
//        Map<String, Object> stringObjectMap = RSAUtils.genKeyPair();
//        String privateKey = RSAUtils.getPrivateKey(stringObjectMap);
//        String publicKey = RSAUtils.getPublicKey(stringObjectMap);
//        System.out.println("私钥="+privateKey+"；公钥："+publicKey);
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGepbySd6ao0xvzIiH9mqmIj/hSam2i/tcaWWI2GH8/xv3R5jjFG+fV+JJ6JGYzZa1LEuJeZCojGCPSNktjU484bMuwkK/c1pYXftK/NCq94xiAoVt+C5qlx0ubMVO8Pw109Dx6qfsGidwuJKrQzEmSnJuNscwI6yjN9xAW1UBNwIDAQAB";
//        String dataa = "456789";
//        String s = RSAUtils.encryptByPublicKey(dataa, publicKey);
        String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMZ6lvJJ3pqjTG/MiIf2aqYiP+FJqbaL+1xpZYjYYfz/G/dHmOMUb59X4knokZjNlrUsS4l5kKiMYI9I2S2NTjzhsy7CQr9zWlhd+0r80Kr3jGIChW34LmqXHS5sxU7w/DXT0PHqp+waJ3C4kqtDMSZKcm42xzAjrKM33EBbVQE3AgMBAAECgYEAvHd11BYO2boMf/CxCKIVvTGyhOOk0uFzStoN/vaxfUJlNNb4t1AVejJCfznm3zkBTYIFLEKR+Wpq2kQrbZTLX1lLjeqAsXgMu5XIPGhzMcrwT3KLXAaQf6tgHRxJoLJLmHlqDmk8Jf0VpBjgsS57BAjZw7gj9R5Bnu9MkE5L3dECQQDw9ElJWGne0aipFJpgGs5CiXwB+bIopr3KiNWMBlNAwkF40q0TW9zPKmMpm9irhViLOyBvAtY3CidsQYCQeK4pAkEA0t9S56ZSkOBCqqmw6vieTCkojvFKWuAfcL3tMAwIbcjj6KecPVXUMLtzcc+p/U6/428VVRxzBnpi8dwiUPVgXwJAR4ogIDix5kgVbW4Cj7oltzeeq+945/zpqLKLxLE0EqwaSEc0v+SsYI3TN01gPTywF1aMwKj09Q58ufWQuFQ8UQJBALJtDnw96mz1pNM9BBq9xUuSI+RXXF/qdg/yVKir9dHXAqkQcY4geovFgJhTa3WPVaQ+kOFUUiuwENqvNkYkaacCQQCoj1w9ETb+2jT3PAlbSMFyL6ls0MUmk64wEv5ixzGs1Beo2SQqaj2OoBiG/VdKqCVqmniP2iqmCweQTvYzMm8b";
        try {
//            System.err.println("公钥加密——私钥解密");
//            String source = "这是一行没有任何意义的文字，你看完了等于没看，不是吗？";
//            System.out.println("\r加密前文字：\r\n" + source);
//            byte[] data = source.getBytes();
//            byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
//            String encode = Base64Utils.encode(encodedData);
//            System.out.println("加密后文字：\r\n" + encode);
//            byte[] decode = Base64Utils.decode(encode);
//            byte[] decodedData = RSAUtils.decryptByPrivateKey(decode, privateKey);
//            String target = new String(decodedData);
//            System.out.println("解密后文字: \r\n" + target);
            System.err.println("私钥加密——公钥解密");
            String source = "这是一行测试RSA数字签名的无意义文字";
            System.out.println("原文字：\r\n" + source);
            byte[] data = source.getBytes();
            byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);
            String encode = Base64Utils.encode(encodedData);
            System.out.println("加密后：\r\n" + encode);
            byte[] decode = Base64Utils.decode(encode);
            byte[] decodedData = RSAUtils.decryptByPublicKey(decode, publicKey);
            String target = new String(decodedData);
            System.out.println("解密后: \r\n" + target);

            System.err.println("私钥签名——公钥验证签名");
            String sign = RSAUtils.sign(encodedData, privateKey);
            System.err.println("签名:\r" + sign);
            boolean status = RSAUtils.verify(encodedData, publicKey, sign);
            System.err.println("验证结果:\r" + status);
        }catch (Exception e){
            e.printStackTrace();
        }



//        System.out.println(s);

    }

    @Test
    public void testCreateKey(){
//        long jwtTime = 1000*60*60*24*7;
//        System.out.println(jwtTime);
//        JwtUtils jwtUtils = new JwtUtils();
//        String id = "jwt";
//        long jwtTime = 1000*60*60*24*7;
//        System.out.println(jwtTime);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code","12345");
//        jsonObject.put("pwd","12345");
//        String jwt = jwtUtils.createJWT(id, jsonObject.toJSONString(), jwtTime);
//        System.out.println(jwt);
//        Claims claims = jwtUtils.parseJWT(jwt);
//        System.out.println(JSONObject.toJSONString(claims));
//        sysUserService.addUser();
        /*BigDecimal principalAmount = new BigDecimal(11);
        BigDecimal totalAmount = new BigDecimal(11);
        if(principalAmount.compareTo(new BigDecimal(10)) == -1 &&
                totalAmount.compareTo(new BigDecimal(10)) == -1){
            System.out.println("aaaa");
        }else{
            System.err.println("bbbb");
        }*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("merchantCode","1000001");
        String s = HttpsUtil.doPost("http://t.jufandev.com:8821/ams/asset/insideCompany/getMerchantCodeInHr", jsonObject);
        System.out.println(s);
    }

    @Test
    public void test223(){
        GetPhoto getPhoto = getPhotoMapper.selectByPrimaryKey(7);
        System.out.println(getPhoto.toString());
    }




}
