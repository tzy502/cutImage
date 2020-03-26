import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ui {
    private JPanel panel;
    private JButton 生成Button;
    private JTextField pxTxt;
    private JTextField address;
    private JButton 生成;
    private JButton 选择;
    private JTextField out;
    private JTextField length;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ui");
        frame.setContentPane(new ui().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ui() {

        生成Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageCuter imageCuter = new ImageCuter();
//        File file=new File("C:/Users/Administrator/Desktop/hbQ5-2ra1XkZ5g/表情包 (40).png");
                if(address.getText()==null||address.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "请选择图片", "系统错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(out.getText()==null||address.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "请选择导出位置", "系统错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String outString=out.getText().replace("\\","/");
                File file=new File(address.getText());
                try {
                    InputStream is=new FileInputStream(file);
                    BufferedImage bi= ImageIO.read(is);
                    String suffix = address.getText().substring(address.getText().lastIndexOf(".") + 1);
                    if(suffix==null||suffix.equals("")){
                        JOptionPane.showMessageDialog(null, "请选择图片", "系统错误", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!(suffix.equals("jpg")||(suffix.equals("png")))){
                        JOptionPane.showMessageDialog(null, "请选择图片", "系统错误", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int w=bi.getWidth();
                    int h=bi.getHeight();
                    if(w>h){
                        h=w;
                    }else{
                        w=h;
                    }
                    BufferedImage newbi = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
                    newbi.getGraphics().setColor(Color.WHITE);//设置笔刷白色
                    newbi.getGraphics().fillRect(0,0,w,h);//填充整个屏
                    newbi.getGraphics().drawImage(bi, 0, 0, bi.getWidth(), bi.getHeight(), null);

                    List<BufferedImage> result= new ArrayList<>();
                    if(length.getText()==null||length.getText().equals("")){
                        if(pxTxt.getText()==null||pxTxt.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "长度像素请填写一个", "系统错误", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int px= Integer.parseInt(pxTxt.getText());
                        result=imageCuter.cut(newbi,px);
                    }else{
                        int kuai= Integer.parseInt(length.getText())-1;
                        result=imageCuter.cut(newbi,kuai,kuai);
                    }
//                    int a=1/0;
                    for(int i=0;i<result.size();i++){
//                int w=result.get(i).
                        if(result.size()>100){
                            break;
                        }
                        int rw=result.get(i).getWidth();
                        if(rw<32){
                            rw=32;
                        }
                        int rh=result.get(i).getHeight();
                        if(rh<32){
                            rh=32;
                        }
                        if(rw>rh){
                            rh=rw;
                        }else{
                            rw=rh;
                        }

                        BufferedImage outimg = new BufferedImage(rw, rh, BufferedImage.TYPE_INT_BGR);
                        outimg.getGraphics().setColor(Color.WHITE);//设置笔刷白色
                        outimg.getGraphics().fillRect(0,0,rw,rh);//填充整个屏
                        outimg.getGraphics().drawImage(result.get(i), 0, 0, result.get(i).getWidth(), result.get(i).getHeight(), null);
                       String outfialString=outString+"/"+i+"."+suffix;
                        ImageIO.write(outimg, suffix, new File(outfialString));
                    }
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "系统错误", "系统错误", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        });
        选择.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = null;
                JFileChooser fileChooser = new JFileChooser();
                FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句
                fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
                fileChooser.setDialogTitle("请选择要上传的文件...");
                fileChooser.setApproveButtonText("确定");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = 0;
                result = fileChooser.showOpenDialog(null);
                if (JFileChooser.APPROVE_OPTION == result) {
                    path=fileChooser.getSelectedFile().getPath();
                    address.setText(path);
                }
            }
        });
        生成.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = null;
                String path = null;
                JFileChooser fileChooser = new JFileChooser();
                FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句
                fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
                fileChooser.setDialogTitle("请选择文件夹...");
                fileChooser.setApproveButtonText("确定");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileSelectionMode(1);
                int result = 0;
                result = fileChooser.showOpenDialog(null);
                if (JFileChooser.APPROVE_OPTION == result) {
                    path=fileChooser.getSelectedFile().getPath();
                    out.setText(path);
                }
            }
        });
    }
}
