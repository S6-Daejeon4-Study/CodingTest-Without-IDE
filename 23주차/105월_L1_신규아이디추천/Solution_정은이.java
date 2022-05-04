import java.util.regex.Pattern;

class Solution {
    public final Pattern REMOVE_PATTERN = Pattern.compile("[^a-z0-9-_.]");
    public final Pattern REMOVE_DOT_PATTERN = Pattern.compile("[.]{2,}");
    public final Pattern START_END_DOT_PATTERN = Pattern.compile("^[.]|[.]$");
    public String solution(String new_id) {
        new_id=new_id.toLowerCase();
        new_id=removeChar(new_id);
        new_id=removeDot(new_id);
        new_id=removeStartEndDot(new_id);
        if(new_id.length()==0) return "aaa";

        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
            return removeStartEndDot(new_id);
        }
        String last = new_id.charAt(new_id.length()-1)+"";
        if(new_id.length()==2) return new_id+last;
        if(new_id.length()==1) return new_id+last+last;

        return new_id;
    }
    public String removeChar(String new_id){
        return REMOVE_PATTERN.matcher(new_id).replaceAll("");
    }
    public String removeDot(String new_id){
        return REMOVE_DOT_PATTERN.matcher(new_id).replaceAll(".");
    }
    public String removeStartEndDot(String new_id){
        return START_END_DOT_PATTERN.matcher(new_id).replaceAll("");
    }
}