

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.sun.bootapp.AppTests;
import org.sun.bootapp.dao.UserDAOTest;
import org.sun.bootapp.dao.UserJdbcDAOTest;
import org.sun.bootapp.service.UserServiceTest;

@RunWith(Suite.class)
@SuiteClasses({UserDAOTest.class, UserJdbcDAOTest.class, UserServiceTest.class, AppTests.class}) 
public class AppSuite {

}
