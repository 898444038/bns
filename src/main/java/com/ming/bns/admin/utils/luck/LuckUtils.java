package com.ming.bns.admin.utils.luck;

public class LuckUtils {

    public static void main(String[] args) {
        luck1();
    }

    public static void luck1(){
        double n = 1000;
        double num = 0;
        double probablity = 0;
        double sum_probablity = 0;

        for (int i = 2; i <= n+1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println(factorial(i-1)+" | "+factorial(j)+" | "+factorial(i-1-j));
                probablity += factorial(i-1)/(factorial(j)*factorial(i-1-j))
                * (0.05*Math.pow(0.15,j) + 0.15*Math.pow(0.05,j)) * Math.pow(0.8,i-1-j);
            }
            sum_probablity += probablity;
            num += i*probablity;
            //System.out.println("第"+i+"次开箱成功的概率是："+probablity);
            probablity = 0;
        }

        System.out.println("总计概率："+sum_probablity);
        System.out.println("开箱成功的期望次数："+num);
    }

    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }else {
            return (n * factorial(n - 1));
        }
    }


    public static String addZeroForNumber(String str,int strLength){
        int strLen = str.length();
        if(strLen<strLength){
            while (strLen<strLength){
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);//左补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }
}
