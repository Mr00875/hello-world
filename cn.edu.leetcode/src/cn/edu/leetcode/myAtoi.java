package cn.edu.leetcode;
/**
* @author 作者
* @version 创建时间：2018年12月22日 上午11:03:40
* 类说明
*/
public class myAtoi {
	public static int myAtoi(String str) {
        if(str.equals("")){
            return 0;
        }
        while(str.startsWith(" ")){
			str = str.replaceFirst(" ","");
		}
        if(str.equals("")){
            return 0;
        }
		if((str.startsWith("-")||str.startsWith("+"))||(str.charAt(0)<="9".charAt(0)&&str.charAt(0)>="0".charAt(0))){
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(0));
            if((str.startsWith("-")||str.startsWith("+"))&&str.length()==1){
				return 0;
			}else{
                str = str.substring(1);
            }
			
			for(char c:str.toCharArray()){
				if(c<='9'&&c>='0'){
					sb.append(String.valueOf(c));
				}else{
                    break;
                }
			}
			try{
                String str1 = sb.toString();
				return Integer.parseInt(str1);
			}catch(NumberFormatException e){
                if(sb.toString().startsWith("-")&&sb.toString().length()>1){
                    return Integer.MIN_VALUE;
                }else if(sb.toString().length()>1){
                    return Integer.MAX_VALUE;
                }else{
                    return 0;
                }
				
			}
		}else{
			return 0;
		}
    }
	public static void main(String[] args) {
		System.out.println(myAtoi("-42"));
	}
}
