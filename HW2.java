public class HW2 
{
    public static boolean alphabeticalOrder(String inputString)
    {
        if(inputString.length() == 1)
        {
            return true;
        }
        else
        {
            for(int index = 0; index <= inputString.length() - 2; index++)
            {
                if(inputString.charAt(index) >= 65 && inputString.charAt(index) <= 90)
                {
                    if(Character.toLowerCase(inputString.charAt(index)) > Character.toLowerCase(inputString.charAt(index+1)))
                    {
                    return false;
                    }
                }
                if(inputString.charAt(index) >= 97 && inputString.charAt(index) <= 122)
                {
                    if(Character.toLowerCase(inputString.charAt(index)) > Character.toLowerCase(inputString.charAt(index+1)))
                    {
                    return false;
                    }
                }
            }
        }
        return true;
    }
    
    public static String caesarCipher(String inputString, int inputInt) 
    {
        StringBuilder carryOutString = new StringBuilder();
        int charValue;

        for(int index = 0; index <= inputString.length() - 1; index++ )
        {
            if(inputString.charAt(index) >= 48 && inputString.charAt(index) <= 57)
            {
                charValue = (inputString.charAt(index) - 48 + inputInt) % 10;
                carryOutString.append((char)(48 + charValue));
            }
            else if(inputString.charAt(index) >= 65 && inputString.charAt(index) <= 90)
            {
                charValue = (inputString.charAt(index) - 65 + inputInt) % 26;
                carryOutString.append((char)(65 + charValue));
            }
            else if(inputString.charAt(index) >= 97 && inputString.charAt(index) <= 122)
            {
                charValue = (inputString.charAt(index) - 97 + inputInt) % 26;
                carryOutString.append((char)(97 + charValue));
            }
            else
            {
                carryOutString.append(inputString.charAt(index));
            }
        }
        return carryOutString.toString();
    }

    public static String repeatChars(String inputString, int inputInt)
    {
        StringBuilder repeatedString = new StringBuilder();
        
        if(inputInt > 0)
        {
           for(int i = 0; i <= inputString.length() - 1; i++)
           {
             for(int j = 0; j < inputInt; j++)
             {
                repeatedString.append(inputString.charAt(i));
             }
           } 
        }
        else if(inputInt < 0)
        {
            for(int i = 0; i <= inputString.length() - 1; i++)
            {
              for(int j = 0; j < -inputInt; j++)
              {
                 repeatedString.append(inputString.charAt(inputString.length() - i - 1));
              }
            } 
        }
        else if (inputInt == 0)
        {return "";}
        return repeatedString.toString();
    }

    public static String repeatWords(String inputString, int inputInt)
    {
        StringBuilder repeatedWords = new StringBuilder();
        char tempChar;
        StringBuilder tempStr = new StringBuilder();
        StringBuilder tempStrEnd = new StringBuilder();
        if(inputInt == 1)
        {
            return inputString;
        }
        else if (inputInt == 0)
        {
          return "";
        }
        {
            for(int i = 0; i <= inputString.length() - 1; i ++)
            {
              tempChar = inputString.charAt(i);
                if(Character.isAlphabetic(tempChar))
                {
                    tempStr.append(tempChar);
                }
                else if(!Character.isAlphabetic(tempChar))
                {
                    if(tempChar == 32)
                    {
                        if(Character.isAlphabetic(inputString.charAt(i - 1)))
                        {
                          tempStr.append(' ');
                          for(int j = 0; j <= inputInt - 1; j++)
                        {
                          repeatedWords.append(tempStr.toString());
                        }
                        }
                        else if(!Character.isAlphabetic(inputString.charAt(i - 1)))
                        {
                          repeatedWords.append(' ');
                        }
                        tempStr = new StringBuilder();
                    }
                        else if(tempChar != 32 && i != 0)
                    {
                        tempStrEnd.append(tempStr.toString());
                        tempStr.append(' ');
                        if(Character.isAlphabetic(inputString.charAt(i - 1)))
                        {
                            for(int j = 0; j <= inputInt - 2; j++)
                            {
                              repeatedWords.append(tempStr.toString());
                            }
                        }
                        repeatedWords.append(tempStrEnd);
                        repeatedWords.append(inputString.charAt(i));
                        tempStr = new StringBuilder();
                        tempStrEnd = new StringBuilder();
                    }
                       else if(tempChar != 32 && i == 0)
                       {
                         repeatedWords.append(tempChar);
                       }
                }
            }
        }
        return repeatedWords.toString();
    }
    
    public static double[] repeatValues(double[] doubleArray, int inputInt)
    {
        int index = 0;
        double[] array = new double[3*inputInt];
        for(int i = 0; i <= doubleArray.length - 1; i++)
        {
            for(int j = 0; j <= inputInt - 1; j++)
            {
                array[index] = doubleArray[i];
                index++;
            }
        }
        return array;
    }
    
}   