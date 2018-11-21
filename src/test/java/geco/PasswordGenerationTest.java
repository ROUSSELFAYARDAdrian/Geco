package geco;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class PasswordGenerationTest {

    private int length = 10;
    private String empty = "";
    private PasswordGeneration passGen;

    @Before
    public void setUp() throws Exception {
        passGen = new PasswordGeneration();
    }

    @Test
    public void generate() {
        String str = passGen.generate(length);
        Assert.assertEquals(length, str.length());
        String str2 = passGen.generate(length);
        Assert.assertEquals(length, str2.length());
        Assert.assertFalse(str.equals(str2));
    }
}