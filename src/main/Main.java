package main;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by emakarov on 28.01.2016.
 */

public class  Main {
    public static void main(String[] args) {
        // put your code here
        try {
            String temp;

            FileReader fr = new FileReader("./test1.txt");
            FileWriter wr = new FileWriter("./test2.txt");

            BufferedWriter  bw = new BufferedWriter(wr);

            BufferedReader br = new BufferedReader(fr);

            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            //String[] compare = {",",":","."," ","-","!","?",";","\t"};
            //int it=0;
            try {
                while ((temp = br.readLine()) != null) {
                    int pos = temp.indexOf(":");
                    String line = temp.substring(0, pos);
                    String current = "";
                    temp = temp.substring(pos + 1, temp.length());

                    String pattern = "[^A-Za-zА-Яа-я_0-9]+";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(temp);
                    ArrayList<String> razd = new ArrayList<>();

                    while(m.find()) {
                        razd.add(temp.substring(m.start(), m.end()));
                    }

                    while (!temp.isEmpty()) {
                        if (razd.size()>0){
                        for (int i=0;i < razd.size();i++){
                            int pos1 = temp.indexOf(razd.get(i));
                            if (pos1 < 0 && temp.length()>0) {
                                current = temp;
                                System.out.println(current + "#" + line + "\t" + "1" + "\n");
                                bw.write(current + "#" + line + "\t" + "1" + "\n");
                                bw.flush();
                                temp = "";
                            }
                            else if (pos1 == 0) {temp=temp.substring(razd.get(i).length(),temp.length());}
                            else if (pos1 >= 1){
                                current = temp.substring(0,pos1);
                                temp=temp.substring(pos1+razd.get(i).length(),temp.length());
                                System.out.println(current + "#" + line + "\t" + "1" + "\n");
                                bw.write(current + "#" + line + "\t" + "1" + "\n");
                                bw.flush();
                            }

                            else temp="";
                        }
                        } else {
                            current = temp;
                            System.out.println(current + "#" + line + "\t" + "1" + "\n");
                            bw.write(current + "#" + line + "\t" + "1" + "\n");
                            bw.flush();
                            temp="";
                        }

                        }
                        /*pos = temp.indexOf(" ");
                        if (pos > 0) {
                            current = temp.substring(0, pos);
                            if (!current.contains(",") && !current.contains(":") && !current.contains(".") && !current.contains(" ")
                                    && !current.contains("-") && !current.contains("!") && !current.contains("?") && !current.contains(";") &&
                                    !current.contains("\t")) {
                                temp = temp.substring(pos + 1, temp.length());
                            } else {

                                    for (int d = 0;d<9;d++){
                                        if (current.indexOf(compare[d])> 0 && (current.indexOf(compare[d]) != current.length()-1)){
                                            current = current.substring(0,current.indexOf(compare[d]))+ current.substring(current.indexOf(compare[d])+1,current.length());
                                        } else {
                                            if (current.indexOf(compare[d]) == 0) {current = current.substring(1,current.length());}
                                            if (current.indexOf(compare[d]) == current.length()-1) {current = current.substring(0,current.length()-1);}
                                        }
                                    }
                                    temp = temp.substring(pos + 1, temp.length());
                                }
                            } else {
                            if (temp.contains(",") || temp.contains(":") || temp.contains(".") || temp.contains(" ") || temp.contains("-") ||
                                     temp.contains("!") || temp.contains("?") || temp.contains(";") || temp.contains("\t")) {
                                for (int d = 0;d<9;d++){
                                    if (temp.indexOf(compare[d])> 0 && !temp.endsWith(compare[d])){
                                        current = temp.substring(0,temp.indexOf(compare[d]))+ temp.substring(current.indexOf(compare[d])+1,temp.length());
                                    } else {
                                        if (temp.indexOf(compare[d]) == 0) {current = temp.substring(1,temp.length());}
                                        if (temp.indexOf(compare[d]) == current.length()-1) {current = temp.substring(0,temp.length()-1);}
                                    }

                                }
                                temp = "";
                            } else { current=temp; temp ="";}
                        } */




                    }


            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

