package own_test;
import java.util.*;
public class DeleteChars {



        public static void main(String [] args){
            Scanner sc=new Scanner(System.in);
            String str1= sc.nextLine();
            String str2= sc.nextLine();
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0; i<str2.length();i++){
                if(map.get(str2.charAt(i))==null){
                    map.put(str2.charAt(i),1);
                }else{
                    map.put(str2.charAt(i),map.get(str2.charAt(i))+1);
                }
            }
            String ret="";
            for(int j=0;j<str1.length();j++){
                if(map.get(str1.charAt(j))==null){
                    ret+=str1.charAt(j);
                }
            }
            System.out.println(ret);
        }



}
