public class Primes{
    public static void main(String[] args) {
        boolean k;
        for (int i=2;i<100;i++){
            k=true;
            for (int j=2;j<i;j++)
                
             if(i%j==0){
                k=false;
                break;
             }

             if(k==true)
             System.out.println(i);
                
             
        }   
        
                
    }
    
    
}