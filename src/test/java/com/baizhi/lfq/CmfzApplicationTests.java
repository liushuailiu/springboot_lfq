package com.baizhi.lfq;

import com.baizhi.lfq.dao.ChapterDao;
import com.baizhi.lfq.entity.*;
import com.baizhi.lfq.service.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfzApplication.class)
public class CmfzApplicationTests {
    @Resource
    MenuService menuService;
    @Resource
    AdminService adminService;
    @Resource
    BannerService bannerService;
    @Resource
    AlbumService albumService;
    @Resource
    UserService userService;
    @Resource
    LoggingService loggingService;
    @Resource
    ChapterDao chapterDao;

    @Test
    public void poiExcel() throws Exception {
        //构建excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //设置日期格式
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");

        //  构建居中样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        font.setFontName("楷体");
        cellStyle.setDataFormat(format);

        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //创建表
        HSSFSheet sheet = workbook.createSheet("user");
        sheet.setColumnWidth(3, 28 * 256);
        //创建   行下标
        HSSFRow row = sheet.createRow(0);

        String[] titles = {"编号", "名字", "性别", "生日"};

        //构建标题   单元格对应的下标
        // HSSFCell cell = row.createCell(0);
        //cell.setCellValue("编号");
        for (int i = 0; i < titles.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(cellStyle);

        }
        List<User> users = userService.queryAllUser();
        for (int i = 0; i < users.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(users.get(i).getId());
            row1.createCell(1).setCellValue(users.get(i).getName());
            row1.createCell(2).setCellValue(users.get(i).getSex());
            HSSFCell cell = row1.createCell(3);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(users.get(i).getCreateTime());
        }
        workbook.write(new FileOutputStream(new File("d:/a.xlsx")));
    }

    @Test
    public void textImport() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("d:/a.xlsx")));

        HSSFSheet sheet = workbook.getSheet("user");
        System.out.println(sheet + "-----------" + sheet.getLastRowNum());
        ArrayList<User> list = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum() - 100; i++) {
            HSSFRow row = sheet.getRow(i);
            //HSSFCell cell = row.getCell(0);
            String id = row.getCell(0).getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
            String sex = row.getCell(2).getStringCellValue();
            Date date = row.getCell(3).getDateCellValue();
            User user = new User(id, null, null, name, sex, null, null, null, null, null, null, date, 1);
            list.add(user);
        }
        for (User user : list) {
            System.out.println(user);
        }

    }


    @Test
    public void queryChildMenu() {
        List<Menu> menus = menuService.queryAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu.getChildren());
        }
    }

    @Test
    public void LoginAdmin() {
        Admin zpark = adminService.LoginAdmin("zpark", "123456");
        System.out.println(zpark);
    }

    @Test
    public void queryAllBanner() {
        List<Banner> banners = bannerService.querryAllBanner();
        for (Banner banner : banners) {
            System.out.println(banner);
        }
    }

    @Test
    public void queryAllAlbum() {
        List<Album> albums = albumService.queryAllAlbum();
        System.out.println(albums);
    }

    @Test
    public void queryAllUser() {
        List<User> users = userService.queryAllUser();
        System.out.println(users);
    }

    @Test
    public void insertLogging() {
        Logging logging = new Logging(null, "adadsw", new Date(), "asdda", "dasdad");
        loggingService.insertOneLogging(logging);

    }
    @Test
    public void setChapterDao() {
        List<Chapter> chapters = chapterDao.selectOneChapter("1");
        System.out.println(chapters);
    }
}
