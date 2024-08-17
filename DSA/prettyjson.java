import java.util.ArrayList;

/**You are given a string 'STR' representing JSON object. Return an array of strings denoting JSON objects with proper indentation.

        Rules for proper indentation:
        1. Every inner brace should increase one indentation to the following lines.
2. Every close brace should decrease one indentation to the same line and the following lines.
3. Every ‘,’ will mean a separate line.
4. The indents can be increased with an additional 4 spaces or ‘/t’.
**/

public class prettyjson {
    public static ArrayList<String> prettyJSON(String str) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int space = 0;
        int n = str.length();
        boolean flag = true;
        boolean gap = false;
        int size = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            size = ans.size() > 0 ? ans.size() - 1 : 0;

            if (c == '{' || c == '[') {
                if (size > 0 && (ans.get(size).trim().equals("{") || ans.get(size).trim().equals("["))){
                    /* if ',' is this present is previous arraylist index then dont add a gap bet brackets */
                    if (ans.get(size).trim().contains(","))
                        gap = true;
                }

                if (sb.length() > 0) {
                    ans.add(getIndent(space) + sb.toString());
                    sb.setLength(0);
                }
                sb.append(c);
                /* if nothing is there then add a gap */
                if (gap) {
                    ans.add("\n" + getIndent(space) + sb.toString());
                    gap = false;
                } else {
                    ans.add(getIndent(space) + sb.toString());
                }
                space++;
                sb.setLength(0);
            } else if (c == '}' || c == ']') {
                if (ans.get(size).trim().equals("{") || ans.get(size).trim().equals("[")) {
                    gap = true;
                }
                if (sb.length() > 0) {
                    ans.add(getIndent(space) + sb.toString());
                    sb.setLength(0);
                }
                sb.append(c);
                /* if next char is ',' then add this character in same index with ']' or '}' */
                if (i + 1 < n && str.charAt(i + 1) == ',') {
                    sb.append(",");
                    flag = false;
                }
                space--;
                /* if gap=true then add a gap between brackets */
                if (gap) {
                    ans.add("\n" + getIndent(space) + sb.toString());
                } else {
                    ans.add(getIndent(space) + sb.toString());
                    gap = false;
                }
                sb.setLength(0);
            } else if (c == ',') {
                if (flag) {
                    sb.append(c);
                    ans.add(getIndent(space) + sb.toString());
                    sb.setLength(0);
                } else {
                    flag = true;
                }
            } else {
                sb.append(c);
            }
        }

        return ans;
    }

    private static String getIndent(int space) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < space; i++) {
            sb.append("\t");
        }

        return sb.toString();
    }
}
