package com.baizhi.lfq.controller;

import com.baizhi.lfq.entity.User;
import com.baizhi.lfq.entity.UserDTO;
import com.baizhi.lfq.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14832 on 2018/7/8.
         */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @ResponseBody
    @RequestMapping("queryAllUser")
    public List<User> queryAllUser(){
        List<User> users = userService.queryAllUser();
        return users;
    }
    @ResponseBody
    @RequestMapping("/customer")
    public void customer(String title,String fileds){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet= workbook.createSheet("user");

        String[] titles = title.split(",");
        String[] param = fileds.split(",");

        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            row.createCell(i).setCellValue(titles[i]);
        }

        List<User> users = userService.queryAllUser();
        for (int i = 0; i < users.size(); i++) {
            Class<? extends User> aClass = users.get(i).getClass();
            HSSFRow row1 = sheet.createRow(i + 1);

            for (int j = 0; j < param.length; j++) {
               String nethodName= "get"+param[j].substring(0,1).toUpperCase()+param[j].substring(1);
                Object a=null;
                try {
                    a = aClass.getDeclaredMethod(nethodName, null).invoke(users.get(i), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (a instanceof Date){
                    HSSFDataFormat dataFormat = workbook.createDataFormat();
                    short format = dataFormat.getFormat("yyyy年MM月dd日");
                    HSSFCellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(format);
                    HSSFCell row1Cell = row1.createCell(j);
                    row1Cell.setCellStyle(cellStyle);
                    row1Cell.setCellValue((Date)a);
                }else {
                    row1.createCell(j).setCellValue(String.valueOf(a));
                }
            }
        }

        try {
            workbook.write(new FileOutputStream(new File("d:/customert.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("/selectAllUserBySex")
    public Map<String,List<UserDTO>> selectAllUserBySex(){
        List<UserDTO> man= userService.selectAllUserBySex("男");
        List<UserDTO> woman= userService.selectAllUserBySex("女");
        Map<String, List<UserDTO>> map = new HashMap<>();
        map.put("man",man);
        map.put("woman",woman);
        return map;
    }




















    @ResponseBody
    @RequestMapping("export")
    public void export(HttpServletResponse response){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet= workbook.createSheet("user");
        String[] titles={"编号","名字","性别","生日"};
        for (int i = 0; i < titles.length; i++) {
            HSSFRow row = sheet.createRow(0);
            row.createCell(i).setCellValue(titles[i]);

        }
        List<User> users = userService.queryAllUser();
        for (int i = 0; i < users.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(users.get(i).getId());
            row1.createCell(1).setCellValue(users.get(i).getName());
            row1.createCell(2).setCellValue(users.get(i).getSex());
            row1.createCell(3).setCellValue(users.get(i).getCreateTime());
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        format = format + ".xlsx";
        String aa=null;
        try {
            aa = new String(format.getBytes("utf-8"),"ISO-8859-1");

        response.setHeader("context-disposition","attachment;filename"+aa);
        response.setContentType("application/vnd.ms-excel");

        workbook.write(response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @ResponseBody
    @RequestMapping("poiImport")
    public void poiImport(MultipartFile file){
        try {
            InputStream inputStream = file.getInputStream();
            HSSFWorkbook workbook = new HSSFWorkbook();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
