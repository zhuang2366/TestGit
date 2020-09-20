package test;



import java.util.concurrent.*;  

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class map {
    static volatile Integer c = 0;//成功数
    static volatile Integer fail = 0;//失败数量

    public static void main(String[] args) throws Exception {
        String link = "http://online3.map.bdimg.com/onlinelabel/?qt=tile&x={x}&y={y}&z={z}&styles=pl&udt=20170712&scaler=1&p=1";
        int z = 19;//层级
        int xmin = 103514;//x最小值
        int xmax = 104292;//x最大值
        int ymin = 29400;//y最小值
        int ymax = 30700;//y最大值
            for (int i = xmin; i <= xmax; i++) {   //循环X
                for (int j = ymin; j <= ymax; j++) {    //循环Y
                    try {

                        URL url = new URL(link.replace("{x}", i + "").replace("{y}", j + "").replace("{z}", z + ""));
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setConnectTimeout(100);
                        conn.connect();
                        InputStream in = conn.getInputStream();
                        File dir = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        File file = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i + "/" + j + ".jpg");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        OutputStream out = new FileOutputStream(file);
                        byte[] bytes = new byte[1024 * 20];
                        int len = 0;
                        while ((len = in.read(bytes)) != -1) {
                            out.write(bytes, 0, len);
                        }
                        out.close();
                        in.close();
                        //System.out.println("已成功下载:" + z + "_" + i + "_" + j + ".jpg");
                        c++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        fail++;
                    }

                }    //循环Y结束
            }   //循环X结束
        Thread.sleep(1000);
        System.out.println("共下载:   " + c + "   张");
        System.out.println("失败:   " + fail + "   张");
    }
}