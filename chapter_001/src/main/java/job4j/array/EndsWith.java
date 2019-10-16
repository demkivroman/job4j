package job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post){
        boolean result = true;
        if(post.length <= word.length){
            for (int index = 0; index < post.length; index++){
                if(post[post.length - index - 1] != word[word.length - index - 1]){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
