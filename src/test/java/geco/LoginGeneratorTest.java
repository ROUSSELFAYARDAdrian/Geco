package geco;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class LoginGeneratorTest {

    private LoginGenerator aLoginGenerator;

    @Before
    public void setUp() throws Exception {
        String[] start = new String[]{"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"};
        aLoginGenerator = new LoginGenerator(new LoginService(start));
    }

    @Test
    public void generateLoginForNomAndPrenom() throws Exception {
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        Assert.assertEquals("PDUR", login);
    }

    @Test
    public void generateLoginForJRAL2() throws Exception {
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        Assert.assertEquals("JRAL2", login);
    }

    @Test
    public void loginPDUR2(){
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        Assert.assertEquals("PDUR", login);
    }

    @Test
    public void loginJROLNumber(){
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        Assert.assertEquals("JROL1", login);
    }

    @Test
    public void test_password_generation(){
        int length = 10;
        String str = aLoginGenerator.password_generation(length);
        Assert.assertEquals(length, str.length());
        String str2 = aLoginGenerator.password_generation(length);
        Assert.assertFalse(str.equals(str2));
    }
}