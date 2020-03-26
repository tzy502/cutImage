//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.*;
//import java.util.List;
//
//public class main {
//    public static void main(String[] args) {
//
//        ImageCuter imageCuter = new ImageCuter();
////        File file=new File("C:/Users/Administrator/Desktop/hbQ5-2ra1XkZ5g/表情包 (40).png");
//        File file=new File("D:/1.jpg");
//        try {
//            InputStream is=new FileInputStream(file);
//            BufferedImage bi= ImageIO.read(is);
//            int w=bi.getWidth();
//            int h=bi.getHeight();
//            if(w>h){
//                h=w;
//            }else{
//                w=h;
//            }
//            BufferedImage newbi = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
//            newbi.getGraphics().setColor(Color.WHITE);//设置笔刷白色
//            newbi.getGraphics().fillRect(0,0,w,h);//填充整个屏
//            newbi.getGraphics().drawImage(bi, 0, 0, bi.getWidth(), bi.getHeight(), null);
//            List<BufferedImage> result= imageCuter.cut(newbi,2,2);
//            for(int i=0;i<result.size();i++){
////                int w=result.get(i).
//                int rw=result.get(i).getWidth();
//                if(rw<32){
//                    rw=32;
//                }
//                int rh=result.get(i).getHeight();
//                if(rh<32){
//                    rh=32;
//                }
//                if(rw>rh){
//                    rh=rw;
//                }else{
//                    rw=rh;
//                }
//
//                BufferedImage out = new BufferedImage(rw, rh, BufferedImage.TYPE_INT_BGR);
//                out.getGraphics().setColor(Color.WHITE);//设置笔刷白色
//                out.getGraphics().fillRect(0,0,rw,rh);//填充整个屏
//                out.getGraphics().drawImage(result.get(i), 0, 0, result.get(i).getWidth(), result.get(i).getHeight(), null);
//                ImageIO.write(out, "jpg", new File("D:/test/"+i+".jpg"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
////        for(int i=1;i<=79;i++){
////            ImageCuter imageCuter = new ImageCuter();
////            File file=new File("C:/Users/Administrator/Desktop/hbQ5-2ra1XkZ5g/表情包 ("+i+").png");
////            try {
////
////                InputStream is=new FileInputStream(file);
////                BufferedImage bi= ImageIO.read(is);
////                List<BufferedImage> result= imageCuter.cut(bi,2,2);
////                for(int j=0;j<result.size();j++){
////                    ImageIO.write(result.get(j), "png", new File("D:/test/表情包 ("+i+")_"+j+".png"));
////                }
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
//
//    }
//}
