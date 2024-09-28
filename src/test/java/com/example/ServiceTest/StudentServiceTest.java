package com.example.ServiceTest;


import com.example.Model.Address;
import com.example.Model.Student;
import com.example.Repository.AddressRepository;
import com.example.Repository.StudentRepository;
import com.example.Service.UserService;


import org.junit.jupiter.api.*;
import org.mockito.*;




import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testStudent(){
        Student student=new Student();
        student.setName("John");

        Address address=new Address();
        address.setState("New York");
        address.setCity("NY");

        student.setAddress(address);

        userService.createStudent(student);

        verify(addressRepository, times(1)).save(any(Address.class));
        verify(studentRepository, times(1)).save(any(Student.class));

        ArgumentCaptor<Address> addressArgumentCaptor=ArgumentCaptor.forClass(Address.class);
        verify(addressRepository).save(addressArgumentCaptor.capture());
        assertEquals("New York",addressArgumentCaptor.getValue().getState());
        assertEquals("NY",addressArgumentCaptor.getValue().getCity());

        ArgumentCaptor<Student> studentArgumentCaptor=ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        assertEquals("John",studentArgumentCaptor.getValue().getName());
        assertEquals(address,studentArgumentCaptor.getValue().getAddress());



    }
}
