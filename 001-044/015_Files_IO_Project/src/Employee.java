import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable 
{
	private Integer empId;
	private String lastName;
	private String firstName;
	private Date dob;
	private transient Integer ssnId;
	private Integer dlId;
	private String address;

	public Employee(Integer empId, String lastName, String firstName, Date dob, Integer ssnId, Integer dlId,
			String address) {
		super();
		this.empId = empId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dob = dob;
		this.ssnId = ssnId;
		this.dlId = dlId;
		this.address = address;
	}

	public Employee() {
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getSsnId() {
		return ssnId;
	}

	public void setSsnId(Integer ssnId) {
		this.ssnId = ssnId;
	}

	public Integer getDlId() {
		return dlId;
	}

	public void setDlId(Integer dlId) {
		this.dlId = dlId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee Details {empId=" + empId + ", lastName=" + lastName + ", firstName=" + firstName + ", dob="
				+ dob + ", ssnId=" + ssnId + ", dlId=" + dlId + ", address=" + address + "}";
	}

}
