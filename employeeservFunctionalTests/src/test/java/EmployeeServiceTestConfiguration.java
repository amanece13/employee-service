import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeModel;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeServiceImpl;
import com.paypal.bfs.test.employeeserv.util.ModelUtil;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceTestConfiguration {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void pos_create_emp_test(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Aman");
        employee.setLastName("Abhishek");
        employee.setDob("12-12-12");
        Address address = new Address();

        address.setCity("c");
        address.setLine1("l");
        address.setCountry("c");
        address.setLine2("");
        address.setState("s");
        address.setZipcode(1);
        employee.setAddress(address);
        EmployeeModel resourceEmployee = null;
        try {
            resourceEmployee = employeeRepository.save(ModelUtil.getEmployeeModel(employee));

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(resourceEmployee);
    }

}
