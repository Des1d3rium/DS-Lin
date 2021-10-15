public class HW2 
{


    public static alphabeticalOrder(String inputString)
    {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int index = 0; index <= inputString.length() - 1; index++)
        {
            if(inputString.charAt(index)>=65&&inputString.charAt(index)<=90)
            {
                if(inputString.charAt(index)>inputString.charAt(index+1))
                {
                    return false;
                }
                else if(inputString.charAt(index)>inputString.charAt(index+32))
                {
                    return false;
                }
            }
            else if(inputString.charAt(index)>=97&&inputString.charAT(index)<=122)
            {
                if(inputString.charAt(index)>inputString.charAt(index+1))
                {
                    return false;
                }
                else if(inputString.charAt(index)>inputString.charAt(index-32))
                {
                    return false;
                }
            }
        }
    }
}