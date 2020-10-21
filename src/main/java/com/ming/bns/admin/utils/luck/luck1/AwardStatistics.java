package com.ming.bns.admin.utils.luck.luck1;

import com.ming.bns.admin.utils.consoletable.ConsoleTable;
import com.ming.bns.admin.utils.consoletable.enums.Align;
import com.ming.bns.admin.utils.consoletable.table.Cell;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AwardStatistics {

    public Map<Integer,Map<String,List<Award>>> awardMap = new LinkedHashMap<>();
    public Map<Integer,List<String>> recordMap = new LinkedHashMap<>();
    public List<Award> awardList = new ArrayList<>();

    public void initAward(Integer group,List<Award> awardList) {
        this.awardList = awardList;
        Map<String,List<Award>> groupMap = awardMap.get(group);
        if(groupMap == null){
            groupMap = new LinkedHashMap<>();
        }
        for (Award award : awardList){
            groupMap.put(award.getName(),new ArrayList<>());
        }
        awardMap.put(group,groupMap);
    }

    public void addAward(int group,Award award) {
        Map<String,List<Award>> groupMap = awardMap.get(group);
        String key = award.getName();
        List<Award> awardList = groupMap.get(key);
        awardList.add(award);
    }

    public void statisticsHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>").append("\r\n");
        sb.append("<html>").append("\r\n");
        sb.append("<head>").append("\r\n");
        sb.append("\t").append("<meta charset='utf-8'>").append("\r\n");
        sb.append("\t").append("<title></title>").append("\r\n");
        sb.append("\t").append("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css'/>").append("\r\n");
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
        sb.append("\t\t").append("li{display:none;}").append("\r\n");
        sb.append("\t\t").append(".duration-1 {--animate-duration: 0.4s;}").append("\r\n");
        sb.append("\t\t").append(".group-span{width: 80%;padding: 0;margin: 0 auto;display: inherit;}").append("\r\n");
        sb.append("\t").append("</style>").append("\r\n");
        sb.append("<script src='https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js'></script>").append("\r\n");
        sb.append("</head>").append("\r\n");
        sb.append("<body>").append("\r\n");

        for (Map.Entry<Integer,Map<String,List<Award>>> group : awardMap.entrySet()) {
            sb.append("\t").append("<span class='group-span'>第"+group.getKey()+"轮</span>").append("\r\n");
            sb.append("\t").append("<table>").append("\r\n");
            sb.append("\t\t").append("<thead>").append("\r\n");
            sb.append("\t\t\t").append("<tr>").append("\r\n");
            sb.append("\t\t\t\t").append("<th style='width:130px'>").append("名称").append("</th>").append("\r\n");
            sb.append("\t\t\t\t").append("<th style='width:50px'>").append("权重").append("</th>").append("\r\n");
            sb.append("\t\t\t\t").append("<th style='width:50px'>").append("数量").append("</th>").append("\r\n");
            sb.append("\t\t\t\t").append("<th>").append("位置").append("</th>").append("\r\n");
            sb.append("\t\t\t").append("</tr>").append("\r\n");
            sb.append("\t\t").append("</thead>").append("\r\n");
            List<Award> awardLists = null;
            Map<String,List<Award>> map = group.getValue();
            for (Map.Entry<String,List<Award>> entry : map.entrySet()) {
                awardLists = entry.getValue();
                int size = awardLists.size();
                int weight = 0;
                for (Award award : awardList){
                    if(entry.getKey().equals(award.getName())){
                        weight = award.getWeight();
                        break;
                    }
                }
                String indexs = "";
                List<String> indexList = new ArrayList<>();
                for (Award award : awardLists){
                    indexList.add(award.getIndex());
                }
                indexs = StringUtils.join(indexList,",");

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
        }

        sb.append("\t").append("<ul>").append("\r\n");
        int i = 1;
        /*for (String record : recordList){
            sb.append("\t\t").append("<li>").append(record).append("</li>").append("\r\n");
            i++;
        }*/
        sb.append("\t").append("</ul>").append("\r\n");

        sb.append("<script>").append("\r\n");
        sb.append("$(function() {").append("\r\n");

        sb.append("\t").append("animate_show('li:eq(0)', 'fadeInUp');").append("\r\n");
        /*for (int j=0;j<recordList.size();j++){
            sb.append("\t").append("animate_delay('li:eq("+j+")', 'li:eq("+(j+1)+")', 'fadeInUp');").append("\r\n");
            i++;
        }*/

        sb.append("\t").append("function animate_show(element, animate) {").append("\r\n");
        sb.append("\t\t").append("$(element).show().addClass('animate__animated duration-1 animate__' + animate);").append("\r\n");
        sb.append("\t").append("}").append("\r\n");
        sb.append("\t").append("function animate_delay(element1, element2, animate) {").append("\r\n");
        sb.append("\t\t").append("$(element1).one('webkitAnimationEnd mozAnimationEnd oAnimationEnd animationEnd', function() {animate_show(element2, animate);});").append("\r\n");
        sb.append("\t").append("}").append("\r\n");
        sb.append("});").append("\r\n");
        sb.append("</script>").append("\r\n");

        sb.append("</body>").append("\r\n");
        sb.append("</html>").append("\r\n");
        System.out.println(sb.toString());
        generateFile("C:\\Users\\Administrator\\Desktop\\luck.html",sb.toString());
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

    public void addAwardRecord(int group,String record) {
        List<String> recordList = recordMap.get(group);
        if(recordList == null){
            recordList = new ArrayList<>();
        }
        recordList.add(record);
        recordMap.put(group,recordList);
    }
}
