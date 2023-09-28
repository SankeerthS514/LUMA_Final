import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function Loanlist() {
  const [employees, setEmployees] = useState([]);
  const params = useParams();

  const getAll = async (empid) => {
    const response = await axios.get(`http://localhost:8080/api/v5/loan`);
    console.log("This is from get All", response.data);
    return response.data;
  };

  useEffect(() => {
    const fetchData = async () => {
      const response = await getAll(params.empid);
      // Initialize the action and status properties for each employee
      const employeesWithStatus = response.map((employee) => ({
        ...employee,
        action: '',
        status: employee.status,
      }));
      setEmployees(employeesWithStatus);
      console.log("This is from useEffect", employeesWithStatus);
    };
    fetchData();
  }, [params.empid]);

  function formatDate(dateString) {
    if(!dateString)
          return "";
    const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
    const date = new Date(dateString);
    return date.toLocaleDateString('en-GB', options);
  }

  const handleActionChange = async (event, employee) => {
    const newEmployees = [...employees];
    const index = newEmployees.findIndex((e) => e.id === employee.id);
    newEmployees[index].action = event.target.value;
    // Update the status based on the selected action
    newEmployees[index].status =
      event.target.value === 'Approve' ? 'Approved' :
       (event.target.value==='Reject'?'Rejected': 'Closed');  
        setEmployees(newEmployees);
  
    // Make an API call to update the loan status in the backend
    try {
      await axios.put(`http://localhost:8080/api/v5/loan/${employee.id}`, {
        status: newEmployees[index].status,
      });
      console.log('Loan status updated in the backend.');
    } catch (error) {
      console.error('Error updating loan status:', error);
    }
  };
  

  return (
    <div>
      <center>
        <div className='container' style={{ "paddingTop": "7%" }}>
          <div><h1>Loan Dashboard</h1></div><br/>
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th><center>Loan-Id</center></th>
                <th><center>Employee-Id</center></th>
                <th><center>Item Catagory</center></th>
                <th><center>Item Description</center></th>
                <th><center>Item Made of</center></th>
                <th><center>Duration in years</center></th>
                <th><center>Value</center></th>
                <th><center>Issue Date</center></th>
                <th><center>Status</center></th>
                <th><center>Action</center></th>
              </tr>
            </thead>
            <tbody>
              {employees.map((employee) => (
                <tr key={employee.id}>
                  <td><center>{employee.id}</center></td>
                  <td><center>{employee.empid}</center></td>
                  <td><center>{employee.item_cat}</center></td>
                  <td><center>{employee.item_make}</center></td>
                  <td><center>{employee.item_desc}</center></td>
                  <td><center>{employee.duration_in_years}</center></td>
                  <td><center>{employee.item_value}</center></td>
                  <td><center>{formatDate(employee.issue_date)}</center></td>
                  <td><center>{employee.status}</center></td>
                  <td>
                    <select
                      value={employee.action || ''}
                      onChange={(e) => handleActionChange(e, employee)}
                      className="form-control"
                    >
                      <option value="">Select Action</option>
                      <option value="Approve">Approve</option>
                      <option value="Reject">Reject</option>
                      <option value="Close">Close</option>
                    </select>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <br />
      </center>
    </div>
  );
}

export default Loanlist;
