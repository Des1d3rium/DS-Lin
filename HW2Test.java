import org.junit.*;
import static org.junit.Assert.*;

public class HW2Test
{
    @Test
    public void testAlphabeticalOrder()
    {
        assertEquals(false, HW2.alphabeticalOrder("apple"));
        assertEquals(false, HW2.alphabeticalOrder("CoFFee"));
        assertEquals(true, HW2.alphabeticalOrder("abcde"));
        assertEquals(true, HW2.alphabeticalOrder("ABCDE"));
        assertEquals(true, HW2.alphabeticalOrder("AbCde"));
        assertEquals(true, HW2.alphabeticalOrder("a"));
        assertEquals(true, HW2.alphabeticalOrder("Z"));
        assertEquals(true, HW2.alphabeticalOrder(""));
    }
    
    @Test
    public void testCaesarCipher()
    {
      assertEquals("B Rvja Bcpvu Afcsbt po Nbz 24!", HW2.caesarCipher("A Quiz About Zebras on May 13!", 1));
      assertEquals("", HW2.caesarCipher("",1));
      assertEquals("b", HW2.caesarCipher("z",2));
    }
    
    @Test
    public void testRepeatChars()
    {
      assertEquals("aaabbbccc   ddd", HW2.repeatChars("abc d", 3));
      assertEquals("ddd   cccbbbaaa", HW2.repeatChars("abc d", -3));
      assertEquals("", HW2.repeatChars("abc d", 0));
      assertEquals("abc d", HW2.repeatChars("abc d", 1));
    }
    
    @Test
    public void testRepeatWord()
    {
      assertEquals("'How How are are you you?', I I asked asked.", HW2.repeatWords("'How are you?', I asked.", 2));
      assertEquals("Writing Writing Writing Java Java Java is is is so so so hard hard hard.",HW2.repeatWords("Writing Java is so hard.", 3));
      assertEquals("'How are you?', I asked.",HW2.repeatWords("'How are you?', I asked.", 1));
      assertEquals("",HW2.repeatWords("'How are you?', I asked.", 0));
    }
    
     @Test
     public void testRepeatValues()
     {
       double[] input = {1.1, 2.2, 3.3};
       double[] output = {1.1, 1.1, 1.1, 2.2, 2.2, 2.2, 3.3, 3.3, 3.3};
       assertArrayEquals(output, HW2.repeatValues(input, 3), 0.1);
     }
}