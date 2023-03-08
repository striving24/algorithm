package string;

/**
 * @author 马祥
 * @Package string
 * @date 2023-02-23 22:59
 * @Copyright © 2024未来可期
 * 5、替换空格
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            }else
                sb.append(c);
        }
        return sb.toString();
    }
}
