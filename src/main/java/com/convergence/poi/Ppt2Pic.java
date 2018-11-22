package com.convergence.poi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Ppt2Pic {

  private static final Logger logger = LoggerFactory.getLogger(Ppt2Pic.class);
  private static final String FULL_FILE_PATH = "E://123.pptx";
  private static final String PIC_PATH = "E://ppt2pic";

  public static Boolean ppt2Pic(String pptFilePath,String imgFilePath){
    List<String> list= new ArrayList<>();
    if (StringUtils.isBlank(pptFilePath)) {
      return false;
    }
    if (StringUtils.isBlank(imgFilePath)) {
      return false;
    }
    File pptFile =new File(pptFilePath);
    File imgFile = new File(imgFilePath);
    FileInputStream is = null ;
    try {
        is = new FileInputStream(pptFile);
        XMLSlideShow xmlSlideShow = new XMLSlideShow(is);
        is.close();
        // 获取大小
        Dimension pgsize = xmlSlideShow.getPageSize();
        // 获取幻灯片
        List<XSLFSlide> slides = xmlSlideShow.getSlides();
        for (int i = 0 ; i < slides.size() ; i++) {
            // 解决乱码问题
            List<XSLFShape> shapes = slides.get(i).getShapes();
            for (XSLFShape shape : shapes) {
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape sh = (XSLFTextShape) shape;
                    List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();
                    for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
                        List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
                        for (XSLFTextRun xslfTextRun : textRuns) {
                            xslfTextRun.setFontFamily("宋体");
                        }
                    }
                }
            }
            //根据幻灯片大小生成图片
            BufferedImage img = new BufferedImage(pgsize.width,pgsize.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = img.createGraphics();
            graphics.setPaint(Color.white);
            graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,pgsize.height));
            // 最核心的代码
            slides.get(i).draw(graphics);
            //图片将要存放的路径
            String absolutePath = imgFile.getAbsolutePath()+"/"+ (i + 1) + ".jpeg";
            File jpegFile = new File(absolutePath);
            // 图片路径存放
            list.add((i + 1) + ".jpeg");
            //如果图片存在，则不再生成
            if (jpegFile.exists()) {
                continue;
            }
            // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
            FileOutputStream out = new FileOutputStream(jpegFile);
            // 写入到图片中去
            ImageIO.write(img, "jpg", out);
            out.close();
        }
        logger.error("PPT转换成图片 成功！");
        return true;
    }
    catch (Exception e) {
      logger.error("PPT转换成图片 发生异常！", e);
    }
    return false;
}

  public static void main(String[] args) {
    ppt2Pic(FULL_FILE_PATH, PIC_PATH);
  }
}
