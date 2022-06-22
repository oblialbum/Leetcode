package com.fengtin.LeetCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class temp {
    /**
     * 该代码用来判断哪些pdf文件没有被处理。
     */
    String pathPdf = "D:\\DataSet\\document2slides-main\\sciduet-build\\data\\papers";
    String pathXml = "D:\\DataSet\\document2slides-main\\sciduet-build\\teidir";
    List<String> xmlFile = new ArrayList<>();
    List<String> pdfFile = new ArrayList<>();
    List<String> unduplicationFile = new ArrayList<>();

    private void getPdf(){
        File file = new File(pathPdf);
        if(file.isDirectory()){
            File[] pdfFiles = file.listFiles();
            for (File pdf: pdfFiles
            ) {
                String num = pdf.getName();
                int index = num.indexOf('.');
                String ans = num.substring(0,index);
                pdfFile.add(ans);
            }
        }
        Collections.sort(pdfFile);
    }
    private void getXml(){
        File file = new File(pathXml);
        if(file.isDirectory()){
            File[] xmlFiles = file.listFiles();
            for (File xml: xmlFiles
                 ) {
                String num = xml.getName();
                int index = num.indexOf('.');
                String ans = num.substring(0,index);
                xmlFile.add(ans);
            }
        }
        Collections.sort(xmlFile);
    }

    private void getUnduplication(){
        for (String s: pdfFile
             ) {
            if(!xmlFile.contains(s)){
                unduplicationFile.add(s);
            }
        }
        return;
    }

    private void moveFile(){
        String finalPath = "D:\\DataSet\\document2slides-main\\sciduet-build\\data\\unprocessedPapers";
        File file ;
        for (String subPath: unduplicationFile
             ) {
            subPath +=".pdf";
            String path = pathPdf+"\\"+subPath;
            file = new File(path);
            file.renameTo(new File(finalPath+"\\"+subPath));
        }
    }

    int count = 0;
    private void dfs(String filePath){
        File file = new File(filePath);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File temp: files
                 ) {
                dfs(temp.getAbsolutePath());
            }
        }
        else{
            String name = file.getName();
            if(name.equals("slide.clean_tika.xml")){
                System.out.println(name+":delete successful" + (count++));
                file.delete();
                return;
            }
        }
    }

    public static void main(String[] args){
        temp temp = new temp();
        temp.getXml();
        temp.getPdf();
        temp.getUnduplication();
        temp.moveFile();

    }
}
