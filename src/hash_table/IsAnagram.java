package hash_table;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-02-27 10:33
 * @Copyright © 2024未来可期
 * 242、有效的字母异位词
 */
public class IsAnagram {
    //方式一
    public boolean isAnagram1(String s, String t) {
        int[] conut1 = encode(s);
        int[] conut2 = encode(t);
        //判断两者中字符出现的次数是否相等
        for (int i = 0; i < conut1.length;i++){
            if (conut1[i] != conut2[i]) return false;
        }
        return true;
    }
    //计算字符出现的次数
    int[] encode(String s){
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            int detail = c-'a';
            count[detail]++;
        }
        return count;
    }


    //方式二：
    public boolean isAnagram(String s, String t){
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c-'a']++;
        }
        for (char c : t.toCharArray()){
            count[c-'a']--;
        }
        //判断，如果现在数组中的元素不为零则false
        for (int num : count){
            if (num != 0) return false;
        }
        return true;
    }
}
