import com.paypal.bfs.test.employeeserv.api.EmployeeService;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.DataFormatException;
import com.paypal.bfs.test.employeeserv.model.AddressModel;
import com.paypal.bfs.test.employeeserv.repository.AddressRepository;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeServiceImpl;
import com.paypal.bfs.test.employeeserv.util.ModelUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    AddressRepository addressRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEmployeeById(){
        Assert.assertEquals(false,employeeRepository.findById(10l).isPresent());
    }


    @Test
    public void checkEmployeeCreation(){
        Employee employee = new Employee();
        employee.setId(2);
        employee.setFirstName("Abhishek");
        employee.setLastName("Aman");
        employee.setDob("12-12-12");

        Address address = new Address();
        address.setLine2("tdtkf");
        address.setLine1("ahjjhwbe");
        address.setZipcode(1122);
        address.setState("adu");
        address.setCity("ahbwbek");
        address.setCountry("ahjvhbvhvbrhj");

        employee.setAddress(address);

        Employee created = employeeService.createEmployee(employee);
        Assert.assertNotNull(created);

    }

    @Test
    public void checkEmployeeCreationFailure(){
        Employee employee = new Employee();
        employee.setId(2);
        employee.setFirstName("");
        employee.setLastName("");
        employee.setDob("12-12-12");

        Address address = new Address();
        address.setLine2("tdtkf");
        address.setLine1("");
        address.setZipcode(1122);
        address.setState("");
        address.setCity("ahbwbek");
        address.setCountry("ahjvhbvhvbrhj");

        employee.setAddress(address);
        Employee created = null;
        try{
            created = employeeService.createEmployee(employee);
        }catch (DataFormatException e){
            System.out.println(e.getMessage());
        }
        Assert.assertNull(created);
    }
}
