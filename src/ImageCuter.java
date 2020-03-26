

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ImageCuter {

    public static List<BufferedImage> cut(BufferedImage image,int px){
//    ){
        List<BufferedImage> list = new ArrayList<>();
        int sWidth = image.getWidth(); // 图片宽度
        int sHeight = image.getHeight(); // 图片高度

        if (sWidth > 32 && sHeight > 32) {
            int cols = sWidth/px; // 横向切片总数
            int rows = sHeight/px; // 纵向切片总数
            int eWidth = sWidth%px; // 末端切片宽度
            int eHeight = sHeight%px;; // 末端切片高度
            if(eHeight!=0){
                rows++;
            }
            if(eWidth!=0){
                cols++;
            }

            BufferedImage subImage = null;
            int i=0;
            int j=0;

            for (i = 0; i <rows; i++) {
                for (j = 0; j <cols; j++) {
                    int x=j * px;
                    int y=i * px;
                    int w=getWidth(cols,j,eWidth,px,1);
                    int h=getHight(rows,i,eHeight,px,1);

                    subImage = image.getSubimage(x,y,w,h);
                    list.add(subImage);
                }
            }
        }
        return list;
    }
    public static List<BufferedImage> cut(BufferedImage image,int row,int col){
//    ){
        List<BufferedImage> list = new ArrayList<>();
        int sWidth = image.getWidth(); // 图片宽度
        int sHeight = image.getHeight(); // 图片高度

        if (sWidth > 32 && sHeight > 32) {
            int cols = col; // 横向切片总数
            int rows = row; // 纵向切片总数
            int eWidth = sWidth%(col*32); // 末端切片宽度
            int eHeight = sHeight%(row*32);; // 末端切片高度
            if(eHeight==0){
                rows--;
            }
            if(eWidth==0){
                cols--;
            }
            int cutH=length(sHeight,row);
            int cutW=length(sWidth,col);

            if(cutH<cutW){
                cutH=cutW;
                if(cutH!=0){
                    eHeight=sHeight%cutH;
                }
            }else{
                cutW=cutH;
                if(cutW!=0){
                    eWidth=sHeight%cutW;
                }

            }


            BufferedImage subImage = null;
            int i=0;
            int j=0;

            for (i = 0; i <=rows; i++) {
                for (j = 0; j <=cols; j++) {
                    int x=j * cutW;
                    int y=i * cutH;
                    int w=getWidth(cols,j,eWidth,cutW);
                    int h=getHight(rows,i,eHeight,cutH);

                    subImage = image.getSubimage(x,y,w,h);
                    list.add(subImage);
                }
            }
        }
        return list;
    }
    public static int getWidth(int cols,int j,int eWidth,int cut,int isPx){
        if(j==(cols-1)&&eWidth!=0){
            return eWidth;
        }else{
            return cut;
        }
    }
    public static int getHight(int rows,int i,int eHeight,int cut,int isPx){
        if(i==(rows-1)&&eHeight!=0){
            return eHeight;
        }else{
            return cut;
        }
    }
    public static int getWidth(int cols,int j,int eWidth,int cut){
        if(j==(cols)&&eWidth!=0){
            return eWidth;
        }else{
            return cut;
        }
    }
    public static int getHight(int rows,int i,int eHeight,int cut){
        if(i==(rows)&&eHeight!=0){
            return eHeight;
        }else{
            return cut;
        }
    }
    //m长度 n几行/列
    public static int length(int m, int n) {
        int result = 0;
        n=n*32;
        int x=m%n;
        m=m-x;
        result=m/n;
        return result*32;
    }

}