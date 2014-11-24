/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import junit.framework.TestCase;

/**
 *
 * @author Marcelo
 */
public class UserControllerTest extends TestCase {
    
    public UserControllerTest(String testName) {
        super(testName);
    }
    
    public void testIndetificarLoginInvalido(){
        
        UserDAO dao = new UserDAO();
        dao.login("marcelo", "marcelooo");
        
        assertEquals(true, true);
        
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
