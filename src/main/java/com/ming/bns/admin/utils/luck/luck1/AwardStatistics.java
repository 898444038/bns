package com.ming.bns.admin.utils.luck.luck1;

import com.ming.bns.admin.utils.consoletable.ConsoleTable;
import com.ming.bns.admin.utils.consoletable.enums.Align;
import com.ming.bns.admin.utils.consoletable.table.Cell;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AwardStatistics {

    public Map<String,List<Award>> awardMap = new HashMap<>();
    public List<String> recordList = new ArrayList<>();

    public void initAward(List<Award> awardList) {
        for (Award award : awardList){
            awardMap.put(award.getName(),new ArrayList<>());
        }
    }

    public void addAward(Award award) {
        String key = award.getName();
        List<Award> awardList = awardMap.get(key);
        awardList.add(award);
    }

    public void statisticsHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>").append("\r\n");
        sb.append("<html>").append("\r\n");
        sb.append("<head>").append("\r\n");
        sb.append("\t").append("<meta charset='utf-8'>").append("\r\n");
        sb.append("\t").append("<title></title>").append("\r\n");
        sb.append("\t").append("<style type='text/css'>").append("\r\n");
        sb.append("\t\t").append("body {font-family: arial;}").append("\r\n");
        sb.append("\t\t").append("table{border: 1px solid #ccc;width: 80%;margin:0;padding:0;border-collapse: collapse;border-spacing: 0;margin: 0 auto;}").append("\r\n");
        sb.append("\t\t").append("table tr {border: 1px solid #ddd;}").append("\r\n");
        sb.append("\t\t").append("td {word-break:break-all; word-wrap:break-all;}").append("\r\n");
        sb.append("\t\t").append("table th, table td {padding: 10px;text-align: center;}").append("\r\n");
        sb.append("\t\t").append("table th {text-transform: uppercase;font-size: 14px;letter-spacing: 1px;}").append("\r\n");
        sb.append("\t\t").append("@media screen and (max-width: 600px) {").append("\r\n");
        sb.append("\t\t\t").append("table {border: 0;}").append("\r\n");
        sb.append("\t\t\t").append("table thead {display: none;}").append("\r\n");
        sb.append("\t\t\t").append("table tr {margin-bottom: 10px;display: block;border-bottom: 2px solid #ddd;}").append("\r\n");
        sb.append("\t\t\t").append("table td {display: block;text-align: right;font-size: 13px;border-bottom: 1px dotted #ccc;}").append("\r\n");
        sb.append("\t\t\t").append("table td:last-child {border-bottom: 0;}").append("\r\n");
        sb.append("\t\t\t").append("table td:before {content: attr(data-label);float: left;text-transform: uppercase;font-weight: bold;}").append("\r\n");
        sb.append("\t\t").append("}").append("\r\n");
        sb.append("\t\t").append(".note{max-width: 80%; margin: 0 auto;}").append("\r\n");
        sb.append("\t").append("</style>").append("\r\n");
        sb.append("</head>").append("\r\n");
        sb.append("<body>").append("\r\n");

        sb.append("\t").append("<table>").append("\r\n");
        sb.append("\t\t").append("<thead>").append("\r\n");
        sb.append("\t\t\t").append("<tr>").append("\r\n");
        sb.append("\t\t\t\t").append("<th style='width:100px'>").append("名称").append("</th>").append("\r\n");
        sb.append("\t\t\t\t").append("<th style='width:40px'>").append("权重").append("</th>").append("\r\n");
        sb.append("\t\t\t\t").append("<th style='width:40px'>").append("数量").append("</th>").append("\r\n");
        sb.append("\t\t\t\t").append("<th>").append("位置").append("</th>").append("\r\n");
        sb.append("\t\t\t").append("</tr>").append("\r\n");
        sb.append("\t\t").append("</thead>").append("\r\n");

        List<Award> awardList = null;
        for (Map.Entry<String,List<Award>> entry : awardMap.entrySet()) {
            awardList = entry.getValue();
            int size = awardList.size();
            String indexs = "";
            int weight = 0;
            for (Award award : awardList){
                weight = award.getWeight();
                indexs = award.getIndex();
            }
            sb.append("\t\t").append("<tbody>").append("\r\n");
            sb.append("\t\t\t").append("<tr>").append("\r\n");
            sb.append("\t\t\t\t").append("<td data-label='名称'>").append(entry.getKey()).append("</td>").append("\r\n");
            sb.append("\t\t\t\t").append("<td data-label='权重'>").append(weight+"").append("</td>").append("\r\n");
            sb.append("\t\t\t\t").append("<td data-label='数量'>").append(size+"").append("</td>").append("\r\n");
            sb.append("\t\t\t\t").append("<td data-label='位置'>").append(indexs).append("</td>").append("\r\n");
            sb.append("\t\t\t").append("</tr>").append("\r\n");
            sb.append("\t\t").append("</tbody>").append("\r\n");
        }

        sb.append("\t").append("</table>").append("\r\n");

        sb.append("\t").append("<ul>").append("\r\n");
        for (String record : recordList){
            sb.append("\t\t").append("<li>").append(record).append("</li>").append("\r\n");
        }
        sb.append("\t").append("</ul>").append("\r\n");



        sb.append("</body>").append("\r\n");
        sb.append("</html>").append("\r\n");
        System.out.println(sb.toString());
        generateFile("C:\\Users\\Administrator\\Desktop\\luck.html",sb.toString());
    }

    //统计
    public void statistics() {
        List<Award> awardList = null;

        List<Cell> header = new ArrayList<Cell>(){{
            add(new Cell("名称"));
            add(new Cell("数量"));
            add(new Cell("第几次"));
        }};
        List<List<Cell>> body = new ArrayList<List<Cell>>();

        for (Map.Entry<String,List<Award>> entry : awardMap.entrySet()){
            awardList = entry.getValue();
            int size = awardList.size();
            String indexs = "";
            for (Award award : awardList){
                indexs = award.getIndex();
            }
            String finalIndexs = indexs;
            body.add(new ArrayList<Cell>(){{
                add(new Cell(entry.getKey()));
                add(new Cell(Align.LEFT,size+""));
                add(new Cell(Align.LEFT, finalIndexs));
            }});
        }
        new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).build().print();

        System.out.println("");

    }

    public static void generateFile(String path,String content){
        File file = new File(path);
        boolean flag = createFile(file);
        if (flag) {
            writeFile(file,content);
        }else{
            writeFile(file,content);
        }
    }

    private static void writeFile(File file,String content){
        try (FileWriter writer = new FileWriter(file); BufferedWriter out = new BufferedWriter(writer)){
            out.write(content);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean createFile(File file){
        boolean flag = false;
        try {
            if(!file.exists()){
                file.createNewFile();
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public void addAwardRecord(String record) {
        recordList.add(record);
    }
}
