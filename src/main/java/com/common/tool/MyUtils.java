package com.common.tool;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {
    public static String[] stringToList(String strs){
        String str[] = strs.split(",");
        return str;
    }

    /***
     * 下划线命名转为驼峰命名
     * @param para 下划线命名的字符串
     */
    public static String UnderlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 生成32位UUID
     * @return
     */
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

    public static List<Map<String,String>> addressResolution(String address){
        String regex="(?<province>[^省]+省|.+自治区)(?<city>[^市]+市|.+自治州)(?<county>[^县]+县|.+区)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m= Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }

    /**
     * 截取字符串中的身份证信息
     * @param values
     * @return
     */
    public static String getVlues(String values) {
        String str = "\\d{6}((19|20)\\d{2})((0[0-9])|(1[0-2]))(((0|1|2)[0-9])|(3[0,1]))\\d{3}[xX\\d]";
        if(null==values){
            return "";
        }else{
            Pattern pattern = Pattern.compile(str);
            Matcher matcher = pattern.matcher(values);
            if (matcher.find()) {
                return matcher.group();
            }else{
                return "";
            }
        }
    }

    /**
     * 从任意字符串中提取数字
     * @param str
     * @return
     */
    public static String getNumCardFromString(String str){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


    /**
     * 把字符串进行asc编码
     * @param a
     * @return
     */
    public static String StringToAscInt(String a){
        String mode = "";
        String [] target = a.split("");
        for(String str:target){
            mode = mode + Integer.valueOf(str.charAt(0));
        }
        return  mode;
    }


    /**
     * 时间戳转date
     * @param time
     * @return
     */
    public static Date timeToDate(Long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(time*1000);
        Date date = null;
        try{
            date=format.parse(d);
        }catch (ParseException e){

        }
        return date;
    }

    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String EncoderByMd5(String str){
        String newstr = str;
        try {
            //确定计算方法
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            return newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        }catch (NoSuchAlgorithmException e){
            return newstr;
        }catch (UnsupportedEncodingException e){
            return newstr;
        }
    }

    /**判断用户密码是否正确
     * @param newpasswd  用户输入的密码
     * @param oldpasswd  数据库中存储的密码－－用户密码的摘要
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean checkpassword(String newpasswd,String oldpasswd){
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

    public static void main(String[]  args){
        // getCvsData("C:\\Users\\double\\Desktop\\SJDYZY5300005300_ZTXDSD000004_2017071910280082_1.csv");
        System.out.println(getUUID32());
    }

    public static void getCvsData(String filePath){
        File csv = new File(filePath);  // CSV文件路径
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            List<String> allString = new ArrayList<>();
            while ((line = br.readLine()) != null)  //读取到的内容给line变量
            {
                everyLine = line;
                System.out.println(everyLine);
                allString.add(everyLine);
            }
            System.out.println("csv表格中所有行数："+allString.size());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getNowDateFormatString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

}
