public class Palindrome
{
    public static void main(String[] args) 
        {
            
        for (int i = 0; i < args.length; i++)
            {
             String s= args[i];
             String p=reverseString(s);  
        if(isPalindrome(s,p)) System.out.println("yes");
        System.out.println("no");
            }
        }
    public static String reverseString(String s) 
     {
        String p = "";
        for (int i = 0; i < s.length(); i++)
            {
            p+=s.charAt(s.length()-i-1);
            }
      
        return p;
     }
     public static boolean isPalindrome(String s,String p)
     {
        
        if(s.equals(p))  return false;
        return true;
        
     }
     
     
     
}

