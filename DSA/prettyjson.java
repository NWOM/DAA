import java.util.ArrayList;
import java.util.Arrays;

/**You are given a string 'STR' representing JSON object. Return an array of strings denoting JSON objects with proper indentation.

        Rules for proper indentation:
        1. Every inner brace should increase one indentation to the following lines.
2. Every close brace should decrease one indentation to the same line and the following lines.
3. Every ‘,’ will mean a separate line.
4. The indents can be increased with an additional 4 spaces or ‘/t’.
**/

public class prettyjson {
   public static ArrayList<String> prettyJSON(String str){
       StringBuilder sb=new StringBuilder();
       int spaces=0;
       for(char ch:str.toCharArray()){
           if(ch=='[' || ch=='{'){
               addIndentation(sb,spaces);
               spaces++;
               sb.append(ch);
               addIndentation(sb,spaces);
           }else{
               sb.append(ch);
               if(ch==','){
                   addIndentation(sb,spaces);
               }
           }
       }
       String array[]=sb.toString().trim().split("\n");
       return new ArrayList<>(Arrays.asList(array));
   }
   public static void addIndentation(StringBuilder sb,int spaces){
       if(sb.length()>0){
           sb.append("\n");
       }
       while(spaces>0){
           sb.append(" ");
           spaces--;
       }
   }
}
