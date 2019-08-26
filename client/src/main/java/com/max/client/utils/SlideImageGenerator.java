package com.max.client.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class SlideImageGenerator {

    private static String basePicturePath = "/opt/global/appconfig/slideimage/";
    private static String[] pictures =
            {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png"
                    , "8.png", "9.png", "10.png", "11.png", "12.png"};
    private static String blackPicture = basePicturePath + "black.jpg";

    public static final int IMG_WEIGHT = 672;
    public static final int IMG_HEIGH = 210;
    public static final int SMALL_WEIGHT = 100;
    public static final int SMALL_HEIGH = 100;

    public static void main(String[] args) throws IOException {
        System.out.println(Math.abs(76 - SlideImageGenerator.percentX(163)));
        SlideImageGenerator.cut("e://picture/rsz_1.jpg", new FileOutputStream(new
                File("c://picture/1_cut.jpg")));
        SlideImageGenerator.cut("e://picture/rsz_2.jpg", new FileOutputStream(new
                File("c://picture/2_cut.jpg")));
        SlideImageGenerator.cut("e://picture/rsz_3.jpg", new FileOutputStream(new
                File("c://picture/3_cut.jpg")));
        SlideImageGenerator.cut("e://picture/rsz_4.jpg", new FileOutputStream(new
                File("c://picture/4_cut.jpg")));
        SlideImageGenerator.cut("e://picture/rsz_5.jpg", new FileOutputStream(new
                File("c://picture/5_cut.jpg")));
    }

    public final static ByteArrayOutputStream cut(String srcImageFile, int x, int y)
            throws IOException {
        // 讀取源圖像
        BufferedImage bi = ImageIO.read(new File(srcImageFile));
        int srcHeight = bi.getHeight(); // 源圖寬度
        int srcWidth = bi.getWidth(); // 源圖高度
        Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
        // 四個参數分別为圖像起點坐標和寬高
        // 即: CropImageFilter(int x,int y,int width,int height)
        ImageFilter cropFilter = new CropImageFilter(x, y, SMALL_WEIGHT, SMALL_HEIGH);
        Image img = Toolkit.getDefaultToolkit()
                .createImage(new FilteredImageSource(image.getSource(), cropFilter));
        BufferedImage tag = new BufferedImage(SMALL_WEIGHT, SMALL_HEIGH, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.drawImage(img, 0, 0, SMALL_WEIGHT, SMALL_HEIGH, null); // 繪制切割後的圖
        g.dispose();
        // 輸出为文件
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(tag, "JPEG", stream);
        return stream;
    }

    public final static int randomX() throws IOException {
        Random ran = new Random();
        return (ran.nextInt(IMG_WEIGHT - SMALL_WEIGHT - 20 * 2) + 20);
    }

    public final static int randomY() throws IOException {
        Random ran = new Random();
        return (ran.nextInt(IMG_HEIGH - SMALL_HEIGH - 10 * 2) + 10);
    }

    public final static int percentY(int y) throws IOException {
        double yd = new Double(y);
        return (int) Math.round((yd / IMG_HEIGH) * 100);
    }

    public final static int percentX(int x) throws IOException {
        double yd = new Double(x);
        return (int) Math.round((yd / IMG_WEIGHT) * 100);
    }

    private final static void cut(String srcImageFile, FileOutputStream fileOutputStream)
            throws IOException {
        // 讀取源圖像
        BufferedImage bi = ImageIO.read(new File(srcImageFile));
        int srcHeight = bi.getHeight(); // 源圖寬度
        int srcWidth = bi.getWidth(); // 源圖高度
        Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);

        int x = (srcWidth - IMG_WEIGHT) / 2;
        int y = (srcHeight - IMG_HEIGH) / 2;
        // 四個参數分別为圖像起點坐標和寬高
        // 即: CropImageFilter(int x,int y,int width,int height)
        ImageFilter cropFilter = new CropImageFilter(x, y, IMG_WEIGHT, IMG_HEIGH);
        Image img = Toolkit.getDefaultToolkit()
                .createImage(new FilteredImageSource(image.getSource(), cropFilter));
        BufferedImage tag = new BufferedImage(IMG_WEIGHT, IMG_HEIGH, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.drawImage(img, 0, 0, IMG_WEIGHT, IMG_HEIGH, null); // 繪制切割後的圖
        g.dispose();
        // 輸出为文件
        ImageIO.write(tag, "JPEG", fileOutputStream);
        fileOutputStream.close();
    }

    public static void generateBigImage(int x, int y, ServletOutputStream outputStream)
            throws IOException {
        String srcImageFile = getSrcImageFile(x, y);
        File img = new File(srcImageFile);
        Image src = ImageIO.read(img);
        int wideth = src.getWidth(null);
        int height = src.getHeight(null);
        BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.drawImage(src, 0, 0, wideth, height, null);
        // 水印文件
        Image src_biao = ImageIO.read(new File(blackPicture));
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, (float) 0.6));
        g.drawImage(src_biao, x, y, SMALL_WEIGHT, SMALL_HEIGH, null);
        // 水印文件結束
        g.dispose();
        ImageIO.write((BufferedImage) image, "JPEG", outputStream);
    }

    private static String getSrcImageFile(int x, int y) {
        return basePicturePath + pictures[((x + y) % pictures.length)];
    }

    public static void generateSmallImage(int x, int y, ServletOutputStream outputStream)
            throws IOException {
        // 讀取源圖像
        String srcImageFile = getSrcImageFile(x, y);
        BufferedImage bi = ImageIO.read(new File(srcImageFile));
        int srcHeight = bi.getHeight(); // 源圖寬度
        int srcWidth = bi.getWidth(); // 源圖高度
        Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
        // 四個参數分別为圖像起點坐標和寬高
        // 即: CropImageFilter(int x,int y,int width,int height)
        ImageFilter cropFilter = new CropImageFilter(x, y, SMALL_WEIGHT, SMALL_HEIGH);
        Image img = Toolkit.getDefaultToolkit()
                .createImage(new FilteredImageSource(image.getSource(), cropFilter));
        BufferedImage tag = new BufferedImage(SMALL_WEIGHT, SMALL_HEIGH, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.drawImage(img, 0, 0, SMALL_WEIGHT, SMALL_HEIGH, null); // 繪制切割後的圖
        g.dispose();
        // 輸出为文件
        ImageIO.write(tag, "JPEG", outputStream);
    }

}
