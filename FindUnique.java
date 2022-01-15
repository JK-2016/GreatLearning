import java.lang.Math;
public class FindUnique {
    public static void main(String[] args) {
        int a[]={2,3,7,2,3};
        long bit_num =0 ;
        int k =0, i=0;
        boolean first_match = false;
        while (i <  a.length) {
            if (bit_num==0){
                bit_num=a[i];
                k=i;
            }
            if (i<a.length-1 && a[k]!=a[i+1]){
                first_match = false;
               /* System.out.println("No Match found for: "+a[k]);
                System.out.println("bit_num:"+bit_num);
                System.out.println("log value:"+ (int)(Math.log(bit_num) / Math.log(2)));
                System.out.println("Next num:"+a[i+1]);*/
                bit_num = bit_num + a[i+1]* (long) Math.pow(2,((int)(Math.log(bit_num) / Math.log(2))+1));
            }
            else if(i<a.length-1 && a[k]==a[i+1]){
                /*System.out.println("Match found for: "+a[k]);
                System.out.println("bit_num:"+bit_num);
                System.out.println("Log value: "+ (int) (Math.pow(2,((int)(Math.log(a[i+1]) / Math.log(2))+1))));
                */
                first_match = true;
                bit_num = bit_num/(long) Math.pow(2,((int)(Math.log(a[i+1]) / Math.log(2))+1));
                k=k+1;
                if(bit_num==0){
                    i=i+1;
                }

            }

            /*System.out.println("Match:"+first_match);
            System.out.println("k:"+k);*/
            i++;
        }
        if(bit_num==0){
            bit_num = a[i-1];
        }
        else if(!first_match){
            bit_num=a[k];
        }
        System.out.println("Unique number:"+bit_num);
    }
}