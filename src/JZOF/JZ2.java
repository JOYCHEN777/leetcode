package JZOF;

/*请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class JZ2 {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0)
            return str.toString();
        char[] array = str.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);

        }
        return sb.toString();
    }
}
